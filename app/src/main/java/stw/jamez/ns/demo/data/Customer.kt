package stw.jamez.ns.demo.data

import io.realm.RealmObject
import io.realm.annotations.LinkingObjects

open class Customer: RealmObject() {
    var id: String? = null
    var name: String? = null
}