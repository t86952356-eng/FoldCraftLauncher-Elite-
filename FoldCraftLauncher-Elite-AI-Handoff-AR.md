# تحديث ملف التسليم — FoldCraftLauncher-Elite — 2026-10-22

> **اقرأ هذا الملخص أولًا:** الأقسام الأصلية أدناه محفوظة كسجل تاريخي حتى 1.3.4.1، وليست وصفًا لأحدث حالة. أُنجز ونُشر بعدها 1.3.4.2. يجري الآن تجهيز 1.3.4.3 بناءً على طلب المستخدم الصريح بالتعديل والبناء ونشر Release. لا تعتبر 1.3.4.3 منشورًا حتى يضاف سجل التحقق النهائي في نهاية هذا الملف.
>
> المشروع: `t86952356-eng/FoldCraftLauncher-Elite-`، الفرع `main`. الشرطة الأخيرة ضرورية. تحقق من GitHub الحي قبل أي متابعة ولا تعِد تنفيذ التعديلات المنشورة. لا تضع أي Token أو مفتاح توقيع في هذا الملف.

## أحدث تعليمات المستخدم في هذه الجلسة

- تنفيذ التعديلات في السورس، بناء APK ونشر Release، وليس تقديم اقتراح فقط.
- الأشكال الجديدة **24**: التسعة المذكورة + خمسة عشر إضافيًا؛ «كابستر» يعني مكثفًا كهربائيًا. صُمم Motion كخط متموج، ولم يُترك.
- استعادة إعدادات Add Style الأصلية، لا استبدالها بإعدادات مبتكرة.
- تعديل Menu View وإزاحة الأيقونة والخط كما في سجل التحديث أدناه.
- إبقاء ملف MD محدثًا في كل تحديث، شاملاً العمل السابق والجديد، والمشاكل والحلول ومسارات الكود وخطوات البناء والنشر.
- لا تدّعِ تجربة جهاز Android لم تُجرَ. نجاح اختبارات JVM أو البناء ليس اختبار واجهة أو لعبة على جهاز.

---

## نسخة التسليم الأصلية — سجل تاريخي محفوظ

# ملف تسليم محادثة ومشروع FoldCraftLauncher-Elite إلى مساعد AI جديد

> اقرأ هذا الملف أولًا لفهم المشروع والعمل السابق. المطلوب الآن: انتظار ربط حساب GitHub ثم انتظار طلبات تعديل جديدة، لا إعادة تنفيذ التعديلات القديمة أو نشر إصدار جديد تلقائيًا.
>
> هذا توثيق للمحادثة والنتائج التاريخية المسجلة فيها، وليس فحصًا مباشرًا جديدًا لحالة GitHub وقت قراءة الملف. يتضمن الطلب الأصلي وسجل الحوار وشرح التنفيذ والمشاكل وخطة البناء والنشر. لا يتضمن رموز وصول أو كلمات مرور أو مفاتيح توقيع.

## 1. رسالة البداية للمساعد الجديد

أنا صاحب مشروع Android التالي:

- الحساب: `t86952356-eng`
- المستودع الدقيق: `FoldCraftLauncher-Elite-` — الشرطة الأخيرة جزء من الاسم.
- الرابط: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-
- الفرع الذي جرى العمل عليه: `main`.
- موضوع العمل: Theme / Style وتخصيص أزرار Controller في Fold Craft Launcher.
- أريد تنفيذ تعديلات فعلية في السورس على GitHub، وليس مجرد اقتراح كود في المحادثة.
- أحتاج دقة عالية، وتعديلات محدودة، وعدم كسر البناء أو ملفات التحكم القديمة.
- بعد قراءة الملف، اطلب ربط GitHub عبر وسيلة الربط الآمنة المتاحة في بيئتك إن لم يكن مربوطًا، ثم انتظر طلبي الجديد. لا تطلب لصق Token في المحادثة.
- لا تفترض انتقال صلاحيات الجلسة السابقة إلى جلستك. تحقّق من الحساب وصلاحية الوصول للمستودع قبل الكتابة.
- لا تعِد إضافة ميزة الأيقونات؛ هي أُضيفت ونُشرت سابقًا كما هو موضح أدناه. افحص الحالة الحالية أولًا.
- نشر Release أو تغيير إعدادات Actions ليس مطلوبًا بمجرد قراءة هذا الملف؛ انتظر الطلب المناسب.
- لغتي المفضلة في الشرح: العربية، ويمكن إبقاء أسماء الملفات والكود والمصطلحات التقنية بالإنجليزية.
- أفضل Claude Opus 5.5 إن كان متاحًا فعلًا؛ هذا تفضيل وليس تغييرًا تلقائيًا للنموذج. لا تدّعِ استخدامه أو التبديل إليه دون تأكيد من بيئتك.

رد افتتاحي مقترح:

> فهمت المشروع والتعديلات السابقة وخطوات البناء والنشر. اربط حساب GitHub إن لم يكن مربوطًا، ثم أرسل طلب التعديل التالي. سأفحص أحدث السورس أولًا ولن أعيد تنفيذ الميزة أو أنشر إصدارًا دون طلب.

## 2. الحالة عند نهاية المحادثة السابقة

| البند | الحالة التاريخية الموثقة |
|---|---|
| ميزة أيقونات أزرار التحكم | رُفعت إلى `main` |
| Commit الميزة | `49e2feb01d427a4b0a3ef7507e62e4af2baadfeb` |
| فحص XML محلي | نجح تحليل 34 ملف XML ضمن نطاق الفحص |
| قائمة الأيقونات | 29 خيارًا = 28 أيقونة + `none` |
| عدد الملفات المعدّة لرفع الميزة | 39 ملفًا |
| Build على GitHub Actions | `completed / success` للالتزام المذكور |
| Check Codes | `completed / success` للالتزام المذكور |
| Check Codes Comment | `skipped`؛ ليس فشلًا في البناء |
| Release منشور | `1.3.4.1`، ليس Draft وليس Prerelease حسب نتيجة API المسجلة |
| ملفات APK المنشورة | خمسة: all، arm64-v8a، armeabi-v7a، x86، x86_64 |
| Commit إضافة سير النشر | `02d70cd52e71e9cacb68f4d010a774b1acbda77c` |
| target_commitish في نتيجة Release | `02d70cd52e71e9cacb68f4d010a774b1acbda77c` |
| اختبار تثبيت وتشغيل على جهاز Android | لا يوجد توثيق لاختبار فعلي على جهاز في هذه المحادثة |

**مهم:** نجاح البناء لا يثبت وحده سلامة كل تفاصيل واجهة الاستخدام. إعادة التحقق من SHA والـTag وملفات APK مطلوبة عند المتابعة. لا تعتبر `1.3.4.1` أحدث إصدار حاليًا دون قراءة GitHub مجددًا.

### روابط المرجع

- الميزة: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/commit/49e2feb01d427a4b0a3ef7507e62e4af2baadfeb
- Build: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/actions/runs/39635833465
- Check Codes: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/actions/runs/39635833650
- نشر الإصدار: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/actions/runs/39639899578
- Release: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/releases/tag/1.3.4.1
- إضافة Workflow النشر: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/commit/02d70cd52e71e9cacb68f4d010a774b1acbda77c
- Workflow النشر: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/blob/main/.github/workflows/publish-release.yml

## 3. طلب المستخدم الأصلي — النص

> ادخل الى مشروعي في github وهو fold craft سنقوم بتعديلات Theme والستايل.مهمتنا دقيقه وتطلب خبره عاليه بالبرمجه وتجنب اخطاء لأننا نعدل ملف سورس apk في github .وكل تعديلات اضفها الى مشروع مباشره:
> اولا في تخصيص تحكم Controller في Edit button (المسؤول في تحكم اعدادات الزر وتخصيصه) اضف خيار جديد بأسم Icon في تبويب Base View Info فحين اضقطه يضهر لي اشكال اقيونات عديده باللون ابيض مصممه بصيغه xml للحصول على افضل جوده وعند اختيار ايقون معينه يضهر شكلها في زر محدد فوق displayed Text (اسم زر) ويمكن تحكم بحجم ايقون وأرتفاعه (بالنسبه للأرتفاع فلا يجب ان يتجاوز حدود زر اي يصبح خارج اطار زر)، وأما عن اشكال فتكون مصممه باللون ابيض وفيها تفاصل جميله ليست بسيطه جدا ولا كثيره تفاصل والفكره اساسيه هي اشكال مثل شكل بيكاكس لأضافته مع زر تكسير وشكل عين لأضافته مع زر تدبيل كامرا (F5) وغيرها مثل شكل اكس وا سيف وا لاعب يركض ولاعب واقف وا شكل بوست («) وا كامره وا كيبورد وا ماوس وا ساعقه وا شبح وا مكعب وا علامه اكس وا قوس وا سهم وا حقيبه وا مؤشر سهم للاعلى وا مؤشر سهم للاسفل وا شكل النسخ وا شكل اللصق وا شكل شات وا شكل شاشه وا شكل قلم وا شكل نجمه وا شكل واي فاي وا شكل بلاتوث وا شكل قمر.مع مراعه حفظ التحكم اي ستكون ميزه مثل باقي مميزات يمكن حفظها وعند مشاركة تحكم لشخص لديه نفس الانشر بنفس تعديل ستضهر هاذه اشكال.

وأرفق المستخدم تفضيله لـClaude Opus 5.5.

### المتطلبات المستخلصة دون تغيير المعنى

1. مكان الإعداد: Controller → Edit button → Base View Info.
2. خيار جديد باسم `Icon` يفتح منتقيًا مرئيًا متعدد الأيقونات.
3. الأيقونات بيضاء، بصيغة XML Vector Drawable، متوسطة التفاصيل.
4. تعرض الأيقونة فوق `Displayed Text` للزر المحدد.
5. تحكم بالحجم والارتفاع، مع منع خروج الأيقونة من إطار الزر.
6. حفظ إعدادات الأيقونة داخل ملفات التحكم مثل بقية الإعدادات.
7. عند مشاركة التحكم مع مستخدم لديه النسخة المعدّلة نفسها، تظهر الأيقونات دون إرسال صور منفصلة.
8. رفع التغييرات الفعلية إلى المستودع.

**نقطة تحتاج انتباهًا في الطلبات المستقبلية:** التنفيذ السابق وفّر `iconWidth` و`iconHeight`، أي عرض وارتفاع الأيقونة، وليس منزلقًا منفصلًا للإزاحة الرأسية `verticalOffset`. لا تخلط بين ارتفاع الشكل وبين موضعه الرأسي. إن طلب المستخدم تحريك الأيقونة لأعلى/أسفل فهذه إضافة مختلفة، ولا تفترض أنها موجودة بالفعل.

## 4. سجل المحادثة الظاهر للمستخدم

هذا القسم يحفظ تسلسل الطلبات والردود ذات الصلة. روابط الأدلة مجمعة في قسم المراجع أعلاه. الردود أدناه تصف ما أُعلن في وقتها، لا نتائج فحص جديد.

### 4.1 تحديد المستودع

**المساعد:** أرسل رابط مستودع Fold Craft على GitHub؛ الحساب المتصل هو `t86952356-eng` لكن المستودع لا يظهر ضمن نتائجه، وهناك عدة مستودعات تحمل اسمًا مشابهًا، لذلك لا أريد تعديل المشروع الخطأ. بعد الرابط سأفحص بنية المشروع ونظام حفظ إعدادات الـController، ثم أنفّذ الميزة وأرفع التعديلات مباشرةً مع التحقق من البناء والتوافق.

**المستخدم:** https://github.com/t86952356-eng/FoldCraftLauncher-Elite-

### 4.2 إتمام ميزة الأيقونات

**المساعد:** تم تنفيذ الميزة ورفعها مباشرةً إلى فرع `main` في مشروع FoldCraftLauncher-Elite ضمن الالتزام `49e2feb`.

أُضيف:

- خيار Icon داخل Base View Info.
- شبكة مرئية لاختيار 28 أيقونة XML بيضاء، إضافةً إلى No icon.
- عرض الأيقونة فوق نص الزر.
- تحكم مستقل في عرض الأيقونة وارتفاعها من 8–96dp.
- تقييد الأيقونة تلقائيًا داخل حدود الزر.
- حفظ معرّف الأيقونة وأبعادها داخل JSON الخاص بالتحكم، لتظهر عند مشاركة التحكم مع نسخة اللانشر المعدّلة نفسها.
- دعم النسخ والاستنساخ والتوافق مع ملفات التحكم القديمة.

فحص XML والفروقات نجح محليًا. بدأت فحوص GitHub Actions للبناء وCheck Codes وما زالت قيد التشغيل.

### 4.3 الفرق بين وصول السورس واكتمال APK

**المستخدم:** نجح تعديل هل هوه سينزل على سورس مباشره ام يحتاج وقت

**المساعد:** نعم، التعديل نزل بالفعل مباشرةً في سورس المشروع على فرع `main` ضمن الالتزام `49e2feb`. لكن ملف APK يحتاج وقتًا حتى تكمل GitHub Actions عملية البناء لكل المعماريات. وجود السورس فوري، أما ظهور APK القابل للتنزيل فيكون بعد نجاح البناء، وغالبًا يستغرق عدة دقائق.

**المستخدم:** والأن انت بنيته apk ام ابقيته سورس

**المساعد:** الآن أصبح الاثنان جاهزين: التعديل موجود في السورس على فرع `main`، وتم بناء ملفات APK بنجاح لجميع المعماريات عبر GitHub Actions، ويمكن تنزيلها من قسم Artifacts داخل صفحة البناء. فحص Check Codes نجح أيضًا دون أخطاء.

### 4.4 نشر Release

**المستخدم:** هل يمكنك نشره release

**المساعد:** تم نشر Release 1.3.4.1 بنجاح مع خمسة ملفات APK: `all`، `arm64-v8a`، `armeabi-v7a`، `x86`، `x86_64`. يمكن تنزيلها من صفحة الإصدار مباشرةً. كما اكتمل البناء والنشر دون أخطاء.

**المستخدم:** مع تعديلات جديده؟

**المساعد:** نعم، الإصدار المنشور يتضمن التعديلات الجديدة بالكامل؛ لأن الوسم `1.3.4.1` بُني من أحدث فرع `main` بعد إضافة ميزة الأيقونات. أي أن ملفات APK تتضمن خيار Icon في Base View Info، وجميع الأيقونات البيضاء الجديدة، والتحكم بعرض الأيقونة وارتفاعها، وحفظ الأيقونة عند حفظ أو مشاركة التحكم.

**توضيح للتسليم:** عبارة «أحدث main» كانت وصفًا وقت النشر فقط. الدليل التاريخي الأدق هو SHA الإصدار الموضح أعلاه؛ في أي جلسة جديدة تحقّق من احتواء commit الإصدار على commit الميزة بدل الاعتماد على العبارة وحدها.

### 4.5 طلب ملف التسليم الحالي

**المستخدم:** انشئ ملف md فيه جميع معلومات محادثه بالكامل وأيضا معلومات برمجيه مثل مشاكل وحلها وأختصارات ونصائح بناء في github وكيفيه رفعه Release لأنني اريد ارسله لغير محادثه ai ومباشره يفهم طلبي وينتضر ربط حسابي github وأرسال طلبات تعديل.

**نتيجة هذا الطلب:** هذا الملف فقط؛ لم يُطلب ضمنه تعديل جديد للسورس أو إنشاء Release آخر.

## 5. خريطة التنفيذ البرمجي

المشروع يتضمن Java وKotlin وواجهات Android XML. الوحدة الأساسية المرتبطة بهذا التعديل: `FCL`.

### 5.1 ملفات المنطق والواجهة

| المسار من جذر المستودع | وظيفته في الميزة |
|---|---|
| `FCL/src/main/java/com/tungsten/fcl/control/data/ControlButtonData.java` | خصائص الأيقونة، القيم الافتراضية، listeners، clone، حفظ وقراءة JSON |
| `FCL/src/main/java/com/tungsten/fcl/control/EditButtonDetails.kt` | ربط خيار Icon ومنزلقي الأبعاد بمحرر الزر |
| `FCL/src/main/java/com/tungsten/fcl/control/view/ControlButton.java` | رسم الأيقونة فوق النص وتقييد أبعادها بحسب مساحة الزر |
| `FCL/src/main/java/com/tungsten/fcl/control/ControllerIconRegistry.kt` | سجل IDs ثابتة تربط الأيقونة بالـdrawable وباسمها النصي |
| `FCL/src/main/java/com/tungsten/fcl/control/ControllerIconDialog.kt` | حوار اختيار الأيقونة بشبكة RecyclerView |
| `FCL/src/main/res/layout/view_edit_button_info.xml` | إضافة إعداد Icon وعرضه وارتفاعه |
| `FCL/src/main/res/layout/dialog_controller_icon.xml` | واجهة حوار الاختيار |
| `FCL/src/main/res/layout/item_controller_icon.xml` | خلية الأيقونة في الشبكة |
| `FCL/src/main/res/values/strings.xml` | عناوين الإعدادات وأسماء الأيقونات |
| `FCL/src/main/res/drawable/bg_controller_icon_preview.xml` | خلفية معاينة للأيقونات |
| `FCL/src/main/res/drawable/controller_icon_*.xml` | موارد الأيقونات المتجهة |

### 5.2 نموذج البيانات والحفظ

الخصائص المضافة في `ControlButtonData`:

```java
StringProperty iconProperty;       // default: "none"
IntegerProperty iconWidthProperty; // default: 24
IntegerProperty iconHeightProperty;// default: 24
```

واجهات الوصول تشمل:

```text
iconProperty() / setIcon(String) / getIcon()
iconWidthProperty() / setIconWidth(int) / getIconWidth()
iconHeightProperty() / setIconHeight(int) / getIconHeight()
```

- `setIcon` يحوّل null أو النص الفارغ إلى `none`.
- setters للأبعاد تقيد القيمة بين 8 و96dp.
- تُضاف الخصائص إلى `addPropertyChangedListener` ليستجيب نظام التحكم لتغييراتها.
- `clone()` ينسخ اختيار الأيقونة وأبعادها، ولا يكتفي بنسخ النص والستايل.
- Serialization يضيف `icon` و`iconWidth` و`iconHeight`.
- Deserialization يستخدم `none` و24 و24 عند غياب الحقول، حفاظًا على ملفات التحكم القديمة.
- IDs غير المعروفة تعود بصريًا إلى `none` عبر `ControllerIconRegistry.find`.

مثال **جزئي** للحقول الجديدة، وليس ملف تحكم كاملًا صالحًا للاستيراد بمفرده:

```json
{
  "icon": "pickaxe",
  "iconWidth": 24,
  "iconHeight": 24
}
```

**قاعدة أساسية:** خزّن معرّفًا نصيًا ثابتًا مثل `pickaxe`، لا رقم `R.drawable`؛ أرقام الموارد يمكن أن تتغير بين عمليات البناء. الصور نفسها مدمجة في APK، وملف التحكم يشارك المعرّف والأبعاد فقط.

### 5.3 منتقي الأيقونات

`ControllerIconRegistry` هو Kotlin `object` ويحتوي:

- `NONE = "none"`.
- `data class Icon(id, labelRes, drawableRes)`.
- `icons: List<Icon>`.
- `find(id)` يعيد أول خيار (`none`) عند عدم وجود تطابق.

`ControllerIconDialog`:

- مبني على `FCLDialog` ومربوط عبر View Binding.
- يستخدم `RecyclerView` و`GridLayoutManager`.
- 5 أعمدة إذا كان عرض الشاشة 600dp أو أكثر، وإلا 4 أعمدة.
- العرض محصور بعرض الشاشة ناقص 32dp وبحد أقصى 560dp.
- الارتفاع محصور بـ82% من ارتفاع الشاشة وبحد أقصى 620dp.
- يعرض مورد الأيقونة واسمها ويميز الخيار الحالي.
- الضغط يستدعي callback ثم يغلق الحوار؛ يوجد زر إلغاء.

### 5.4 ربط المحرر

داخل `EditButtonDetails.kt`:

- `iconText` يعرض اسم الأيقونة الحالية.
- الضغط على `icon` يفتح `ControllerIconDialog`.
- الاختيار يحدّث `data.icon` ثم اسم الاختيار.
- `bindNumberSeekBar` يربط `iconWidth` و`iconHeight` بخواص البيانات.

داخل `view_edit_button_info.xml`:

- IDs: `icon_text`، `icon`، `icon_width`، `icon_height`.
- الأبعاد عبر `FCLNumberSeekBar`، min 8، max 96، suffix `dp`.
- لا تعِد تسمية هذه IDs دون تحديث مراجع View Binding والكود معًا.

### 5.5 الرسم والتقييد داخل الزر

أضيفت `refreshIcon(ControlButtonData)` في `ControlButton.java` واستُدعيت بعد `refreshStyle(data)` في مسار التحديث المؤجل `post`.

الآلية:

1. حل المعرّف باستخدام Registry.
2. إذا كان `none` تمسح compound drawables والفاصل.
3. تحميل الـVector عبر `AppCompatResources.getDrawable`.
4. حساب inset آمن 2dp لكل جهة.
5. حساب ارتفاع النص باستخدام FontMetrics إن لم يكن النص فارغًا.
6. تخصيص فاصل 2dp بين النص والأيقونة إن كان النص موجودًا.
7. تقييد العرض بما يتبقى من عرض الزر، والارتفاع بما يتبقى بعد النص والفاصل والحواف.
8. تحويل dp إلى px، ثم `drawable.mutate()` و`setBounds`.
9. وضع الأيقونة في الخانة العلوية عبر `setCompoundDrawables(null, drawable, null, null)`.

**حدود يجب اختبارها:** النص الطويل ومتعدد الأسطر، الأزرار الصغيرة جدًا، الخطوط الكبيرة، تغيير الحجم أثناء التحرير، الدوران وRTL، وتأثير padding والستايل. الحساب السابق احتسب سطر نص عبر FontMetrics؛ لا تعلن دعم كل حالات النص متعدد الأسطر دون اختبار. `Math.max(1, ...)` يحمي الأبعاد من الصفر لكنه ليس بديلًا عن اختبار القص الفعلي على الجهاز.

### 5.6 قائمة الأيقونات الثابتة

| ID | المعنى |
|---|---|
| `none` | بلا أيقونة |
| `pickaxe` | بيكاكس / معول |
| `eye` | عين، مناسب لزر F5 |
| `axe` | فأس |
| `sword` | سيف |
| `run` | لاعب يركض |
| `stand` | لاعب واقف |
| `boost` | تعزيز / بوست |
| `camera` | كاميرا |
| `keyboard` | لوحة مفاتيح |
| `mouse` | ماوس |
| `lightning` | صاعقة |
| `ghost` | شبح |
| `cube` | مكعب |
| `x_mark` | علامة X |
| `bow` | قوس |
| `arrow` | سهم |
| `bag` | حقيبة |
| `arrow_up` | مؤشر لأعلى |
| `arrow_down` | مؤشر لأسفل |
| `copy` | نسخ |
| `paste` | لصق |
| `chat` | شات |
| `screen` | شاشة |
| `pencil` | قلم |
| `star` | نجمة |
| `wifi` | واي فاي |
| `bluetooth` | بلوتوث |
| `moon` | قمر |

لإضافة أيقونة مستقبلًا: أضف Vector XML أبيضًا وstring label ومدخل Registry بمعرّف جديد ثابت، ثم اختبر المعاينة والرسم والحفظ والمشاركة. لا تغيّر IDs المنشورة إلا مع آلية migration.

## 6. المشاكل التي ظهرت فعلًا وحلولها

### 6.1 تعذر تمييز المستودع من الاسم وحده

- ظهرت مشاريع متشابهة ولم يحدد البحث المستودع المقصود بثقة.
- الحل: سؤال المستخدم عن الرابط، ثم استعمال الرابط الذي أرسله.
- الدرس: لا تعدّل مشروعًا مشابهًا بالاسم؛ والشرطة الأخيرة في هذا المستودع مهمة.

### 6.2 فشل Gradle بسبب Java 25

الرسالة الفعلية:

```text
FAILURE: Build failed with an exception.
* What went wrong:
25.0.4
java.lang.IllegalArgumentException: 25.0.4
at org.jetbrains.kotlin.com.intellij.util.lang.JavaVersion.parse(...)
```

- ظهر الفشل أثناء تهيئة Kotlin/Gradle مع Java 25، قبل إثبات وجود خطأ في كود الميزة.
- Gradle Wrapper الظاهر في السجل: 8.14.4.
- الحل المنفذ: تنزيل JDK 17 محليًا (Amazon Corretto)، واستعماله بدل Java 25.
- نسخة Java التي أكدها السجل: `17.0.20.1`.
- المسار المحلي المؤقت وقتها: `/data/jdks/corretto17`، ولا تفترض وجوده في بيئة جديدة.

صيغة ضبط البيئة إن كان المسار موجودًا:

```bash
export JAVA_HOME=/data/jdks/corretto17
export PATH="$JAVA_HOME/bin:$PATH"
java -version
./gradlew --version
```

الأفضل في GitHub Actions: اتباع إعداد المشروع، الذي استخدم JDK 17 عبر `actions/setup-java`.

### 6.3 غياب Android SDK محليًا

بعد الانتقال إلى Java 17، وصل البناء إلى خطأ مستقل:

```text
A problem occurred configuring project ':FCL'.
SDK location not found. Define a valid SDK location with an ANDROID_HOME
or by setting the sdk.dir path in your project's local properties file.
```

- هذا نقص في بيئة التنفيذ المحلية؛ لا يعالج بتعديل منطق الأيقونات عشوائيًا.
- لم يكتمل بناء APK محليًا في تلك البيئة بسبب غياب SDK.
- تم التحقق من البناء الفعلي عبر GitHub Actions ونجح لاحقًا.
- الحل المحلي المستقبلي: تثبيت Android SDK وإصداراته المطلوبة حسب Gradle، ثم ضبط `ANDROID_HOME` أو `sdk.dir` بمسار حقيقي.
- لا ترفع `local.properties` بمسارات جهازك إلى GitHub.

### 6.4 GitHub Advanced Security غير مفعّل

أداة secret scanning أعادت:

```text
Repository does not have GitHub Advanced Security enabled.
```

- لا تقل إن فحص الأسرار عبر هذه الأداة نجح؛ هو لم يُنفّذ بنجاح.
- هذه ليست رسالة فشل بناء Android.
- النصيحة: راجع diff بحثًا عن الأسرار واستعمل فاحصًا بديلًا متاحًا أو إعدادات GitHub المناسبة بموافقة صاحب المستودع.
- لا تضع Tokens أو كلمات مرور التوقيع في السورس أو ملف التسليم أو مخرجات الأوامر.

### 6.5 Workflow الإصدار الأصلي معطّل في الـFork

ظهر في GitHub تنبيه بأن الـscheduled workflow معطّل لأن التشغيل المجدول معطّل افتراضيًا في المستودعات المتفرعة.

الحل المنفذ في المحادثة:

1. استُخدم `.github/workflows/release.yml` كأساس.
2. أُنشئ `.github/workflows/publish-release.yml` باسم `Publish Release`.
3. أزيل من النسخة الجديدة قسم `schedule` الذي كان يعمل كل 13 دقيقة.
4. حُفظ منطق prepare/build/release والـconcurrency والصلاحيات.
5. رُفع الملف إلى `main` في commit `02d70cd...`.
6. انطلق Publish Release وانتهى بوجود إصدار منشور وخمسة أصول APK.

هذه معالجة حدثت لهذا المستودع، وليست توصية بإنشاء Workflow مكرر في كل مرة. افحص ما هو مفعّل حاليًا؛ قد يكون تفعيل الموجود كافيًا في حالة أخرى.

### 6.6 غياب gh محليًا

سجل فحص الأداة أعاد `gh-not-installed`.

- غياب GitHub CLI في بيئة المحادثة لا يعني غيابه في GitHub-hosted runners.
- استخدمت المحادثة أدوات GitHub المتصلة وواجهات أخرى للتحقق، بينما Workflow نفسه يستعمل `gh release view` على runner.
- عند المتابعة استخدم GitHub MCP إن كان متاحًا. أو ثبّت `gh` بطريقة مسموحة؛ لا تفترض توفره.

## 7. البناء في GitHub Actions

### 7.1 منطق build.yml كما كان وقت العمل

- `push` على الفروع، مع تجاهل تعديلات `.github/workflows/**` وملفات Markdown و`version_map.json`.
- `pull_request`.
- `workflow_dispatch` للتشغيل اليدوي.
- `workflow_call` ليُستدعى من سير النشر.
- Checkout مع `fetch-depth: 0` و`submodules: recursive`.
- JDK 17.
- Matrix: `all`, `arm`, `arm64`, `x86`, `x86_64`، مع `fail-fast: false`.
- البناء لغير pull_request:

```bash
chmod +x gradlew
./gradlew assemblerelease -Darch=all --no-daemon
```

- بناء pull_request كما ورد في Workflow:

```bash
./gradlew assemblefordebug -Darch=all --no-daemon
```

- رفع Artifacts باسم `app-<arch>` من `FCL/build/outputs/apk/*/*`.
- الربط المتوقع لأسماء المعماريات: `arm` → `armeabi-v7a`، و`arm64` → `arm64-v8a`.

**تنبيه:** الأوامر أعلاه من السجل، وليست تخمينًا بأن أي مشروع Android آخر يملك المهام نفسها. اقرأ Gradle وWorkflow الحاليين قبل التنفيذ.

### 7.2 خطوات تشغيل بناء يدوي

1. افتح المستودع الصحيح ثم Actions.
2. اختر Build، ثم Run workflow، وحدد الفرع/المرجع المناسب.
3. انتظر كل مهام المعماريات، ولا تكتفِ بنجاح Prepare أو أول معمارية.
4. افتح logs لأي فشل؛ ابدأ بأول خطأ حقيقي لا التحذيرات الأخيرة فقط.
5. بعد `completed / success` افحص Artifacts وتنزيل الملفات.
6. إذا لم يظهر Run جديد عند تعديل MD أو Workflow فقط، راجع `paths-ignore`؛ قد يكون السلوك مقصودًا. تشغيل Publish Release قد يستدعي Build عبر `workflow_call` رغم تجاهل push العادي.

### 7.3 Check Codes

كان `.github/workflows/check-codes.yml` يعمل على تغييرات Java/Kotlin ويشغّل:

```bash
./gradlew checkstyle --no-daemon --parallel --stacktrace
```

`Check Codes Comment` مصمم لتعليق مراجعة عند فشل فحص pull_request؛ لذلك `skipped` على push ناجح أمر متوقع ولا يعادل فشل Check Codes.

### 7.4 متطلبات البيئة والأمان

- افحص JDK وAndroid SDK وNDK إن تطلب المشروع ذلك، وGradle Wrapper وsubmodules.
- استخدم `./gradlew` وليس Gradle عالميًا عشوائي الإصدار.
- Build كان يمرر أسماء متغيرات مثل `FCL_KEYSTORE_PASSWORD`, `CURSE_API_KEY`, `OAUTH_API_KEY`.
- راجع قيمها في GitHub Secrets فقط عند الحاجة ولا تعرضها في السجل.
- الحفاظ على مفتاح التوقيع مهم لتثبيت APK كتحديث فوق النسخة السابقة. لا تستبدله ولا تولّد واحدًا جديدًا تلقائيًا.
- اسم APK أو versionName لا يثبتان وحدهما التوقيع أو احتواء الميزة؛ اربطهما بالـRun والـCommit.

## 8. طريقة النشر Release في هذا المشروع

### 8.1 منطق Publish Release المسجل

المسار: `.github/workflows/publish-release.yml`.

- أحداث `push` على `main` وعلى Tags، إضافة إلى `workflow_dispatch`.
- `permissions: contents: write` لإنشاء الإصدار ورفع الأصول.
- concurrency group باسم `release` مع عدم إلغاء التشغيل الجاري.
- Prepare يحدد Tag من `github.ref_name` إذا كان المرجع Tag؛ وإلا يقرأ:

```python
json.load(open('version_map.json'))[0]['versionName']
```

- يفحص الإصدار عبر `gh release view`.
- **إذا كان الإصدار المقصود يحتوي أي Assets، يضبط skip=true** ولا يعيد البناء والنشر.
- Build يستدعي `.github/workflows/build.yml` مع `secrets: inherit`.
- Release ينزّل Artifacts، ويستخرج قسم changelog الموافق للوسم من `CHANGELOG.md`.
- إن لم يوجد نص مناسب، يضع عنوانًا افتراضيًا.
- يستخدم `softprops/action-gh-release@v3` لرفع `apks/**/*.apk`.
- `target_commitish` يحدده `github.sha`.
- التوثيق المسجل أظهر اختيار صلاحية النشر من Secret مخصص `TOKEN` إن توفر، وإلا `GITHUB_TOKEN`؛ لا تنقل قيم الأسرار إلى الملف.

### 8.2 خطوات إصدار جديد آمن مستقبلًا

1. احصل على طلب نشر واضح من صاحب المشروع.
2. حدّث نسختك من `main` وافحص كل التغييرات وأي شغل غير محفوظ.
3. أكمل التعديلات والفحوص وتأكد من SHA المراد إصداره.
4. افحص مصدر `versionName` و`versionCode` في Gradle و`version_map.json`. لا تفترض أن تعديل الملف الأخير وحده يغيّر كل شيء.
5. اختر رقم إصدار جديدًا مناسبًا؛ لا تعِد استخدام `1.3.4.1` لتغييرات جديدة بصورة صامتة.
6. حدّث changelog ليصف تعديلات هذا الـFork فعلًا، وخصوصًا الأيقونات أو التغييرات الجديدة، لا وصف upstream فقط.
7. راجع متى سيعمل Publish Release تلقائيًا على push إلى `main`؛ اجمع تغييرات الإصدار بعناية لتجنب نشر مبكر.
8. نفّذ مسار النشر الذي يطابق Workflow الحالي: push مناسب، Tag صحيح، أو Run workflow على المرجع المقصود.
9. انتظر Prepare ثم جميع builds ثم job النشر.
10. تحقق أن الإصدار ليس Draft وأن APKs الخمسة مرفوعة وغير فارغة.
11. تحقق من ارتباط Tag بالـCommit الصحيح، ومن أن Commit الميزة ضمن تاريخه.
12. سلّم الرابط ورقم الإصدار وSHA وحالة الفحوص بوضوح، مع ذكر ما لم يُختبر على جهاز.

**تحذير مهم بخصوص skip:** وجود أصل واحد فقط يجعل المنطق السابق يتجاوز النشر. إذا رُفعت بعض الملفات ثم فشل الباقي، فلا تفترض أن rerun سيصلح ذلك تلقائيًا. افحص الأصول وأكمل الناقص بطريقة مقصودة بعد موافقة المستخدم؛ لا تحذف إصدارًا أو تغيّر Tag منشورًا عشوائيًا.

### 8.3 ما نُشر فعليًا في المحادثة

الإصدار: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/releases/tag/1.3.4.1

| الملف | الحجم المسجل بالبايت |
|---|---:|
| `FCL-release-1.3.4.1-all.apk` | 330359372 |
| `FCL-release-1.3.4.1-arm64-v8a.apk` | 172684265 |
| `FCL-release-1.3.4.1-armeabi-v7a.apk` | 165432606 |
| `FCL-release-1.3.4.1-x86.apk` | 159025602 |
| `FCL-release-1.3.4.1-x86_64.apk` | 178363457 |

نتيجة API التاريخية: `draft=false`, `prerelease=false`، و`target_commitish=02d70cd52e71e9cacb68f4d010a774b1acbda77c`.

**ملاحظة عن Release Notes:** النص الذي رجع من GitHub كان مستخرجًا من changelog ويصف ميزات وإصلاحات upstream باللغتين الصينية والإنجليزية؛ لم يكن وصفًا مخصصًا لميزة الأيقونات. لا تستنتج من غياب ذكر الأيقونات في الوصف أنها غير موجودة في السورس. وفي المقابل لا تعتبر نص الوصف وحده دليلًا على محتويات APK؛ راجع SHA والتغييرات.

## 9. اختصارات عملية للمساعد القادم

الأوامر التالية أدوات إرشادية، وليست مهام مطلوبًا تنفيذها تلقائيًا بمجرد فتح الملف. تحتاج الأدوات المناسبة والمصادقة والصلاحيات، وبعضها يكتب في المستودع أو ينشر إصدارًا.

### 9.1 استنساخ وفحص نسخة جديدة

```bash
git clone --recurse-submodules https://github.com/t86952356-eng/FoldCraftLauncher-Elite-.git
cd FoldCraftLauncher-Elite-
git switch main
git status --short
git log -5 --oneline
git submodule update --init --recursive
```

إذا كانت لديك نسخة عمل موجودة وفيها تغييرات، لا تبدأ بـreset أو clean أو pull فوقها؛ افحصها أولًا واحفظ عمل المستخدم دون إتلافه.

### 9.2 الوصول السريع لمنطق الميزة

```bash
rg -n 'ControllerIcon|iconWidth|iconHeight|refreshIcon' FCL/src/main
rg -n 'versionName|versionCode' --glob '*.gradle*' .
sed -n '1,200p' .github/workflows/publish-release.yml
python3 -m json.tool version_map.json > /dev/null
git diff --check
git diff --stat
```

### 9.3 التحقق من إصدار تاريخي

بعد جلب التاريخ اللازم والـTags:

```bash
git fetch origin --tags
git rev-parse '1.3.4.1^{commit}'
git merge-base --is-ancestor \
  49e2feb01d427a4b0a3ef7507e62e4af2baadfeb '1.3.4.1^{commit}'
git show --stat 49e2feb01d427a4b0a3ef7507e62e4af2baadfeb
```

خروج `merge-base --is-ancestor` بالقيمة 0 يعني أن commit الميزة سلف للإصدار في التاريخ المتاح. النسخ shallow قد تحتاج جلب تاريخ إضافي. هذا تحقق من السورس، وليس فحص تشغيل APK.

### 9.4 أوامر gh الاختيارية للقراءة والمتابعة

```bash
gh auth status
gh run list --repo t86952356-eng/FoldCraftLauncher-Elite- --limit 10
gh run view RUN_ID --repo t86952356-eng/FoldCraftLauncher-Elite-
gh run watch RUN_ID --repo t86952356-eng/FoldCraftLauncher-Elite-
gh run view RUN_ID --repo t86952356-eng/FoldCraftLauncher-Elite- --log-failed
gh release view 1.3.4.1 --repo t86952356-eng/FoldCraftLauncher-Elite-
```

`RUN_ID` مثال موضعي يستبدل بالرقم الفعلي، وليس نصًا يُنفذ كما هو. وإن كانت بيئتك تقدم MCP مناسبًا فاستعمله بدل إعداد وسيلة وصول جديدة بلا ضرورة.

### 9.5 تشغيل يدوي عند الطلب فقط

```bash
# قد يستهلك وقت تشغيل Actions:
gh workflow run build.yml --ref main --repo t86952356-eng/FoldCraftLauncher-Elite-

# هذا قد ينشر Release؛ لا تنفذه بلا طلب ومراجعة النسخة:
gh workflow run publish-release.yml --ref main --repo t86952356-eng/FoldCraftLauncher-Elite-
```

لا حاجة عادة إلى `gh release create` يدويًا إن كان Workflow المشروع يؤدي البناء والنشر؛ إن استُخدم مسار آخر فيجب ضمان provenance ومفتاح التوقيع والـTag والملفات الصحيحة.

## 10. اختبارات قبول مقترحة قبل التعديلات القادمة

هذه **قائمة اختبارات مستقبلية**؛ لا تعني أنها نُفّذت جميعًا في الجلسة السابقة:

- [ ] فتح Controller ثم Edit button ثم Base View Info وظهور Icon.
- [ ] فتح الشبكة وظهور 28 أيقونة وخيار No icon.
- [ ] اختيار pickaxe والتأكد أنه يطبق على الزر المحدد فقط وفوق النص.
- [ ] اختيار eye مع زر F5 دون تغيير سلوك ضغط الزر.
- [ ] تجربة العرض والارتفاع عند 8 و24 و96dp.
- [ ] تكبير الأيقونة داخل زر صغير والتحقق من عدم خروجها من الإطار.
- [ ] تجربة نص فارغ، ونص طويل، وخط كبير، وستايلات مختلفة.
- [ ] تغيير حجم الزر أثناء التحرير والتأكد من إعادة حساب العرض.
- [ ] إزالة الأيقونة عبر No icon والتأكد من زوال الفراغ غير المطلوب.
- [ ] حفظ التحكم ثم إغلاقه وإعادة فتحه واستمرار الاختيار والأبعاد.
- [ ] نسخ/استنساخ زر والتأكد من انتقال الأيقونة وأبعادها.
- [ ] تصدير التحكم واستيراده على النسخة المعدلة نفسها.
- [ ] فتح ملف تحكم قديم بلا حقول icon والتأكد من عدم حدوث crash.
- [ ] تجربة ID غير معروف والتأكد من الرجوع إلى none بأمان.
- [ ] التحقق من كثافات الشاشة والاتجاهين وRTL.
- [ ] نجاح Build لكل المعماريات وCheck Codes.
- [ ] تثبيت APK المناسب والتحقق من الإصدار والتوقيع والتشغيل الفعلي.

## 11. قواعد لتجنب أخطاء المتابعة

1. هذا الملف سياق وتسليم؛ الطلب الجديد من المستخدم هو الذي يحدد التعديل التالي.
2. اقرأ الملفات الحالية قبل الكتابة. لا تستبدل ملفًا كاملًا من نسخة قديمة دون مقارنة.
3. لا تعتمد على أن نسخة محلية قديمة متزامنة مع GitHub؛ قد تكون التغييرات رُفعت عبر API ولم يسجّلها git المحلي.
4. حافظ على IDs الثابتة وتوافق JSON والقيم الافتراضية وclone/listeners.
5. لا تحول Vector XML إلى PNG بلا حاجة، ولا تغير لون الأيقونات الأبيض إلا بطلب.
6. لا تضف مكتبة كبيرة لميزة يمكن تحقيقها بالمكونات الموجودة.
7. لا تغيّر versionCode أو مفاتيح التوقيع أو صلاحيات Workflow بلا سبب واضح.
8. ميّز بدقة بين: تعديل محلي، Commit مرفوع، CI قيد التشغيل، CI ناجح، APK متاح، Release منشور، واختبار جهاز فعلي.
9. لا تعلن «تم» لمجرد إعداد الكود أو بدء Run؛ أعطِ الحالة الحقيقية ورابطها.
10. لا تعالج نقص JDK/SDK بتعديلات عشوائية في منطق التطبيق.
11. عند النشر، لا تعِد استخدام Tag قديم لملفات مختلفة دون قرار صريح من المستخدم وخطة واضحة.
12. قد يشغّل push إلى main مسار النشر تلقائيًا حسب الإعدادات الحالية؛ اقرأ triggers قبل أي push.
13. سير `sync-version-map.yml` المسجل كان يحاول مزامنة مستودع upstream آخر (`FCL-Team/FCL-Repo`) باستخدام TOKEN؛ لا تفترض أن صاحب هذا الـFork يملك صلاحية الكتابة هناك، ولا تخلط فشله مع فشل بناء التطبيق نفسه.
14. لا تضع بيانات المصادقة أو قيم Secrets في ملف MD أو رسائل التسليم. هذا الملف مصمم ليُشارك بأمان من دونها.

## 12. ما ينتظره المستخدم الآن

- نقل هذا الملف إلى محادثة AI أخرى.
- فهم المشروع والطلبات السابقة دون إعادة شرحها.
- انتظار ربط حساب GitHub في الجلسة الجديدة إذا لزم.
- انتظار طلبات تعديل جديدة على Theme / Style أو التحكم.
- تنفيذها بدقة في المستودع الصحيح عند طلبها، مع الفحص والتوثيق، والبناء أو النشر عند الطلب.

**لا يوجد في نهاية المحادثة طلب ميزة إضافية محددة غير إنشاء ملف التسليم هذا.**

## ملحق: أسماء ملفات الأيقونات

```text
FCL/src/main/res/drawable/controller_icon_arrow.xml
FCL/src/main/res/drawable/controller_icon_arrow_down.xml
FCL/src/main/res/drawable/controller_icon_arrow_up.xml
FCL/src/main/res/drawable/controller_icon_axe.xml
FCL/src/main/res/drawable/controller_icon_bag.xml
FCL/src/main/res/drawable/controller_icon_bluetooth.xml
FCL/src/main/res/drawable/controller_icon_boost.xml
FCL/src/main/res/drawable/controller_icon_bow.xml
FCL/src/main/res/drawable/controller_icon_camera.xml
FCL/src/main/res/drawable/controller_icon_chat.xml
FCL/src/main/res/drawable/controller_icon_copy.xml
FCL/src/main/res/drawable/controller_icon_cube.xml
FCL/src/main/res/drawable/controller_icon_eye.xml
FCL/src/main/res/drawable/controller_icon_ghost.xml
FCL/src/main/res/drawable/controller_icon_keyboard.xml
FCL/src/main/res/drawable/controller_icon_lightning.xml
FCL/src/main/res/drawable/controller_icon_moon.xml
FCL/src/main/res/drawable/controller_icon_mouse.xml
FCL/src/main/res/drawable/controller_icon_none.xml
FCL/src/main/res/drawable/controller_icon_paste.xml
FCL/src/main/res/drawable/controller_icon_pencil.xml
FCL/src/main/res/drawable/controller_icon_pickaxe.xml
FCL/src/main/res/drawable/controller_icon_run.xml
FCL/src/main/res/drawable/controller_icon_screen.xml
FCL/src/main/res/drawable/controller_icon_stand.xml
FCL/src/main/res/drawable/controller_icon_star.xml
FCL/src/main/res/drawable/controller_icon_sword.xml
FCL/src/main/res/drawable/controller_icon_wifi.xml
FCL/src/main/res/drawable/controller_icon_x_mark.xml
```


---

# ملحق هذه الجلسة: من 1.3.4.1 إلى 1.3.4.3

## A. التحديث السابق 1.3.4.2 — أُنجز ونُشر

- Commit المصدر والإصدار: `97311cc1ab0d5f146cd6104a3198b9db634ccbf8` على main؛ code=1342.
- Release: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/releases/tag/1.3.4.2
- Publish Release الناجح: https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/actions/runs/39715686304
- Build: `39715686283`؛ Check Codes الناجح: `39715686309`.
- خمسة APK: all، arm64-v8a، armeabi-v7a، x86، x86_64. الـTag يطابق Commit المصدر.
- ثمانية اختبارات JVM مستهدفة نجحت؛ ترجمة Java/Kotlin وCheckstyle وفحص 350 XML نجحت. لا اختبار جهاز فعلي.
- فُحص arm64 APK المنشور: versionName=1.3.4.2، versionCode=1342، توقيع صحيح وبالشهادة نفسها للإصدار 1.3.4.1.
- SHA256 شهادة التوقيع (بصمة عامة وليست مفتاحًا): `be114d96613f7375a510d836680b456c9d528d15b24c382b1137480f15894e5e`.

### تنفيذ 1.3.4.2 والدروس

1. إصلاح ضياع الأيقونة بعد تأكيد Edit Button: استُخدمت `ControlButtonData.copySettingsFrom` في `ViewManager`؛ تنسخ icon/width/height/style/baseInfo/event دون تغيير هوية الزر، وclone يمنح هوية جديدة وينسخ الإعدادات بعمق.
2. إعادة رسم sword/bow/axe/pickaxe كـVector XML نظيف، وتحديث الأيقونة بعد قياس الزر وتغيير حجمه، مع cache واحتواء داخل الحدود لتجنب حلقات layout.
3. إضافة `animationEnabled=false` و`animationDuration=180` افتراضيًا (الحد 50–1000ms) إلى `ControlButtonStyle` وحفظها ونسخها. `ButtonStyleTransition.java` مشترك بين أزرار اللعبة والمعاينة، ويدعم إلغاء الحركة عند فصل العرض واحترام تعطيل الحركات بالنظام؛ لا يؤخر إدخال اللمس.
4. Menu View: بطاقة Elite Luncher، صورة PNG/GIF داخل دائرة مقصوصة وإطار، FPS حقيقي ورام النظام والوقت مع مفاتيح مستقلة. إدارة GIF عبر دورة حياة العرض.
5. `CallbackBridge.getFps` يصفّر العداد الأصلي عند القراءة؛ لذلك أضيف `FrameRateSampler` مشترك في `FCLBridge.getFps` لتجنب تنازع عدادات FPS، وتطبيع العينة حسب الزمن المنقضي.
6. `FCLNumberSeekBar.addProgressListener()` ضرورية لتمرير سحب المستخدم إلى Property؛ لا يكفي الربط وحده.
7. حُدّثت version_map وروابط APK لتشير إلى هذا الـfork. أُضيف guard إلى sync-version-map ليعمل فقط في مستودع FCL-Team الأصلي، منعًا لمحاولة كتابة بيانات fork إلى upstream.
8. جرى أولًا الاختبار على فرع `fix/controller-icons-transitions-menu`، ثم رفع snapshot مطابق للملفات المختبرة إلى main مع بيانات الإصدار في commit واحد. ليس دمج ancestry تقليديًا؛ لا تفترض أن commit الفرع سلف لـmain.

## B. تحديث 1.3.4.3 — وصف التنفيذ

### المتطلبات والتنفيذ

- **24 أيقونة جديدة**، لا استبدال للـ28 القديمة؛ المجموع 52 أيقونة + none =53 خيارًا.
- التسعة المطلوبة: خنفساء، كابستر/مكثف كهربائي، سيف وفأس ومعول pixel مستوحاة من Minecraft، الكرة الأرضية، ترس، Motion متموج، إعادة تدوير.
- قائمة IDs الجديدة المستقرة:

- `beetle`: خنفساء / Beetle
- `capacitor`: مكثف كهربائي (كابستر) / Capacitor
- `minecraft_sword`: سيف ماينكرافت / Pixel sword
- `minecraft_axe`: فأس ماينكرافت / Pixel axe
- `minecraft_pickaxe`: معول ماينكرافت / Pixel pickaxe
- `globe`: الكرة الأرضية / Globe
- `gear`: ترس الإعدادات / Settings gear
- `motion_wave`: خط ملتوي Motion / Motion wave
- `recycle`: إعادة التدوير / Recycling
- `shield`: درع / Shield
- `heart`: قلب / Heart
- `torch`: شعلة / Torch
- `potion`: جرعة / Potion
- `helmet`: خوذة / Helmet
- `chest`: صندوق / Chest
- `shovel`: مجرفة / Shovel
- `fishing_rod`: صنارة صيد / Fishing rod
- `compass`: بوصلة / Compass
- `map`: خريطة / Map
- `target`: هدف / Target
- `lock`: قفل / Lock
- `unlock`: فتح القفل / Unlock
- `volume`: صوت / Volume
- `pause`: إيقاف مؤقت / Pause

- الحجم الافتراضي الجديد 14×14dp، مع إبقاء القياسات الصريحة في ملفات التحكم القديمة. أضيف `iconOffsetY` بمدى -96..96dp، افتراضي صفر، مباشرة تحت Icon height في المحرر. يُحفظ ويُنسخ ويُصدّر مع الزر.
- تستخدم الأيقونة spacer شفافًا لتثبيت موضع النص، ثم تُرسم منفصلة بإزاحة محدودة داخل الزر؛ لا تُترجم مجموعة النص والأيقونة معًا. `ControllerIconGeometry` يعالج الحدود حتى للأزرار الصغيرة. يمكن أن تتداخل الأيقونة مع النص إذا أنزلها المستخدم عليه، لكنها لا تتجاوز إطار الزر.
- اختفاء حقول Add Style: الحقول الأصلية في `view_button_style.xml` وروابط Normal/Pressed ما زالت موجودة. المشكلة المتوقعة قياس ScrollView بارتفاع 0dp داخل نافذة غير محدودة. عُيّنت أبعاد نافذة محدودة بحسب الشاشة، مع scroll للحقول الأصلية؛ لا تغيير لقيم أو أنواع حقول الستايل الستة. يظل تشغيل Animation ومدتها موجودين.
- Menu View: `menuBackgroundOpacity` 0..100 (افتراضي80)، `menuScale` 50..150% (افتراضي100)، `menuLength` 160..360dp (افتراضي232). الحجم يشمل الرسم والنص والأيقونة، والطول مستقل. القياسات والموقع محصورة بالشاشة، والقيم محفوظة مع MenuSetting. العتامة لخلفية البطاقة فقط، لا للنص أو الأيقونة.
- الخط: صف Change controller font في Launcher Settings ضمن إعدادات اللعبة، اختيار .ttf أو .otf بمدير الملفات الداخلي؛ ينطبق على نصوص ControlButton وأزرار الاتجاه ومعاينات الأنماط فقط. لا يتغير خط واجهة الانشر.
- `ControllerFont.java`: ينسخ الخط إلى مجلد التطبيق الداخلي باسم `controller-font`، بحد20MiB؛ يتحقق عبر Typeface قبل الاستبدال، ويحاول atomic move مع بديل عند عدم الدعم. الاستيراد على خلفية منفصلة؛ الخط القديم يبقى عند فشل القراءة أو التحقق. حذف الملف الأصلي بعد الاستيراد لا يؤثر؛ يعاد تحميل النسخة الداخلية بعد التشغيل. Reset يحذف النسخة ويعيد Typeface الأصلي للضوابط المسجلة. WeakHashMap تتجنب الاحتفاظ بعروض مغلقة. الخط لا يُضمّن في JSON مشاركة التحكم.
- أضيفت نصوص إنجليزية وعربية للخيارات والأشكال الجديدة. بقية اللغات ترجع للإنجليزية عند عدم وجود ترجمة.
- FCLNumberSeekBar يقبل إدخال أرقام سالبة للحقول التي min<0؛ لا تغيير للحقول الموجبة.

### مسارات مهمة

```text
FCL/src/main/java/com/tungsten/fcl/control/ControllerIconRegistry.kt
FCL/src/main/java/com/tungsten/fcl/control/ControllerIconGeometry.java
FCL/src/main/java/com/tungsten/fcl/control/ControllerFont.java
FCL/src/main/java/com/tungsten/fcl/control/data/ControlButtonData.java
FCL/src/main/java/com/tungsten/fcl/control/data/ControlButtonStyle.java
FCL/src/main/java/com/tungsten/fcl/control/EditButtonDetails.kt
FCL/src/main/java/com/tungsten/fcl/control/AddButtonStyleDialog.java
FCL/src/main/java/com/tungsten/fcl/control/ButtonStyleTransition.java
FCL/src/main/java/com/tungsten/fcl/control/view/ControlButton.java
FCL/src/main/java/com/tungsten/fcl/control/view/ControlDirection.java
FCL/src/main/java/com/tungsten/fcl/control/view/MenuView.kt
FCL/src/main/java/com/tungsten/fcl/control/GameMenu.java
FCL/src/main/java/com/tungsten/fcl/control/RightMenuAdapter.kt
FCL/src/main/java/com/tungsten/fcl/setting/MenuSetting.kt
FCL/src/main/java/com/tungsten/fcl/ui/setting/LauncherSettingPage.java
FCL/src/main/java/com/tungsten/fcl/ui/setting/LauncherSettingAdapter.kt
FCL/src/main/java/com/tungsten/fcllibrary/component/view/FCLNumberSeekBar.kt
FCL/src/main/java/com/tungsten/fclauncher/bridge/FrameRateSampler.java
FCL/src/main/java/com/tungsten/fclauncher/bridge/FCLBridge.java
FCL/src/main/res/layout/view_edit_button_info.xml
FCL/src/main/res/layout/dialog_add_button_style.xml
FCL/src/main/res/layout/view_button_style.xml
FCL/src/main/res/drawable/controller_icon_*.xml
FCL/src/main/res/values/controller_appearance.xml
FCL/src/main/res/values-ar/controller_appearance.xml
FCL/src/test/java/com/tungsten/fcl/control/data/ControllerAppearanceTest.java
FCL/src/test/java/com/tungsten/fclauncher/bridge/FrameRateSamplerTest.java
FCL/build.gradle.kts
version_map.json
CHANGELOG.md
.github/workflows/publish-release.yml
.github/workflows/build.yml
.github/workflows/check-codes.yml
.github/workflows/sync-version-map.yml
```

## C. إجراءات البناء والنشر والتحقق

1. اقرأ أحدث main أولًا وقارنه بأساس العمل؛ لا تدفع snapshot قديمًا فوق تعديلات شخص آخر.
2. استخدم JDK17 (Java25 سبب مشكلة Gradle سابقة)، SDK platform35، build-tools35.0.0، NDK27.0.12077973 وCMake3.22.1، وتحقق من build.gradle لأي تغيير في المتطلبات.
3. لا تشغّل `updateMap` عشوائيًا: تنفيذه يستبدل أسطر versionName/versionCode وغيرها بالـregex وقد يعدّل سجل الإصدارات كله. حرر entry الجديدة بدقة، وأبقِ روابط الـfork صحيحة.
4. حدّث versionCode وversionName وversion_map[0] وCHANGELOG وملف التسليم في نفس دفعة المصدر. لأن push إلى main يبدأ Publish Release تلقائيًا، لا تدفع ميزة أولًا ثم تصلح رقم الإصدار لاحقًا.
5. أوامر الفحص (المسارات /data خاصة ببيئة الجلسة، وليست جزءًا من المستودع):

```bash
export JAVA_HOME=/data/tools/jdk17
export ANDROID_HOME=/data/android-sdk
export PATH="$JAVA_HOME/bin:$PATH"
./gradlew :FCL:testFordebugUnitTest \
  --tests com.tungsten.fcl.control.data.ControllerAppearanceTest \
  --tests com.tungsten.fclauncher.bridge.FrameRateSamplerTest --no-daemon
./gradlew checkstyle --no-daemon
# بناء اختياري محلي؛ GitHub matrix يستخدم الأمر نفسه لكل arch
./gradlew assemblerelease -Darch=arm64-v8a --no-daemon
```

6. Publish Release يحل tag من version_map[0] عند push main، ويتخطى إعادة البناء إذا كان الإصدار لديه assets. يستدعي build.yml بـsecrets:inherit لبناء all/arm64-v8a/armeabi-v7a/x86/x86_64، ثم يجمع artifacts وينشرها مع قسم CHANGELOG الموافق للوسم.
7. لا تغيّر مفتاح التوقيع ولا تطبعه. حافظ على الأسرار كما هي. الـcert fingerprint المذكور بصمة عامة للمقارنة فقط.
8. انتظر نجاح مصفوفة الخمسة + release وCheck Codes. لا يكفي وجود run. افحص Release العامة وأنها ليست Draft/Prerelease، وعدد وأسماء APK وأحجامها، ثم طابق tag مع commit المصدر.
9. نزّل arm64 APK المنشور وافحصه (مثال للإصدار الجديد):

```bash
curl -fL -o /tmp/fcl-arm64.apk \
  https://github.com/t86952356-eng/FoldCraftLauncher-Elite-/releases/download/1.3.4.3/FCL-release-1.3.4.3-arm64-v8a.apk
"$ANDROID_HOME/build-tools/35.0.0/aapt2" dump badging /tmp/fcl-arm64.apk
"$ANDROID_HOME/build-tools/35.0.0/apksigner" verify --print-certs /tmp/fcl-arm64.apk
git ls-remote origin 'refs/tags/1.3.4.3*'
```

10. بعد النشر، أضف نتائج التحقق الفعلية إلى MD. دفعة MD فقط على main قد تبدأ Publish Release لكن Prepare يتخطى البناء لوجود assets؛ لا تحرك الـtag إلى دفعة التوثيق. build.yml يتجاهل MD فقط.
11. إذا غابت أدوات Actions عن MCP أو أعاد API العام403 rate limit، استخدم صفحات Actions/Release العامة للتحقق. لا تعِد محاولات API بلا تغيير، ولا تخمّن Run IDs أو حالات نجاح. استخدم MCP الآمن للكتابة ولا تطلب Token كنص.
12. في هذه الجلسة أُعيد تهيئة sandbox، فأعيد clone وتجهيزJDK/SDK؛ لا تفترض بقاء أدوات /data بين الجلسات. عند إضافة values-ar أنشئ المجلد أولًا إذا لم يكن موجودًا. عولج ذلك قبل النشر.

### اختبارات الجهاز المطلوبة لاحقًا (لم تُجرَ هنا)

- افتح Add Style في وضع عمودي وأفقي وشاشة صغيرة؛ تحقق أن حقول Normal/Pressed الأصلية الستة كلها قابلة للوصول وأن الانتقال ومدته يعملان.
- جرّب 24 شكلًا جديدًا، وحجم14 وoffset سالب/موجب، وتغيير حجم زر صغير أثناء حركة الستايل؛ احفظ واخرج وأعد الفتح وصدّر/استورد التحكم.
- اضبط Menu View إلى0/100% عتامة،50/150%حجم،160/360dp طول؛ اسحبها للحواف، أعد التشغيل وجرّب PNG/GIF ومفاتيح العدادات.
- استورد TTF وOTF صالحين (ومن content URI)، جرّب ملفًا تالفًا وملفًا كبيرًا، ثم احذف الأصل وأعد تشغيل التطبيق وتأكد من ثبات الخط؛ Reset يعيد الخط الأصلي دون تغيير واجهة الانشر.
- ثبّت APK كتحديث فوق1.3.4.2 وتحقق من بقاء التحكم والإعدادات وإدخال اللعبة.

## D. سجل التحقق النهائي لـ1.3.4.3

**الحالة وقت تجهيز دفعة المصدر:** قيد الفحص والبناء؛ لم يُسجّل نشر ناجح لهذا الإصدار بعد. سيُضاف سجل نهائي بعد التحقق من GitHub وAPK، ولا يجوز استنتاج النجاح من وصف التنفيذ وحده.

### فحوص محلية قبل رفع المصدر

- نجح `testFordebugUnitTest` للمجموعتين المستهدفتين: 12 اختبارًا (10 ControllerAppearanceTest +2 FrameRateSamplerTest)، صفر فشل وأخطاء. تشمل النسخ والتصدير وحفظ الإزاحة وحفظ خيارات القائمة وحدود الإزاحة وIDs الـ53 وتوافق حركات الستايل وقراءةFPS المشتركة.
- نجح Checkstyle وترجمة Java/Kotlin بعد تجهيز رقم1.3.4.3.
- حُللت376مواردXML بنجاح، وتحقق وجود53IDفريدًا وملفاتها، وترجمة الأشكال الجديدة العربية. عوينت بصريًا صورة مجمعة للأشكال24.
- بقي view_button_style.xml الأصلي مطابقًا بايتًا لنسخةmain، ولم تُستبدل حقول Normal/Pressed الأصلية.
- أساسmain تحقّق قبل الرفع بأنه97311cc1ab0d5f146cd6104a3198b9db634ccbf8؛ لا تغييرات خارجية ظهرت وقت الفحص.
- لا يعني هذا السجل نجاحActions أو نشرAPK بعد؛ يلزم السجل النهائي التالي.
