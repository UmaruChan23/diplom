package com.server.diplom.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*
import javax.validation.constraints.Size;


@Entity
@Table(name = "t_user")
class User : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null

    @Column(length = 65535, columnDefinition = "text")
    private var username: String? = null

    @Size(min = 2, message = "Не меньше 5 знаков")
    private var password: String? = null

    @Transient
    private var passwordConfirm: String? = null

    @ManyToMany(fetch = FetchType.EAGER)
    private var roles: Set<Role?>? = null
    fun getId(): Long? {
        return id
    }

    fun setId(id: Long?) {
        this.id = id
    }

    override fun getUsername(): String? {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

    fun setUsername(username: String?) {
        this.username = username
    }

    override fun getAuthorities(): Collection<GrantedAuthority?>? {
        return getRoles()
    }

    override fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    fun getPasswordConfirm(): String? {
        return passwordConfirm
    }

    fun setPasswordConfirm(passwordConfirm: String?) {
        this.passwordConfirm = passwordConfirm
    }

    fun getRoles(): Set<Role?>? {
        return roles
    }

    fun setRoles(roles: Set<Role?>?) {
        this.roles = roles
    }
}