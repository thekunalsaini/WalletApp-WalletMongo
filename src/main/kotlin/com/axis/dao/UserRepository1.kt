package com.axis.dao

import com.axis.entity.User
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.CookieValue

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.validation.constraints.NotNull


@FeignClient(url="http://localhost:9600/auth",name = "AUTHO-SERVICE")
interface UserRepository1{

    @GetMapping("/getemail/{email}")
    fun findByEmail(@PathVariable @NotNull email: String?): User?

//    @GetMapping("/cookie")
//    fun cookie1(): String?

    }