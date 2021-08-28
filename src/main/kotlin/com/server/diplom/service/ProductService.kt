package com.server.diplom.service

import com.server.diplom.entity.License
import com.server.diplom.entity.Product
import com.server.diplom.repo.ProductsRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService(@Autowired val repo: ProductsRepo,
                    @Autowired val providers: ProviderService) {

    fun addProduct(name: String, providerName: String) {
        val provider = providers.getOne(providerName)
        val licenses: List<License> = listOf()
        val product = Product(0, name, provider, licenses)
        repo.save(product)
    }
}