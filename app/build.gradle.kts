plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.task_influncers"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.task_influncers"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation ("com.google.dagger:hilt-android:2.55")
    ksp ("com.google.dagger:hilt-compiler:2.55")

    // For instrumentation tests
    androidTestImplementation  ("com.google.dagger:hilt-android-testing:2.55")
    kspAndroidTest ("com.google.dagger:hilt-compiler:2.55")

    // For local unit tests
    testImplementation ("com.google.dagger:hilt-android-testing:2.55")
    kspTest ("com.google.dagger:hilt-compiler:2.55")




    // Room (with KSP support)
    implementation ("androidx.room:room-runtime:2.6.1")
    ksp ("androidx.room:room-compiler:2.6.1")

    // Lifecycle components for MVVM
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.8.5")
    implementation ("androidx.navigation:navigation-ui-ktx:2.8.5")

    // RecyclerView
    implementation ("androidx.recyclerview:recyclerview:1.4.0")

    implementation("androidx.room:room-ktx:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")

    implementation("com.intuit.sdp:sdp-android:1.1.1")

}