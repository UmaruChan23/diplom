package com.server.diplom.service

import com.server.diplom.entity.Product
import com.server.diplom.entity.Provider
import com.server.diplom.repo.ProvidersRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProviderService(@Autowired val repo: ProvidersRepo) {

    fun getAll(): List<Provider> {
        return repo.findAll()
    }

    fun getOne(name: String): Provider{
        return repo.getByName(name)
    }

    fun save(name: String)  {
        val products: List<Product> = listOf()
        val provider = Provider(0, name, products)
        repo.save(provider)
    }

    fun addProduct(id: Int, product: Product) {
        val provider = repo.getById(id)
        provider
    }
}