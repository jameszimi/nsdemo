package stw.jamez.ns.demo.service.usecase

import io.reactivex.Observable
import stw.jamez.ns.demo.service.SingleUseCase
import stw.jamez.ns.demo.service.api.ServiceApi
import stw.jamez.ns.demo.ui.login.model.LoginModel
import stw.jamez.ns.demo.ui.login.model.LoginRepo

class LoginUseCase (
    private val loginBody: LoginModel?
): SingleUseCase<LoginRepo>() {
    override fun execute(): Observable<LoginRepo> {
        return ServiceApi.create().login(loginBody)
    }

}