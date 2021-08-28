package com.server.diplom.controller

import com.server.diplom.entity.Product
import com.server.diplom.entity.Provider
import com.server.diplom.service.ProductService
import com.server.diplom.service.ProviderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/providers")
class ProvidersController(  @Autowired val service: ProviderService,
                            @Autowired val productService: ProductService) {

    @GetMapping("/all")
    fun getAll(): List<Provider> {
        return service.getAll();
    }

    @GetMapping
    fun getProvider(@RequestParam name: String): Provider {
        return service.getOne(name)
    }

    @PostMapping
    fun setProvider(@RequestParam name: String) {
        service.save(name)
    }

    @PostMapping("/products")
    fun addProduct(@RequestParam product: String, @RequestParam provider: String) {
        productService.addProduct(product, provider)
    }
}