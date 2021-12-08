package com.axis.entity



class User {
    private  var id: Int =0


    private var email: String? = null


    private var password: String? = null

    constructor(id: Int, email: String?, password: String?) {
        this.id = id
        this.email = email
        this.password = password

    }

    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getEmail(): String? {
        return email
    }

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String?) {
        this.password = password
    }



    override fun toString(): String {
        return "ManagerAuth(id=$id, email=$email, password=$password)"
    }


}