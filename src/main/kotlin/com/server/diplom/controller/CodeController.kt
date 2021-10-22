package com.server.diplom.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
class CodeController {

    @GetMapping("/code")
    fun getRandomCode(): Int {
        val code = Random.nextInt()
        return code
    }
}