import com.android.build.api.dsl.LibraryExtension
import com.kanoyatech.convention.ExtensionType
import com.kanoyatech.convention.configureBuildTypes
import com.kanoyatech.convention.configureKotlinAndroid
import com.kanoyatech.convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class JvmLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.apply("org.jetbrains.kotlin.jvm")

            configureKotlinJvm()
        }
    }
}