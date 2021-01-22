package stw.jamez.ns.demo.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import stw.jamez.ns.demo.data.RealmStore
import stw.jamez.ns.demo.service.ErrorResponse
import stw.jamez.ns.demo.service.SuccessResponse
import stw.jamez.ns.demo.service.usecase.LoginUseCase
import stw.jamez.ns.demo.ui.login.model.LoginModel
import stw.jamez.ns.demo.util.LoginCallback

class LoginViewModel: ViewModel() {

    val loginModel = MutableLiveData<LoginModel>()

    fun login(param: LoginCallback) {
        println("aaaa${loginModel.value}")
        LoginUseCase(loginModel.value).execute {
            when(it) {
                is SuccessResponse -> {
                    RealmStore.saveUserData(it.value)
                    param.success()
                }
                is ErrorResponse -> {
                    param.fail(it.error)
                }
            }
        }

    }
}