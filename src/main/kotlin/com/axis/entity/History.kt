package com.axis.entity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.stereotype.Component
import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero

@Component
@Document(collection = "history")

public  class History {

    @Id
    private var _id = 0
    //  public static final String SEQUENCE_NAME = "user_sequence";
    private var sender: String? = null
    private var receiver: String? = null
    //@PositiveOrZero
    private var moneysent = 0
    private var Date_Time: String? = null

    //@DocumentReference
    private var self: selfadded? = null

    fun getId(): Int {
        return _id
    }

    fun setId(d: Int) {
        _id = d.toInt()
    }

     fun getSender(): String? {
        return sender
    }


    fun setSender(sender: String?) {
        this.sender = sender
    }

    fun getReceiver(): String? {
        return receiver
    }

    fun setReceiver(receiver: String?) {
        this.receiver = receiver
    }

    fun getMoneysent(): Int {
        return moneysent
    }

    fun setMoneysent(moneysent: Int) {
        this.moneysent = moneysent
    }

    fun getDate_Time(): String? {
        return Date_Time
    }

    fun setDate_Time(date_Time: String?) {
        Date_Time = date_Time
    }

    fun getSelf(): selfadded? {
        return self
    }

    fun setSelf(self: selfadded?) {
        this.self = self
    }

    override fun toString(): String {
        return ("History [id=" + _id + ", sender=" + sender + ", receiver=" + receiver + ", moneysent=" + moneysent
                + ", Date_Time=" + Date_Time + ", self=" + self + "]")
    }

    fun History(id: Int, sender: String?, receiver: String?, moneysent: Int, date_Time: String?, self: selfadded?) {

        _id = id
        this.sender = sender
        this.receiver = receiver
        this.moneysent = moneysent
        Date_Time = date_Time
        this.self = self
    }

    fun History() {
    }

}