package com.server.diplom.entity

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table


@Entity
@Table(name = "t_role")
class Role : GrantedAuthority {
    @Id
    private var id: Long? = null
    private var name: String? = null

    @Transient
    @ManyToMany(mappedBy = "roles")
    private var users: Set<User>? = null

    constructor() {}
    constructor(id: Long?) {
        this.id = id
    }

    constructor(id: Long?, name: String?) {
        this.id = id
        this.name = name
    }

    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getUsers(): Set<User>? {
        return users
    }

    fun setUsers(users: Set<User>?) {
        this.users = users
    }

    override fun getAuthority(): String? {
        return getName()
    }
}