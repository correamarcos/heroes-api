package com.marcoscorrea.heroes

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HeroesApiApplication

fun main(args: Array<String>) {
	runApplication<HeroesApiApplication>(*args)
}
