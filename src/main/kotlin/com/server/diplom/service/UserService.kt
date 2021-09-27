package com.server.diplom.service

import com.server.diplom.entity.Role
import com.server.diplom.entity.User
import com.server.diplom.repo.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext


@Service
class UserService(@Autowired val userRepository: UserRepo,
                  @Autowired val bCryptPasswordEncoder: BCryptPasswordEncoder,
                  @PersistenceContext private val em: EntityManager) : UserDetailsService {

    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findByUsername(username)!!
    }

    fun findUserById(userId: Long): User {
        val userFromDb: Optional<User> = userRepository.findById(userId)
        return userFromDb.orElse(User())
    }

    fun allUsers(): List<User> {
        return userRepository.findAll()
    }

    fun saveUser(user: User): Boolean {
        val userFromDB: User? = userRepository.findByUsername(user.username)
        if (userFromDB != null) {
            return false
        }
        user.setRoles(Collections.singleton(Role(1L, "ROLE_USER")))
        user.password = bCryptPasswordEncoder.encode(user.password)
        userRepository.save(user)
        return true
    }

    fun deleteUser(userId: Long): Boolean {
        if (userRepository.findById(userId).isPresent) {
            userRepository.deleteById(userId)
            return true
        }
        return false
    }

    fun usergtList(idMin: Long): List<User> {
        return em.createQuery("SELECT u FROM User u WHERE u.id > :paramId", User::class.java)
            .setParameter("paramId", idMin).resultList
    }
}