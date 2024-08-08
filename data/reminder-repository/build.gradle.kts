plugins {
    libs.plugins.yadino.run{
        alias(android.library)
        alias(android.hilt)
    }
}

android {
    namespace = "com.rahim.yadino.reminder_repository"
}
dependencies {
    api(project(":domain:reminder"))
    api(project(":domain:reminder"))
    implementation(project(":core:base"))
}