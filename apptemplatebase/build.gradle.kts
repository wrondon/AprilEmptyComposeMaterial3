plugins {
    id ("com.android.application")
    id ("org.jetbrains.kotlin.android")
    id ("androidx.navigation.safeargs.kotlin")
    id ("kotlin-kapt")
    id ("com.google.devtools.ksp") version "1.8.10-1.0.9"
    id ("dagger.hilt.android.plugin")
    id ("org.jetbrains.kotlin.plugin.serialization") version "1.8.10"
}

android {
    namespace = "com.example.apptemplatebase"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.apptemplatebase"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt {
    correctErrorTypes =  true
}

dependencies {

    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("androidx.activity:activity-compose:1.7.0")

    val composeBom = platform("androidx.compose:compose-bom:2023.03.00")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-graphics")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.compose.material3:material3")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
    debugImplementation ("androidx.compose.ui:ui-tooling")
    debugImplementation ("androidx.compose.ui:ui-test-manifest")
//////////////
    implementation( "com.google.devtools.ksp:symbol-processing-api:1.8.20-Beta-1.0.9")
    kapt ("com.google.dagger:hilt-compiler:2.45")
    implementation( "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

    /// Dec, 2022
    implementation( "androidx.activity:activity-compose:1.7.0")
    implementation( "androidx.appcompat:appcompat:1.6.1")
    implementation( "com.google.android.material:material:1.8.0")
    implementation( "androidx.constraintlayout:constraintlayout:2.1.4")


//    ////// COMPOSE ToolKit.
//    val compose_version = "1.3.1"
//    implementation( "androidx.compose.ui:ui:1.4.0")
//    // Tooling support (Previews, etc.)
//    implementation( "androidx.compose.ui:ui-tooling:1.4.0")
//    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
//    implementation( "androidx.compose.foundation:foundation:1.4.0")
//    // Material Design
//    implementation( "androidx.compose.material:material:1.4.0")
//    // Material design icons
//    implementation( "androidx.compose.material:material-icons-core:1.4.0")
//    implementation( "androidx.compose.material:material-icons-extended:1.4.0")
//    // Integration with activities
//    implementation( "androidx.activity:activity-compose:1.7.0")
//    // Integration with ViewModels
//    implementation( "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
//    // Integration with observables
//    implementation( "androidx.compose.runtime:runtime-livedata:1.4.0")
//    implementation( "androidx.compose.runtime:runtime-rxjava2:1.4.0")


    ////// NAVIGATION - ALL (VIEWS, etc)
    val nav_version = "2.5.3"

    // Java language implementation(
    implementation( "androidx.navigation:navigation-fragment:$nav_version")
    implementation( "androidx.navigation:navigation-ui:$nav_version")

    // Kotlin
    implementation( "androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation( "androidx.navigation:navigation-ui-ktx:$nav_version")

    // Feature module Support
    implementation( "androidx.navigation:navigation-dynamic-features-fragment:$nav_version")

    // Testing Navigation
    androidTestImplementation ("androidx.navigation:navigation-testing:$nav_version")

    // Jetpack Compose Integration
    implementation( "androidx.navigation:navigation-compose:$nav_version")

    ///// Navigation DSL
    api ("androidx.navigation:navigation-fragment-ktx:$nav_version")

    ////// HILT-DAGGER
    implementation( "com.google.dagger:hilt-android:2.45")
    ///   ksp ("com.google.dagger:hilt-compiler:2.45")
    implementation( "androidx.hilt:hilt-navigation-compose:1.0.0")

    ////// ROOM
    val room_version = "2.5.1"

    implementation( "androidx.room:room-runtime:$room_version")
    implementation( "androidx.room:room-ktx:$room_version")
    ksp ("androidx.room:room-compiler:$room_version")

    // optional - RxJava2 support for Room
    implementation( "androidx.room:room-rxjava2:$room_version")

    // optional - RxJava3 support for Room
    implementation( "androidx.room:room-rxjava3:$room_version")

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation( "androidx.room:room-guava:$room_version")

    // optional - Test helpers
    testImplementation ("androidx.room:room-testing:$room_version")

    // optional - Paging 3 Integration
    implementation( "androidx.room:room-paging:2.5.1")

    ////// LIFECYCLE-VIEW-MODEL-LIVEDATA
    val lifecycle_version = "2.6.0-alpha05"
    val arch_version = "2.1.0"

    // ViewModel
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    // ViewModel utilities for Compose
    implementation( "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")
    // LiveData
    implementation( "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    // Lifecycles only (without ViewModel or LiveData)
    implementation( "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")

    // Saved state module for ViewModel
    implementation( "androidx.lifecycle:lifecycle-viewmodel-savedstate:2.6.1")

    // Annotation processor
    ////kapt "androidx.lifecycle:lifecycle-compiler:$lifecycle_version"
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    ///////implementation( "androidx.lifecycle:lifecycle-common-java8:$lifecycle_version"

    // optional - helpers for implementing LifecycleOwner in a Service
    implementation( "androidx.lifecycle:lifecycle-service:2.6.1")

    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation( "androidx.lifecycle:lifecycle-process:2.6.1")

    // optional - ReactiveStreams support for LiveData
    implementation( "androidx.lifecycle:lifecycle-reactivestreams-ktx:2.6.1")

    // optional - Test helpers for LiveData

    testImplementation ("androidx.arch.core:core-testing:2.2.0")

    ////// COROUTINES
    implementation( "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    //////SPLASHSCREEN
    implementation( "androidx.core:core-splashscreen:1.0.0")

    implementation( "com.google.code.gson:gson:2.10.1")
    implementation( "com.squareup.retrofit2:converter-gson:2.9.0")
    implementation( "com.squareup.retrofit2:retrofit:2.9.0")

    ////////////-------------------------
    //// External Libraries
    implementation( "com.google.code.gson:gson:2.10.1")
    implementation( "com.github.bumptech.glide:glide:4.14.2")
    // Skip this if you don"t want to use integration libraries or configure Glide.
    /////////////////annotationProcessor "com.github.bumptech.glide:compiler:4.12.0"

    /////implementation( "com.squareup.picasso:picasso:2.71828"

    implementation( "com.squareup.retrofit2:retrofit:2.9.0")
    implementation( "com.squareup.retrofit2:converter-gson:2.9.0")
    implementation( "com.squareup.retrofit2:converter-moshi:2.9.0")

    implementation("com.squareup.moshi:moshi:1.14.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.moshi:moshi-adapters:1.14.0")
    // kapt("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    ////okhttp
    ////implementation(("com.squareup.okhttp3:okhttp:4.9.3")
    ////testimplementation(("com.squareup.okhttp3:mockwebserver:4.9.3")

    ////okio
    ////implementation(("com.squareup.okio:okio:3.0.0")

    //// Acompaniest
    implementation( "com.google.accompanist:accompanist-insets:0.23.1")
    // If using insets-ui
    implementation( "com.google.accompanist:accompanist-insets-ui:0.23.1")
    implementation( "com.google.accompanist:accompanist-systemuicontroller:0.28.0")
    implementation( "com.google.accompanist:accompanist-appcompat-theme:0.28.0")
    implementation( "com.google.accompanist:accompanist-pager:0.28.0")

    // If using indicators, also depend on
    implementation( "com.google.accompanist:accompanist-pager-indicators:0.23.1")
    implementation( "com.google.accompanist:accompanist-swiperefresh:0.28.0")
    // If you"re using Material, use accompanist-placeholder-material
    implementation( "com.google.accompanist:accompanist-placeholder-material:0.23.1")
    // Otherwise use the foundation version
    implementation( "com.google.accompanist:accompanist-placeholder:0.28.0")
    implementation( "com.google.accompanist:accompanist-drawablepainter:0.25.1")
    implementation( "com.google.accompanist:accompanist-flowlayout:0.28.0")
    implementation( "com.google.accompanist:accompanist-permissions:0.28.0")
    implementation( "com.google.accompanist:accompanist-navigation-animation:0.23.1")
    implementation( "com.google.accompanist:accompanist-navigation-material:0.23.1")
    implementation( "com.google.accompanist:accompanist-webview:0.28.0")

    implementation("io.coil-kt:coil:2.2.2")
    implementation("io.coil-kt:coil-compose:2.2.2")

    implementation( "com.jakewharton.timber:timber:5.0.1")

    implementation( "io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation( "io.reactivex.rxjava3:rxjava:3.1.6")
    implementation( "io.reactivex.rxjava3:rxkotlin:3.0.1")

    implementation( "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

    implementation( "io.ktor:ktor-client-core:2.2.3")
    implementation( "io.ktor:ktor-client-cio:2.2.3")
    implementation( "io.ktor:ktor-client-content-negotiation:2.2.3")
    implementation( "io.ktor:ktor-serialization-kotlinx-json:2.2.3")
    implementation( "io.ktor:ktor-serialization-gson:2.2.3")

}