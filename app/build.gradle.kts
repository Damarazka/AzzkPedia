plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.damarazka.azzkpedia"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.damarazka.azzkpedia"
        minSdk = 33
        targetSdkPreview = "UpsideDownCake"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // splash screen
    implementation ("androidx.core:core-splashscreen:1.0.0")

    // picasso
    implementation ("com.squareup.picasso:picasso:2.8")

    // moshi - JSON converter
    implementation("com.squareup.moshi:moshi:1.14.0")
    // kotlin Codegen
    // biarin ksp-nya merah dulu
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0")

    // retrofit - request HTTP/HTTPS Web Service
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-moshi:2.9.0")

}