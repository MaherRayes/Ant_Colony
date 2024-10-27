import com.github.spotbugs.SpotBugsTask
import de.aaschmid.gradle.plugins.cpd.Cpd
import org.gradle.jvm.tasks.Jar

plugins {
    java
    antlr
    jacoco
    pmd
    id("de.aaschmid.cpd") version "1.1"
    id("com.github.spotbugs") version "1.6.2"
}

repositories {
    jcenter()
    maven {
        url = uri("https://sopra2018.cispa.saarland/artifacts/sopra-lib")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_10
    targetCompatibility = JavaVersion.VERSION_1_10
    sourceSets {
        create("systemtests")

        "main" {
            compileClasspath += sourceSets["systemtests"].output
        }
    }
}

val systemtestsImplementation by configurations

configurations {
    // Check for updates every build
    all {
        resolutionStrategy {
            cacheChangingModulesFor(0, TimeUnit.SECONDS)
        }
    }
}

dependencies {
    implementation("saarland.cispa.sopra:sopra-lib:+") {
        isChanging = true
    }
    antlr("org.antlr:antlr4:4.7.1")
    implementation("org.slf4j:slf4j-api:1.7.25")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.3")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.2.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.2.0")
    implementation("commons-cli:commons-cli:1.4")

    spotbugs("com.github.spotbugs:spotbugs:3.1.6")
    spotbugsPlugins("com.mebigfatguy.fb-contrib:fb-contrib:7.4.2.sb")

    systemtestsImplementation("org.slf4j:slf4j-api:1.7.25")
    systemtestsImplementation("saarland.cispa.sopra:sopra-lib:+") {
        isChanging = true
    }
}

tasks.withType<JavaCompile> {
    options.compilerArgs.add("-Xlint")
    dependsOn("generateGrammarSource")
}

tasks.withType<Jar> {
    manifest.attributes["Main-Class"] = "saarland.cispa.sopra.Main"
    from(configurations.runtimeClasspath.map { if (it.isDirectory) it else zipTree(it) })
    from(java.sourceSets["main"].output)
    from(java.sourceSets["systemtests"].output)
    dependsOn("check")
}

tasks.withType<AntlrTask> {
    outputDirectory = file("$buildDir/generated-src/antlr/main/saarland/cispa/sopra/antlr")
    arguments = listOf("-visitor", "-listener", "-long-messages", "-package", "saarland.cispa.sopra.antlr")
}

cpd {
    toolVersion = "6.6.0"
    isIgnoreFailures = false
}

tasks.withType<Cpd> {
    dependsOn("detectSuppressions")
    exclude("saarland/cispa/sopra/antlr/*")
    minimumTokenCount = 66
}


pmd {
    toolVersion = "6.6.0"
    isIgnoreFailures = false
}

tasks.getByName<Pmd>("pmdMain") {
    ruleSets = listOf()
    ruleSetFiles = files("$projectDir/config/pmd_main.xml")
    exclude("saarland/cispa/sopra/antlr/*")
}

tasks.getByName<Pmd>("pmdSystemtests") {
    ruleSets = listOf()
    ruleSetFiles = files("$projectDir/config/pmd_systemtests.xml")
}

tasks.getByName<Pmd>("pmdTest") {
    ruleSets = listOf()
    ruleSetFiles = files("$projectDir/config/pmd_systemtests.xml")
}


tasks.withType<Pmd> {
    reports {
        xml.isEnabled = false
        html.isEnabled = true
    }
    dependsOn("detectSuppressions")
}

spotbugs {
    toolVersion = "3.1.6"
    isIgnoreFailures = false
    effort = "max"
    includeFilter = file("$projectDir/config/spotbugs_include.xml")
    excludeFilter = file("$projectDir/config/spotbugs_exclude.xml")
    sourceSets = listOf(java.sourceSets["main"])
}

tasks.withType<SpotBugsTask> {
    reports {
        xml.isEnabled = false
        html.isEnabled = true
    }
    dependsOn("detectSuppressions")
    pluginClasspath = project.configurations.spotbugsPlugins
}

tasks.getByName("check") {
    dependsOn("spotbugsSystemtests")
}

jacoco {
    toolVersion = "0.8.1"
}

tasks.withType<JacocoReport> {
    reports {
        xml.isEnabled = false
        csv.isEnabled = false
        html.destination = file("$buildDir/reports/jacoco")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}

tasks {
    "detectSuppressions" {
        val suppressionRegex = Regex("(CPD-OFF)|(NOPMD)|(Suppress(FB)?Warnings)", RegexOption.IGNORE_CASE)
        doLast {
            val suppressions = mutableListOf<Pair<String, Int>>()
            for (directory in java.sourceSets["main"].allJava.sourceDirectories.filter { "generated-src" !in it.path } +
                java.sourceSets["systemtests"].allJava.sourceDirectories) {
                for (file in directory.walk().filter { it.isFile }) {
                    var line = 0
                    file.forEachLine {
                        line += 1
                        if (suppressionRegex.containsMatchIn(it)) {
                            suppressions.add(file.toRelativeString(directory) to line)
                        }
                    }
                }
            }
            if (suppressions.isNotEmpty()) {
                throw InvalidUserCodeException("Suppressions of analysis tools detected in the following files: " +
                    suppressions.joinToString(System.lineSeparator(), System.lineSeparator()) { "${it.first}:${it.second}" })
            }
        }
    }
}
