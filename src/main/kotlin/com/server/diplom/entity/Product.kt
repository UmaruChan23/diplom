package com.server.diplom.entity

import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    val name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    private val provider: Provider,

    @OneToMany(mappedBy = "product", cascade = [CascadeType.ALL])
    val licenses: List<License>
)