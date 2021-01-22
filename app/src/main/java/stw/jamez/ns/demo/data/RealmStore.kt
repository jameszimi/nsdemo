package stw.jamez.ns.demo.data

import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import stw.jamez.ns.demo.ui.login.model.LoginRepo

class RealmStore {
    companion object {

        private val realms: Realm = Realm.getDefaultInstance()
        fun saveUserData(loginRepo: LoginRepo) {
            realms.executeTransaction {realm ->
                val user = realm.createObject<User>(loginRepo.token)
                loginRepo.customers?.let {customers ->
                    customers.forEachIndexed { index, customer ->
                        val mCustomer = realm.createObject<Customer>()
                        mCustomer.id = customer.id
                        mCustomer.name = customer.name
                        user.customers.add(mCustomer)
                    }
                }
            }
        }

        fun getUserData(): User? {
            val userData = realms.where<User>().findFirst()
            return if (userData == null) {
                null
            } else {
                realms.copyFromRealm(userData)
            }

        }

        fun clearData() {
            realms.executeTransaction {
                it.deleteAll()
            }
        }
    }
}