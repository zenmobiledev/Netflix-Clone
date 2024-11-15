import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = "com.mobbelldev.netflixclone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mobbelldev.netflixclone"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())

        buildConfigField(
            type = "String",
            name = "API_KEY_AUTH",
            value = "\"${properties.getProperty("API_KEY")}\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
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
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // https://github.com/square
    implementation(libs.retrofit)
    implementation(libs.gson)
    implementation(libs.okhttp)

    // lifecycle
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // android x
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.fragment.ktx)

    // https://github.com/PierfrancescoSoffritti/android-youtube-player
    implementation(libs.youtube.player)

    // https://github.com/iamBedant/OutlineTextView
    implementation(libs.outline.text.view) {
        exclude(
            group = "com.android.support",
            module = "support-compat",
        )
    }

    // https://github.com/bumptech/glide
    implementation(libs.glide)
    ksp(libs.glide.compiler)

    // https://insert-koin.io/
//    implementation(libs.koin.android)
//    implementation(libs.koin.core)

    // https://dagger.dev/
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)


    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
