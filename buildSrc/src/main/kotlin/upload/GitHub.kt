@file:Suppress("EXPERIMENTAL_API_USAGE")

package upload

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.HttpTimeout
import io.ktor.client.request.put
import kotlinx.coroutines.runBlocking
import org.gradle.api.Project
import org.gradle.kotlin.dsl.provideDelegate
import java.io.File
import java.util.*

object GitHub {

    private fun getGithubToken(project: Project): String {
        kotlin.runCatching {
            @Suppress("UNUSED_VARIABLE", "LocalVariableName")
            val github_token: String by project
            return github_token
        }

        System.getProperty("github_token", "~")?.let {
            return it.trim()
        }

        File(File(System.getProperty("user.dir")).parent, "/token.txt").let { local ->
            if (local.exists()) {
                return local.readText().trim()
            }
        }

        File(File(System.getProperty("user.dir")), "/token.txt").let { local ->
            if (local.exists()) {
                return local.readText().trim()
            }
        }

        error(
            "Cannot find github token, " +
                    "please specify by creating a file token.txt in project dir, " +
                    "or by providing JVM parameter 'github_token'"
        )
    }

    fun upload(file: File, url: String, project: Project) = runBlocking {
        HttpClient(CIO) {
            engine {
                requestTimeout = 600_000
            }
            install(HttpTimeout) {
                connectTimeoutMillis = 600_000
                requestTimeoutMillis = 600_000
                socketTimeoutMillis = 600_000
            }
        }.put<String>("""$url?access_token=${getGithubToken(project)}""") {
            val content = String(Base64.getEncoder().encode(file.readBytes()))
            body = """
                    {
                      "message": "automatic upload",
                      "content": "$content"
                    }
                """.trimIndent()
        }
    }
}