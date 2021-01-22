package stw.jamez.ns.demo.ui.login.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginRepo(
    val status: Int?,
    val token: String?,
    val customers: List<Customer>?
): Parcelable {
    @Parcelize
    data class Customer(
        val id: String?,
        val name: String?
    ):Parcelable
}