package com.server.diplom.service

import com.server.diplom.entity.Product
import com.server.diplom.repo.ProductRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(@Autowired private val repo: ProductRepo) {

    fun create(product: Product) {
        if (repo.findByName(product.name) == null) repo.save(product)
    }

    fun delete(id: Long) {
        repo.delete(repo.findById(id).get())
    }

    fun get(id: Long): Product {
        return repo.findById(id).get()
    }

    fun getAll(): List<Product> {
        return repo.findAll()
    }
}