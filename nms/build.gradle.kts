plugins {
	id("echopet-conventions")
	id("io.papermc.paperweight.userdev") version "1.7.1"
}

subprojects {
	apply(plugin = "io.papermc.paperweight.userdev")
}

dependencies {
	api(project(":api"))
	paperweight.paperDevBundle("1.21-R0.1-SNAPSHOT")
}