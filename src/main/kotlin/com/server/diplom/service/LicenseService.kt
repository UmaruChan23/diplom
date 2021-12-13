package com.server.diplom.service

import com.server.diplom.entity.ActivationCode
import com.server.diplom.entity.License
import com.server.diplom.repo.CodeRepo
import com.server.diplom.repo.LicenseRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LicenseService(@Autowired private val licenseRepo: LicenseRepo,
                     @Autowired private val codeRepo: CodeRepo) {

    fun save(license: License): String {
        //если приходит существующий id, то обновляет. Мб вынести отдельно update
        if (license.)
        val activationCode = ActivationCode(0, randomID())
        codeRepo.save(activationCode)
        license.code = activationCode.id
        licenseRepo.save(license)
        return activationCode.code
    }

    fun getByCode(code: String): License? {
        val activationCode = codeRepo.findByCode(code) ?: return null
        val license = licenseRepo.findByCode(activationCode.id)
        license.activated = true
        codeRepo.delete(activationCode)
        licenseRepo.save(license)
        return license
    }

    private fun randomID(): String = List(5) {
        List(4) { (('a'..'z') + ('A'..'Z') + ('0'..'9')).random()
        }.joinToString("")
    }.joinToString("-")
}