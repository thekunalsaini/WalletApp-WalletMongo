package com.axis.dao

import com.axis.entity.History
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Repository
@EnableMongoRepositories
@Repository
interface HistoryRepo : MongoRepository<History?, Int?> {
    //SQL Equivalent : select count(*) from book where author=?
    @Query(value = "{}", count = true)
    fun getBooksCountBySender(): Int?
    @Query("{ 'sender':  {\$regex: ?0 }}")
    fun findfilter(id:String): List<History?>?
    abstract fun save(history: History?)


}