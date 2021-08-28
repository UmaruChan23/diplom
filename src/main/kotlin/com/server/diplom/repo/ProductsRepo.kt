package com.server.diplom.repo

import com.server.diplom.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductsRepo: JpaRepository<Product, Int> {
}