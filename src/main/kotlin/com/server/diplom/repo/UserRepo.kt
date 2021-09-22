package com.server.diplom.repo

import com.server.diplom.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo: JpaRepository<User, Long> {
    fun findByUsername(name: String?): User?
}