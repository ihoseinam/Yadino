plugins {
    libs.plugins.yadino.run {
        alias(android.library)
    }
}

android {
    namespace = "com.rahim.yadino.domin.dateTime"
}
dependencies{
    implementation(project(":core:base"))
}
