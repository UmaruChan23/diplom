package com.server.diplom.controller

import com.server.diplom.entity.Product
import com.server.diplom.models.ProductModel
import com.server.diplom.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/products")
class ProductController(@Autowired private val service: ProductService) {

    @GetMapping("/list")
    fun getProductList(model: Model): String {
        model.addAttribute("productTemplate", ProductModel())
        model.addAttribute("products", service.getAll())
        return "productList"
    }

    @PostMapping("/add")
    fun addProduct(productModel: ProductModel, model: Model): String {
        val product = Product(0, productModel.getName())
        service.create(product)
        model.addAttribute("productTemplate", ProductModel())
        model.addAttribute("products", service.getAll())
        return "productList"
    }
}