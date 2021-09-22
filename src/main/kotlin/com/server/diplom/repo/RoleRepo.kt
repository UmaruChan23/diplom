package com.server.diplom.repo

import com.server.diplom.entity.Role
import org.springframework.data.jpa.repository.JpaRepository

interface RoleRepo: JpaRepository<Role, Long> {
}