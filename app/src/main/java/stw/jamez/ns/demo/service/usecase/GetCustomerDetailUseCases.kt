package stw.jamez.ns.demo.service.usecase

import io.reactivex.Observable
import stw.jamez.ns.demo.service.SingleUseCase
import stw.jamez.ns.demo.service.api.ServiceApi
import stw.jamez.ns.demo.ui.detail.model.CustomerRepo
import stw.jamez.ns.demo.ui.detail.model.CustomerRqModel

class GetCustomerDetailUseCases(
    private val requestBody: CustomerRqModel?
): SingleUseCase<CustomerRepo>() {
    override fun execute(): Observable<CustomerRepo> {
        return ServiceApi.create().getCustomerDetail(requestBody)
    }
}