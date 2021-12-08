package com.axis.dao

import com.axis.entity.usermongo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Repository
@EnableMongoRepositories
@Repository
interface UserRepositorymongo : MongoRepository<usermongo?, Int?> {
    @Query("{id :?0}")
    fun  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
            getinfoById(id: Int?): List<usermongo?>?

    @Query("{email :?0}")
    fun  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
            getinfoByEmail(email: String?): List<usermongo?>? //@Query("{ name : { $regex : ?0 } }")
    @Query("{upi :?0}")
    fun  //SQL Equivalent : SELECT * FROM BOOK WHERE ID=?
            getinfoByupi(upi: String?): List<usermongo?>?
    @Query("{email: ?0}")
    fun findByEmai(email: String?): usermongo?
    @Query("{upi: ?0}")
    fun findByupi(upi: String?): usermongo?
    abstract fun save(product: usermongo?)

    //abstract fun save(product: usermongo?)
    //List<usermongo> getmovieBynameRegEx(String name);
}