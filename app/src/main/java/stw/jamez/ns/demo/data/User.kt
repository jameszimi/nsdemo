package stw.jamez.ns.demo.data

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class User (
    @PrimaryKey var token: String? = null,
    var customers: RealmList<Customer> = RealmList()
): RealmObject()