plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.jvm.ktor)
}

android {
    namespace = "com.kanoyatech.run.network"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.data)
}
