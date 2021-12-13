package com.server.diplom.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "license")
data class License(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private val id: Long,

    var code: Long,

    val product: String,

    val activationDate: Date,

    val endingDate: Date,

    val devices: Int,

    val type: String,

    var activated: Boolean
    )