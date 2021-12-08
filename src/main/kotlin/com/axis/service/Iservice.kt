package com.axis.service

import com.axis.entity.History
import com.axis.entity.usermongo
import org.springframework.stereotype.Service

@Service
interface Iservice {
    fun addinfo(user: usermongo?): String?
    fun viewAllinfo(): List<usermongo?>?
    fun viewinfoById(id: Int): usermongo?
    fun deleteinfoById(id: Int): String?
    fun updateinfo(id: Int, user: usermongo?): String?
    fun addmoney(email: String?,money: Int): String?
    fun sendmoney(email: String?, money: Int): String?
    fun sendmoneyupi(upi: String?, money: Int): String?
    fun viewallhistory(): List<History?>?
    fun historyfilter(id: String): List<History?>?
}