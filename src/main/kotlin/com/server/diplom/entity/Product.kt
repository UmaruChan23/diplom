package com.server.diplom.entity

import javax.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    val name: String = "",

    val isBlocked: Boolean = false
)
{
    fun getId(): Long { return id }
}