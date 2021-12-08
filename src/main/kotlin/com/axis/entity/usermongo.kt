package com.axis.entity



import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.stereotype.Component
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

@Component
@Document(collection = "wallet")
@Validated
class usermongo {

    @Id
    private var id = 0
    @Email
    @NotNull(message = "email is mandatory")
    private var email: String? = null
    @NotNull(message = "upi is mandatory")
    private var upi: String? = null
    // not need at register Time bydefault set to 0 at Backend
    //@Positive
    private var balance = 0

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getUpi(): String? {
        return upi
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun setUpi(upi: String?) {
        this.upi = upi
    }

    fun getBalance(): Int {
        return balance
    }

    fun setBalance(balance: Int) {
        this.balance = balance
    }

    fun usermongo(id: Int, email: String?, upi: String?, balance: Int) {
        this.id = id
        this.email = email
        this.upi = upi
        this.balance = balance
    }


    override fun toString(): String {
        return "usermongo [id=$id, email=$email, upi=$upi, balance=$balance]"
    }
}