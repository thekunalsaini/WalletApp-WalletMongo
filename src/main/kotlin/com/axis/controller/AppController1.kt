package com.axis.controller


import axis.exception.IDNotFoundException
import com.axis.dao.UserRepository1
import com.axis.entity.usermongo
import com.axis.service.Iservice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.lang.Exception
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("/wallet")
class AppController1 {

    @Autowired
    private val service: Iservice? = null

    @GetMapping("/hello")
    fun hello():String{
        return "hello"
    }

    @PostMapping(value = ["/addinfo"])
    fun addProduct(@RequestBody @Valid user: usermongo?) : ResponseEntity<Any>{
//        val jwt = userrepository1?.cookie1()
//        println(jwt)
//        val cookie = Cookie("jwtManager", jwt)
//        cookie.isHttpOnly = true
//        //cookie.secure = true
//
//        response.addCookie(cookie)
//        try{
//            if(jwt == null){
//                return ResponseEntity("no user logged",HttpStatus.UNAUTHORIZED)
//            }
            return ResponseEntity<Any>(service?.addinfo(user), HttpStatus.OK)
//        }catch(e:Exception){
//            return ResponseEntity(e,HttpStatus.UNAUTHORIZED)
//        }

    }

    @PostMapping(value = ["/addmoney/{email}/{money}"])
    fun addmoney(@PathVariable @NotNull email: String?,@PathVariable @NotNull money: Int): ResponseEntity<Any> {
        return ResponseEntity<Any>(service?.addmoney(email,money), HttpStatus.OK)
    }

    @PostMapping(value = ["/sendmoney/{email}/{money}"])
    fun sendmoney(@PathVariable @NotNull email: String?, @PathVariable @NotNull money: Int): ResponseEntity<Any> {
        return ResponseEntity<Any>(service?.sendmoney(email, money), HttpStatus.OK)
    }

    @PostMapping(value = ["/sendmoneyupi/{upi}/{money}"])
    fun sendmoneyupi(@PathVariable @NotNull upi: String?, @PathVariable @NotNull money: Int): ResponseEntity<Any> {
        return ResponseEntity<Any>(service?.sendmoneyupi(upi, money), HttpStatus.OK)
    }
    @GetMapping(value = ["/viewAllinfo"])
    fun viewallproduct(): ResponseEntity<Any> {
        return ResponseEntity<Any>(service?.viewAllinfo(), HttpStatus.OK)
    }
    @GetMapping(value = ["/viewallhistory"])
    fun viewallhistory(): ResponseEntity<Any> {
        return ResponseEntity<Any>(service?.viewallhistory(), HttpStatus.OK)
    }
    @GetMapping(value = ["/viewinfoById/{id}"])
    fun getmovieById(@PathVariable @NotNull id: Int): ResponseEntity<Any> {
        return ResponseEntity<Any>(service?.viewinfoById(id), HttpStatus.OK)
    }
    @GetMapping(value = ["/historyfilter/{id}"])
    fun historyfilter(@PathVariable @NotNull id: String,request:HttpServletRequest): ResponseEntity<Any> {

    //           val token = request.getHeader("Authorization")?.substring(7)
   //        val currentUser = SecurityContextHolder.getContext().authentication.principal as UserLoginRequestImpl
    //            if (!Jwt!!.validateJwtToken(token))
   //                throw GenericException(GenericExceptionEnum.UNAUTHORIZED_ACCESS,"Token is no longer valid")
  //            val currentUsername = Jwtutils!!.getUsernameFromJwtToken(token)

        return ResponseEntity<Any>(service?.historyfilter(id), HttpStatus.OK)
    }
    @DeleteMapping(value = ["/deleteinfoById/{id}"])
    fun deleteinfoById(@PathVariable @NotNull id: Int): ResponseEntity<String> {
        return ResponseEntity<String>(service?.deleteinfoById(id), HttpStatus.OK)
    }

    @PutMapping(value = ["/updateinfo/{id}"])
    fun updateinfo(@PathVariable @NotNull id: Int, @RequestBody @Valid product: usermongo?): ResponseEntity<String> {
        return try {
            ResponseEntity<String>(service?.updateinfo(id, product), HttpStatus.OK)
        } catch (e: Exception) {
            throw IDNotFoundException("Id not present to update id")
        }
    }
}