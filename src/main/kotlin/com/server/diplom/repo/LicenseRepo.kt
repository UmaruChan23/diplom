package com.server.diplom.repo

import com.server.diplom.entity.License
import org.springframework.data.jpa.repository.JpaRepository

interface LicenseRepo: JpaRepository<License, Long> {
    fun findByCode(codeId: Long): License
}