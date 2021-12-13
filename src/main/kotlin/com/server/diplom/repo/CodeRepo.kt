package com.server.diplom.repo

import com.server.diplom.entity.ActivationCode
import org.springframework.data.jpa.repository.JpaRepository

interface CodeRepo: JpaRepository<ActivationCode, Long> {
    fun findByCode(code: String): ActivationCode?
}