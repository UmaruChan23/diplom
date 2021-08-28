package com.server.diplom.repo

import com.server.diplom.entity.Provider
import org.springframework.data.jpa.repository.JpaRepository

interface ProvidersRepo: JpaRepository<Provider, Int> {
    fun getByName(name: String): Provider
}