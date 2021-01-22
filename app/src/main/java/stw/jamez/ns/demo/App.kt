package stw.jamez.ns.demo

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration

class App :Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        Realm.setDefaultConfiguration(RealmConfiguration.Builder().allowWritesOnUiThread(true).build())
    }
}