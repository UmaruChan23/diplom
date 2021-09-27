package com.server.diplom.config

import com.server.diplom.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Configuration
@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    @Bean
    fun bCryptPasswordEncoder(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }

    @Throws(Exception::class)
    override fun configure(httpSecurity: HttpSecurity) {
        httpSecurity
            .csrf()
            .disable()
            .authorizeRequests() //Доступ только для не зарегистрированных пользователей
            .antMatchers("/registration").not()
            .fullyAuthenticated() //Доступ только для пользователей с ролью Администратор
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/hello").hasRole("USER") //Доступ разрешен всем пользователей
            .antMatchers("/", "/resources/**").permitAll() //Все остальные страницы требуют аутентификации
            .anyRequest().authenticated()
            .and() //Настройка для входа в систему
            .formLogin()
            .loginPage("/login") //Перенарпавление на главную страницу после успешного входа
            .defaultSuccessUrl("/")
            .permitAll()
            .and()
            .logout()
            .permitAll()
            .logoutSuccessUrl("/")
    }

    @Autowired
    @Throws(Exception::class)
    protected fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder())
    }
}