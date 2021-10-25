package com.server.diplom.repo

import com.server.diplom.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepo: JpaRepository<Product, Long> {
    fun findByName(name: String): Product?
}