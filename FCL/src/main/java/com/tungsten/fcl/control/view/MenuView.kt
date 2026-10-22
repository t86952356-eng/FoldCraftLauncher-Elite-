package com.tungsten.fcl.control.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.graphics.Path
import android.text.TextPaint
import android.text.TextUtils
import android.text.format.DateFormat
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewConfiguration
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.target.CustomViewTarget
import com.bumptech.glide.request.transition.Transition
import com.mio.util.getUsedMemory
import com.mio.util.getTotalMemory
import com.tungsten.fclauncher.bridge.FCLBridge
import com.mio.util.getScreenHeight
import com.mio.util.getScreenWidth
import com.tungsten.fcl.R
import com.tungsten.fcl.control.GameMenu
import com.tungsten.fclauncher.utils.FCLPath
import com.tungsten.fcllibrary.util.ConvertUtils
import java.io.File
import kotlin.math.abs

/**
 * 游戏内菜单悬浮按钮：轻点打开两侧抽屉，未锁定时可拖动换位置（位置按屏幕比例持久化）。
 */
class MenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : View(context, attrs) {

    private val screenWidth = getScreenWidth()
    private val screenHeight = getScreenHeight()

    /** 点击判定位移阈值，随屏幕密度缩放（原硬编码 10px 在高密度屏上过小，点击易失灵） */
    private val touchSlop = ViewConfiguration.get(context).scaledTouchSlop

    private lateinit var gameMenu: GameMenu

    private var isGif = false
    private var pressed = false

    private var icon: Bitmap? = null
    private var gif: GifDrawable? = null
    private var gifTarget: CustomViewTarget<MenuView, GifDrawable>? = null
    private val density = resources.displayMetrics.density
    private val strokePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        style = Paint.Style.STROKE
        strokeWidth = 1.5f * density
    }
    private val areaPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val iconPaint = Paint(Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
    private val titlePaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.WHITE
        textSize = 14f * resources.displayMetrics.scaledDensity
        typeface = android.graphics.Typeface.DEFAULT_BOLD
    }
    private val statsPaint = TextPaint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.LTGRAY
        textSize = 9f * resources.displayMetrics.scaledDensity
    }
    private val iconClip = Path()
    private val cardRect = RectF()
    private val imageRect = RectF()
    private var statsText = ""
    private val statsTick = object : Runnable {
        override fun run() {
            refreshStats()
        }
    }

    fun setup(gameMenu: GameMenu) {
        this.gameMenu = gameMenu
        initIcon()
        refreshStats()
    }

    /** Samples actual game FPS and system RAM, not the Android UI frame rate. */
    fun refreshStats() {
        removeCallbacks(statsTick)
        if (!::gameMenu.isInitialized) return
        val setting = gameMenu.menuSetting
        val values = mutableListOf<String>()
        if (setting.isMenuShowFps) values += "FPS ${if (gameMenu.isSimulated) 0 else FCLBridge.getFps()}"
        if (setting.isMenuShowRam) {
            val total = getTotalMemory(context)
            val used = getUsedMemory(context)
            val percent = if (total > 0) (used * 100 / total).coerceIn(0, 100) else 0
            values += context.getString(R.string.menu_view_ram_value, percent)
        }
        if (setting.isMenuShowTime) {
            values += DateFormat.getTimeFormat(context).format(java.util.Date())
        }
        statsText = values.joinToString("  •  ")
        invalidate()
        if (isAttachedToWindow && isShown && windowVisibility == VISIBLE && values.isNotEmpty()) {
            postDelayed(statsTick, 1000L)
        }
    }

    fun initPosition() {
        post {
            if (!::gameMenu.isInitialized) return@post
            val setting = gameMenu.menuSetting
            val scale = setting.menuScale / 100f
            val defaultWidth = minOf(screenWidth, ConvertUtils.dip2px(context, setting.menuLength * scale))
            val defaultHeight = minOf(screenHeight, ConvertUtils.dip2px(context, 48f * scale))
            layoutParams.width = defaultWidth
            layoutParams.height = defaultHeight
            layoutParams = layoutParams
            x = (screenWidth * gameMenu.menuSetting.menuPositionX).toFloat()
                .coerceIn(0f, (screenWidth - defaultWidth).coerceAtLeast(0).toFloat())
            y = (screenHeight * gameMenu.menuSetting.menuPositionY).toFloat()
                .coerceIn(0f, (screenHeight - defaultHeight).coerceAtLeast(0).toFloat())
        }
    }

    fun refreshAppearance() {
        initPosition()
        invalidate()
    }

    private fun initIcon() {
        if (File(FCLPath.FILES_DIR, "menu_icon.png").exists()) {
            icon = BitmapFactory.decodeFile(File(FCLPath.FILES_DIR, "menu_icon.png").absolutePath)
        } else if (File(FCLPath.FILES_DIR, "menu_icon.gif").exists()) {
            isGif = true
            val target = object : CustomViewTarget<MenuView, GifDrawable>(this) {
                override fun onLoadFailed(errorDrawable: Drawable?) {
                    isGif = false
                    icon = BitmapFactory.decodeResource(context.resources, R.drawable.img_app)
                    invalidate()
                }

                override fun onResourceReady(resource: GifDrawable, transition: Transition<in GifDrawable>?) {
                    gif = resource
                    resource.callback = this@MenuView
                    updateGifPlayback()
                    invalidate()
                }

                override fun onResourceCleared(placeholder: Drawable?) {
                    gif?.stop()
                    gif?.callback = null
                    gif = null
                }
            }
            gifTarget = target
            Glide.with(this).asGif().skipMemoryCache(true)
                .load(File(FCLPath.FILES_DIR, "menu_icon.gif")).into(target)
        }
        if (!isGif && icon == null) {
            icon = BitmapFactory.decodeResource(context.resources, R.drawable.img_app)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (!::gameMenu.isInitialized) return
        if (height <= 0 || width <= 0) return
        val outerSave = canvas.save()
        val drawScale = height / (48f * density)
        canvas.scale(drawScale, drawScale)
        val logicalWidth = width / drawScale
        val logicalHeight = 48f * density
        cardRect.set(density, density, logicalWidth - density, logicalHeight - density)
        areaPaint.color = if (pressed) 0xFF303844.toInt() else 0xFF161C26.toInt()
        areaPaint.alpha = gameMenu.menuSetting.menuBackgroundOpacity * 255 / 100
        canvas.drawRoundRect(cardRect, 10f * density, 10f * density, areaPaint)

        val cx = 24f * density
        val cy = logicalHeight / 2f
        val radius = minOf(18f * density, logicalHeight / 2f - 3f * density)
        val checkpoint = canvas.save()
        iconClip.reset()
        iconClip.addCircle(cx, cy, radius, Path.Direction.CW)
        canvas.clipPath(iconClip)
        areaPaint.color = Color.DKGRAY
        canvas.drawCircle(cx, cy, radius, areaPaint)
        // Center-crop inside the circular clip, for both PNG and animated GIF.
        val bitmap = icon
        val animated = gif
        val sourceWidth = animated?.intrinsicWidth ?: bitmap?.width ?: 0
        val sourceHeight = animated?.intrinsicHeight ?: bitmap?.height ?: 0
        if (sourceWidth > 0 && sourceHeight > 0) {
            val scale = maxOf(radius * 2 / sourceWidth, radius * 2 / sourceHeight)
            val halfWidth = sourceWidth * scale / 2f
            val halfHeight = sourceHeight * scale / 2f
            imageRect.set(cx - halfWidth, cy - halfHeight, cx + halfWidth, cy + halfHeight)
            if (animated != null) {
                animated.setBounds(imageRect.left.toInt(), imageRect.top.toInt(), imageRect.right.toInt(), imageRect.bottom.toInt())
                animated.draw(canvas)
            } else if (bitmap != null) {
                canvas.drawBitmap(bitmap, null, imageRect, iconPaint)
            }
        }
        canvas.restoreToCount(checkpoint)
        canvas.drawCircle(cx, cy, radius, strokePaint)

        val textX = 50f * density
        val available = (logicalWidth - textX - 8f * density).coerceAtLeast(0f)
        val titleBaseline = if (statsText.isEmpty()) {
            cy - (titlePaint.ascent() + titlePaint.descent()) / 2
        } else {
            cy - 3f * density
        }
        val title = TextUtils.ellipsize(context.getString(R.string.menu_view_title), titlePaint, available, TextUtils.TruncateAt.END)
        canvas.drawText(title.toString(), textX, titleBaseline, titlePaint)
        if (statsText.isNotEmpty()) {
            val stats = TextUtils.ellipsize(statsText, statsPaint, available, TextUtils.TruncateAt.END)
            canvas.drawText(stats.toString(), textX, cy + 12f * density, statsPaint)
        }
        canvas.restoreToCount(outerSave)
    }

    private fun updateGifPlayback() {
        val playing = isAttachedToWindow && isShown && windowVisibility == VISIBLE
        gif?.setVisible(playing, false)
        if (playing) gif?.start() else gif?.stop()
    }

    override fun verifyDrawable(who: Drawable): Boolean = who === gif || super.verifyDrawable(who)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        if (::gameMenu.isInitialized && isGif && gifTarget == null) initIcon()
        updateGifPlayback()
        refreshStats()
    }

    override fun onDetachedFromWindow() {
        removeCallbacks(statsTick)
        gif?.stop()
        gifTarget?.let { Glide.with(context).clear(it) }
        gifTarget = null
        super.onDetachedFromWindow()
    }

    override fun onVisibilityChanged(changedView: View, visibility: Int) {
        super.onVisibilityChanged(changedView, visibility)
        // View's constructor can call this before Kotlin fields are initialized.
        if (::gameMenu.isInitialized) {
            updateGifPlayback()
            refreshStats()
        }
    }

    override fun onWindowVisibilityChanged(visibility: Int) {
        super.onWindowVisibilityChanged(visibility)
        if (::gameMenu.isInitialized) {
            updateGifPlayback()
            refreshStats()
        }
    }

    // 按下点的屏幕坐标：拖动会 setX/setY 移动 View 本身，松手时相对坐标差恒为 0，
    // 点击判定必须用不受 View 位移影响的 raw 坐标，否则快速拖动会被误判为点击
    private var downX = 0f
    private var downY = 0f
    private var downRawX = 0f
    private var downRawY = 0f
    private var downTime = 0L

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
                downRawX = event.rawX
                downRawY = event.rawY
                downTime = event.eventTime
                pressed = true
                invalidate()
            }

            MotionEvent.ACTION_MOVE -> {
                if (!gameMenu.menuSetting.isLockMenuView) {
                    val targetX = (x + event.x - downX)
                        .coerceIn(0f, (screenWidth - measuredWidth).coerceAtLeast(0).toFloat())
                    val targetY = (y + event.y - downY)
                        .coerceIn(0f, (screenHeight - measuredHeight).coerceAtLeast(0).toFloat())
                    x = targetX
                    y = targetY
                    gameMenu.menuSetting.menuPositionX = (targetX / screenWidth).toDouble()
                    gameMenu.menuSetting.menuPositionY = (targetY / screenHeight).toDouble()
                }
            }

            MotionEvent.ACTION_UP -> {
                // 点击 = 手指实际位移未超 touchSlop 且未到长按时长，打开两侧抽屉
                if (abs(event.rawX - downRawX) <= touchSlop
                    && abs(event.rawY - downRawY) <= touchSlop
                    && event.eventTime - downTime <= ViewConfiguration.getLongPressTimeout()
                ) {
                    performClick()
                    (gameMenu.layout as DrawerLayout).apply {
                        openDrawer(GravityCompat.START, true)
                        openDrawer(GravityCompat.END, true)
                    }
                }
                pressed = false
                invalidate()
            }

            MotionEvent.ACTION_CANCEL -> {
                // 父容器拦截/系统打断，不算点击，只复位按压态
                pressed = false
                invalidate()
            }
        }
        return true
    }
}
