package com.act.spa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.act.spa.repository"])
class SpaApplication

fun main(args: Array<String>) {
    runApplication<SpaApplication>(*args)
}
