package com.tungsten.fcl.control

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mio.ui.applySelectableItemStyle
import com.tungsten.fcl.databinding.DialogControllerIconBinding
import com.tungsten.fcl.databinding.ItemControllerIconBinding
import com.tungsten.fcllibrary.component.dialog.FCLDialog
import com.tungsten.fcllibrary.util.ConvertUtils

/** Visual, lossless-vector icon chooser used by controller buttons. */
class ControllerIconDialog(
    context: Context,
    selectedId: String,
    private val callback: (ControllerIconRegistry.Icon) -> Unit,
) : FCLDialog(context) {
    private val binding = DialogControllerIconBinding.inflate(layoutInflater)

    init {
        setContentView(binding.root)
        val metrics = context.resources.displayMetrics
        val width = minOf(metrics.widthPixels - ConvertUtils.dip2px(context, 32f), ConvertUtils.dip2px(context, 560f))
        val height = minOf((metrics.heightPixels * 0.82f).toInt(), ConvertUtils.dip2px(context, 620f))
        window?.setLayout(width, height)
        binding.icons.layoutManager = GridLayoutManager(context, if (metrics.widthPixels >= ConvertUtils.dip2px(context, 600f)) 5 else 4)
        binding.icons.adapter = IconAdapter(context, selectedId) { icon ->
            callback(icon)
            dismiss()
        }
        binding.cancel.setOnClickListener { dismiss() }
    }

    private class Holder(val binding: ItemControllerIconBinding) : RecyclerView.ViewHolder(binding.root)

    private class IconAdapter(
        private val context: Context,
        private val selectedId: String,
        private val onClick: (ControllerIconRegistry.Icon) -> Unit,
    ) : RecyclerView.Adapter<Holder>() {
        private val density = context.resources.displayMetrics.density

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = Holder(
            ItemControllerIconBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

        override fun onBindViewHolder(holder: Holder, position: Int) {
            val icon = ControllerIconRegistry.icons[position]
            holder.binding.icon.setImageResource(icon.drawableRes)
            holder.binding.name.setText(icon.labelRes)
            applySelectableItemStyle(context, holder.binding.root, null, icon.id == selectedId, density)
            holder.binding.root.setOnClickListener { onClick(icon) }
        }

        override fun getItemCount() = ControllerIconRegistry.icons.size
    }
}
