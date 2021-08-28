package com.server.diplom.entity

import javax.persistence.*

@Entity
@Table(name = "licenses")
data class License (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    val number: String,

    @ManyToOne(fetch = FetchType.LAZY)
    private val product: Product,
)