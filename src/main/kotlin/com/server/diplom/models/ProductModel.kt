package com.server.diplom.models

class ProductModel {
    private var name: String = ""

    fun getName(): String { return name }

    fun setName(name: String) {
        this.name = name;
    }
}