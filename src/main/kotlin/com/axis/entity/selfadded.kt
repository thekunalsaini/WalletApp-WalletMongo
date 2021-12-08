package com.axis.entity

import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.stereotype.Component

@Component

@Document(collection = "selfadded")
 class selfadded {
    private var moneyadded = 0
    private var selfadd = "No"
    fun getMoneyadded(): Int {
        return moneyadded
    }

    fun selfadded(){

    }

    fun setMoneyadded(moneyadded: Int) {
        this.moneyadded = moneyadded
    }

    fun getSelfadd(): String? {
        return selfadd
    }

    fun setSelfadd(selfadd: String) {
        this.selfadd = selfadd
    }

    override fun toString(): String {
        return "selfadded [moneyadded=$moneyadded, selfadd=$selfadd]"
    }

    fun selfadded(moneyadded: Int, selfadd: String) {
        this.moneyadded = moneyadded
        this.selfadd = selfadd
    }

}