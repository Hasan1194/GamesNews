#-dontwarn java.lang.invoke.StringConcatFactory
#
#-keep class com.h1194.tourismapp.core.data.Resource { *; }
#-keep class com.h1194.tourismapp.core.data.Resource$* { *; }
#-keep class com.h1194.tourismapp.core.domain.model.** { *; }
#-keep class com.h1194.tourismapp.core.data.Resource$* { *; }
#-keep class com.h1194.tourismapp.core.domain.repository.** { *; }
#-keep class com.h1194.tourismapp.core.domain.usecase.** { *; }
#-keep class com.h1194.tourismapp.core.di.** { *; }
#-keep class com.h1194.tourismapp.core.util.** { *; }
#-keep class com.h1194.core.data.source.remote.response.** { *; }

-dontwarn javax.lang.model.element.Modifier

-keep class com.h1194.core.di.** { *; }
-keepclassmembers class com.h1194.core.di.** { *; }

-keep class com.h1194.core.domain.usecase.** { *; }
-keepclassmembers class com.h1194.core.domain.usecase.** { *; }

-keep class com.h1194.core.databinding.** { *; }
-keepclassmembers class com.h1194.core.databinding.** { *; }

-keep class com.h1194.core.ui.** { *; }
-keepclassmembers class com.h1194.core.ui.** { *; }

-keep class com.h1194.core.data.** { *; }
-keepclassmembers class com.h1194.core.data.** { *; }

