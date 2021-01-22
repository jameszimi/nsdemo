package stw.jamez.ns.demo.service.api

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import stw.jamez.ns.demo.service.RetrofitService
import stw.jamez.ns.demo.ui.detail.model.CustomerRepo
import stw.jamez.ns.demo.ui.detail.model.CustomerRqModel
import stw.jamez.ns.demo.ui.login.model.LoginModel
import stw.jamez.ns.demo.ui.login.model.LoginRepo

interface ServiceApi {

    companion object {
        fun create(): ServiceApi {
            return RetrofitService.build().create(ServiceApi::class.java)
        }
    }

    @POST("login")
    fun login (
        @Body body: LoginModel?
    ): Observable<LoginRepo>

    @POST("getCustomerDetail")
    fun getCustomerDetail(
        @Body body: CustomerRqModel?
    ): Observable<CustomerRepo>
}