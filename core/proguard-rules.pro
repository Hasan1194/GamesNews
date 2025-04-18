-dontwarn javax.lang.model.element.Modifier

# Keep generic signature of Call, Response (R8 full mode strips signatures from non-kept items).
 -keep,allowobfuscation,allowshrinking interface retrofit2.Call
 -keep,allowobfuscation,allowshrinking class retrofit2.Response

 # With R8 full mode generic signatures are stripped for classes that are not
 # kept. Suspend functions are wrapped in continuations where the type argument
 # is used.
 -dontwarn java.lang.invoke.StringConcatFactory
 -keep,allowobfuscation,allowshrinking class kotlin.coroutines.Continuation
-keep class com.h1194.core.data.Resource { *; }
-keep class com.h1194.core.data.Resource$* { *; }
-keep class com.h1194.core.domain.model.** { *; }
-keep class com.h1194.core.domain.repository.** { *; }
-keep class com.h1194.core.domain.usecase.** { *; }
-keep class com.h1194.core.di.** { *; }
-keep class com.h1194.core.util.** { *; }
-keep class com.h1194.core.data.source.remote.response.** { *; }

