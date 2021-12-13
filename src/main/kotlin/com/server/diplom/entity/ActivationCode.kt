package com.server.diplom.entity

import javax.persistence.*


@Entity
@Table(name = "code")
data class ActivationCode (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    var code: String
)