package com.server.diplom.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CodeController {

    @GetMapping("/code")
    fun getRandomCode(): String {
        val code = randomID()
        return code
    }

    private fun randomID(): String = List(5) {
        List(4) { (('a'..'z') + ('A'..'Z') + ('0'..'9')).random()
        }.joinToString("")
    }.joinToString("-")
}