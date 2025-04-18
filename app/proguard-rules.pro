# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable
-keepclassmembers public class * extends android.view.View {
  public static <methods>;
}
# Keep favorite module
-keep class com.h1194.favorite.** { *; }
-keepclassmembers class com.h1194.favorite.** { *; }

# Keep deep link handling
-keepattributes *Annotation*

# Keep activities with intent filters (for deep linking)
-keep public class * extends android.app.Activity
-keep public class * extends androidx.appcompat.app.AppCompatActivity
-keepclassmembers class * extends android.app.Activity {
    public void *(android.view.View);
}

# Keep AndroidManifest components
-keep class **.R
-keep class **.R$* {
    <fields>;
}
# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
# Please add these rules to your existing keep rules in order to suppress warnings.
# This is generated automatically by the Android Gradle plugin.
-dontwarn java.lang.invoke.StringConcatFactory
-dontwarn com.h1194.core.data.Resource$Error
-dontwarn com.h1194.core.data.Resource$Loading
-dontwarn com.h1194.core.data.Resource$Success
-dontwarn com.h1194.core.data.Resource
-dontwarn com.h1194.core.databinding.ItemListTourismBinding
-dontwarn com.h1194.core.di.CoreModuleKt
-dontwarn com.h1194.core.domain.model.Games
-dontwarn com.h1194.core.domain.repository.IGamesRepository
-dontwarn com.h1194.core.domain.usecase.GamesInteractor
-dontwarn com.h1194.core.domain.usecase.GamesUseCase
-dontwarn com.google.android.gms.common.annotation.NoNullnessRewrite