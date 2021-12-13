package com.server.diplom.controller

import com.server.diplom.entity.License
import com.server.diplom.service.LicenseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CodeController(@Autowired private val service: LicenseService) {

    @PostMapping("/code")
    fun createLicense(@RequestBody license: License): String {
        return service.save(license)
    }

    @PostMapping("/activate")
    fun activateLicense(@RequestBody code: String): License?{
        //Как подписать объект?
        //Добавить поле?
        //Возвращать другой тип?
        return service.getByCode(code)
    }

}