package com.axis.service



import com.axis.dao.HistoryRepo
import com.axis.entity.History
import com.axis.dao.UserRepositorymongo
import java.time.*
import com.axis.dao.UserRepository1
import com.axis.entity.User
import com.axis.entity.selfadded
import com.axis.entity.usermongo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.sql.Date
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.Calendar


@Service
class service : Iservice {

    @Autowired
    var productDao: UserRepositorymongo? = null
    @Autowired
    var repo: UserRepository1? = null

    @Autowired
    var history: History? = null

    @Autowired
    var selfclass: selfadded? = null

    @Autowired
    var hisrepo: HistoryRepo? = null
    override fun addinfo(product: usermongo?): String? {
        // TODO Auto-generated method stub
        if(repo?.findByEmail(product?.getEmail())!=null){
        val user: User = repo?.findByEmail(product?.getEmail())!!
            //check of duplicacy of UPI
            if(productDao?.findByupi(product?.getUpi())!=null)
            {
                return "upi already present!!!"
            }
        var id = user.getId()
        product?.setId(id)
        product?.setBalance(0)
        productDao?.save(product)
        return "user added"}
        else{
            return "such email of user not exists"
        }
    }

    override fun viewAllinfo(): List<usermongo?>? {
        // TODO Auto-generated method stub
        return productDao?.findAll()
    }
    override fun viewallhistory(): List<History?>? {
        return hisrepo?.findAll()
    }

    override fun historyfilter(id: String): List<History?>? {
        return hisrepo?.findfilter(id)
    }

    @Throws(NoSuchElementException::class)
    override fun viewinfoById(id: Int): usermongo? {
        // TODO Auto-generated method stub
        return productDao?.findById(id)?.get()
    }

    override fun deleteinfoById(id: Int): String? {
        // TODO Auto-generated method stub
        productDao?.deleteById(id)
        return "user deleted"
    }

    @Throws(NoSuchElementException::class)
    override fun updateinfo(id: Int, product: usermongo?): String? {
        // TODO Auto-generated method stub
        try {
            if (product != null) {
                productDao?.findById(product.getId())?.get()
            }
            productDao?.save(product)
        } catch (e: NoSuchElementException) {
            return "no product available"
        }
        return "updated"
    }

    override fun addmoney(email: String?,money: Int): String? {
        println(repo?.findByEmail(email))
        return if (repo?.findByEmail(email) != null) {
            //call to add money gateway
            //if(paytm)
            //println(repo?.findByEmail(email))
            val user: User = repo?.findByEmail(email)!!

            //mongo
            val Uid: Optional<usermongo?>? = productDao?.findById(user.getId())
            val uget: usermongo? = Uid?.get()
            uget?.setEmail(email)
            val balancelive: Int? = uget?.getBalance()
            if (balancelive != null) {
                uget?.setBalance(balancelive+money)
            }
            productDao?.save(uget)
            //history
//            val formatter = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")
//            val date = Date(0, 0, 0)

            history?.setDate_Time(Calendar.getInstance().time.toString())
            selfclass?.setMoneyadded(money)
            selfclass?.setSelfadd("YES")
            //println(s)
            history?.setSelf(selfclass)
            hisrepo?.save(history)
            "money added"
        } else {
            "account not exist!!!"
        }
    }

    override fun sendmoney(email: String?, money: Int): String? {
        //sender jwt se nikal jayega front end pe vha ese send right hmmm!!!
        val sender = "kunalsaini8950@gmail.com"
        val user = productDao?.findByEmai(email)!!

        val available = user.getBalance()
        if (money <= 0 && money >= available) {
            return "Please give valid value"
        }
        else{
        var listl: List<usermongo?>? = productDao?.getinfoByEmail(email)
        //check
            listl = productDao?.getinfoByEmail(sender)
        if (listl != null) {
            for (lo in listl) {
                val check: Int? = lo?.getBalance()
                if (money > check!!) return "Less money present. Please add more :)"
            }
        }
        //check
            listl = productDao?.getinfoByEmail(email)
        if (listl != null) {
            for (lo in listl) {
                val add: Int? = lo?.getBalance()
                if (lo != null) {
                    if (add != null) {
                        lo.setBalance(add + money)
                    }
                }
                productDao?.save(lo)
            }
        }
        println("Money Succcesfully sent by$sender")
            listl = productDao?.getinfoByEmail(sender)
        val set = 0
        if (listl != null) {
            for (lo in listl) {
                val sub: Int? = lo?.getBalance()
                if (lo != null) {
                    if (sub != null) {
                        lo.setBalance(sub - money)
                    }
                }
                productDao?.save(lo)
            }
        }
        //history updation
           // val history = History()
        history?.setId(1)
//        val localDateTime = LocalDateTime.parse("2018-12-14T09:55:00")
//        val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
//        val output = formatter.format(localDateTime)
        history?.setDate_Time(Calendar.getInstance().time.toString())
        history?.setMoneysent(money)
        history?.setReceiver(email)
        history?.setSender(sender)
            selfclass?.setMoneyadded(0)
            selfclass?.setSelfadd("NO")
        history?.setSelf(selfclass)
        val count: Int? = hisrepo?.getBooksCountBySender()
            println(hisrepo?.getBooksCountBySender())
        if (count != null) {
            history?.setId(count + 1)
        }
        println(history)
            hisrepo?.save(history)
        return "Money Succcesfully sent "
    }
    }
    git init
    git add README.md
    git commit -m "first commit"
    git branch -M main
    git remote add origin https://github.com/thekunalsaini/WalletApp-WalletMongo.git
    git push -u origin main
    override fun sendmoneyupi(upi: String?, money: Int): String? {
        //basically we are giving receiver's email or upi's here
        val sender = "abc@paytm"
        val user = productDao?.findByupi(upi)!!

        val available = user.getBalance()
        if (money <= 0 && money >= available) {
            return "Please give valid value"
        }
        else{
            var listl: List<usermongo?>? = productDao?.getinfoByupi(upi)
            //check
            listl = productDao?.getinfoByupi(sender)
            if (listl != null) {
                for (lo in listl) {
                    val check: Int? = lo?.getBalance()
                    if (money > check!!) return "Less money present. Please add more :)"
                }
            }
            //check
            listl = productDao?.getinfoByupi(upi)
            if (listl != null) {
                for (lo in listl) {
                    val add: Int? = lo?.getBalance()
                    if (lo != null) {
                        if (add != null) {
                            lo.setBalance(add + money)
                        }
                    }
                    productDao?.save(lo)
                }
            }
            println("Money Succcesfully sent by$sender")
            listl = productDao?.getinfoByupi(sender)
            val set = 0
            if (listl != null) {
                for (lo in listl) {
                    val sub: Int? = lo?.getBalance()
                    if (lo != null) {
                        if (sub != null) {
                            lo.setBalance(sub - money)
                        }
                    }
                    productDao?.save(lo)
                }
            }
            //history updation
            // val history = History()
            history?.setId(1)
//            val localDateTime = LocalDateTime.parse("2018-12-14T09:55:00")
//            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
//            val output = formatter.format(localDateTime)
            history?.setDate_Time(Calendar.getInstance().time.toString())
            history?.setMoneysent(money)
            history?.setReceiver(upi)
            history?.setSender(sender)
            selfclass?.setMoneyadded(0)
            selfclass?.setSelfadd("NO")
            history?.setSelf(selfclass)
            val count: Int? = hisrepo?.getBooksCountBySender()
            println(hisrepo?.getBooksCountBySender())
            if (count != null) {
                history?.setId(count + 1)
            }
            println(history)
            hisrepo?.save(history)
            return "Money Succcesfully sent "
        }
    }
}