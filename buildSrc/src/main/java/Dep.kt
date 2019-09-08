object Dep {

  object Version {
    // library
    const val buildGradle = "3.2.0"
    const val kotlin = "1.3.31"
    const val coroutine = "1.1.0"
    const val androidX = "1.0.0"
    const val lifecycle = "2.1.0-alpha01"
    const val constraintLayout = "2.0.0-alpha2"
    const val navigation = "2.1.0-alpha06"
    const val room = "2.1.0-alpha03"
    const val dagger = "2.16"
    const val retrofit = "2.3.0"
    const val okhttp = "3.11.0"
    const val groupie = "2.3.0"
    const val googleServicesVersion = "17.0.0"


    const val glideVersion = "4.9.0"

    // library (test)
    const val junit = "4.12"
  }

  // plugin
  val pluginBuildGradle = "com.android.tools.build:gradle:${Version.buildGradle}"
  val pluginkotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
  val pluginsafeArgs =
    "android.arch.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"

  // kotlin
  val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"

  // coroutine
  val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
  val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
  val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutine}"

  // androidx
  val appCompat = "androidx.appcompat:appcompat:${Version.androidX}"
  val material = "com.google.android.material:material:${Version.androidX}"
  val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
  val coreKtx = "androidx.core:core-ktx:${Version.androidX}"
  val fragmentKtx = "androidx.fragment:fragment-ktx:${Version.androidX}"
  val collectionKtx = "androidx.collection:collection-ktx:${Version.androidX}"

  // navigation
  val navFragment = "androidx.navigation:navigation-fragment:${Version.navigation}"
  val navUi = "androidx.navigation:navigation-ui:${Version.navigation}"
  val navCommonKtx = "androidx.navigation:navigation-common-ktx:${Version.navigation}"
  val navRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Version.navigation}"
  val navFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navigation}"
  val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Version.navigation}"
//  val navTestKtx = "androidx.navigation:navigation-testing-ktx:${Version.navigation}"

  // android architecture component
  val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime:${Version.lifecycle}"
  val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Version.lifecycle}"
  val lifecycleReactivestreams = "androidx.lifecycle:lifecycle-reactivestreams:${Version.lifecycle}"
  val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Version.lifecycle}"
  val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Version.lifecycle}"
  val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
  val livedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"

  // dependency injection
  val dagger = "com.google.dagger:dagger:${Version.dagger}"
  val daggerCompiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
  val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger}"
  val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.dagger}"
  val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Version.dagger}"

  // network
  val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
  val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
  // replace after merged to retrofit https://github.com/square/retrofit/pull/2886
  val retrofitAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2"
  val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
  val mockWebServer = "com.squareup.okhttp3:mockwebserver:${Version.okhttp}"

  // storage
  val room = "androidx.room:room-runtime:${Version.room}"
  val roomCompiler = "androidx.room:room-compiler:${Version.room}"
  val roomCoroutine = "androidx.room:room-coroutines:${Version.room}"
  val roomTest = "androidx.room:room-testing:${Version.room}"

  // recycler view
  val groupie = "com.xwray:groupie:${Version.groupie}"
  val groupieDatabinding = "com.xwray:groupie-databinding:${Version.groupie}"

  // date
  val threetenabp = "com.jakewharton.threetenabp:threetenabp:1.1.1"

  // ui
  val circleImage = "de.hdodenhof:circleimageview:2.2.0"

  // image
  val picasso = "com.squareup.picasso:picasso:2.71828"
  val glide = "com.github.bumptech.glide:glide:${Version.glideVersion}"
  val glideKapt = "com.github.bumptech.glide:compiler:${Version.glideVersion}"

  // test
  val junit = "junit:junit:${Version.junit}"
  val mockk = "io.mockk:mockk:1.8.8.kotlin13"
  val assertj = "com.squareup.assertj:assertj-android:1.2.0"
  val testCore = "android.arch.core:core-testing:1.1.0"
  val orgThreetenbp = "org.threeten:threetenbp:1.3.3"
  val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${Version.kotlin}"

  //viewpump
  val viewpump = "io.github.inflationx:viewpump:2.0.2"

  //mask
  val decoro = "ru.tinkoff.decoro:decoro:1.3.5"

  //firebase
  val firebase = "com.google.firebase:firebase-core:17.0.0"

  //Maps services
  val mapsServices = "com.google.android.gms:play-services-maps:${Version.googleServicesVersion}"
  val location = "com.google.android.gms:play-services-location:${Version.googleServicesVersion}"
  val mapsUtils = "com.google.maps.android:android-maps-utils:0.5"

  // DebugDb
  val debugDb = "com.amitshekhar.android:debug-db:1.0.6"

}
