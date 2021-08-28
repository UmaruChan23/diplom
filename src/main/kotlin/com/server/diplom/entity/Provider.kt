package com.server.diplom.entity

import javax.persistence.*

@Entity
@Table(name = "providers")
data class Provider (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = 0,

    val name: String = "",

    @OneToMany(mappedBy = "provider", cascade = [CascadeType.ALL])
    val products: List<Product>?
)

