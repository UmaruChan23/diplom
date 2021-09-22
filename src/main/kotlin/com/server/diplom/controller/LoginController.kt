package com.server.diplom.controller

import com.server.diplom.entity.User
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

import org.springframework.web.bind.annotation.RequestMapping

@Controller
class LoginController {

    @GetMapping("/login")
    fun login(model: Model): String? {
        val user= User()
        model.addAttribute("user", user)
        return "login"
    }

    @PostMapping("/login")
    fun findUser(user: User) {

    }

    // Login form with error
    @RequestMapping("/login-error")
    fun loginError(model: Model): String? {
        model.addAttribute("loginError", true)
        return "login"
    }


}