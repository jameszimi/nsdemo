package stw.jamez.ns.demo.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import stw.jamez.ns.demo.data.RealmStore
import stw.jamez.ns.demo.service.ErrorResponse
import stw.jamez.ns.demo.service.SuccessResponse
import stw.jamez.ns.demo.service.usecase.GetCustomerDetailUseCases
import stw.jamez.ns.demo.ui.detail.model.CustomerRepo
import stw.jamez.ns.demo.ui.detail.model.CustomerRqModel

class DetailViewModel:ViewModel() {

    val customerDetail = MutableLiveData<CustomerRepo.CustomerData>()

    fun getCustomerDetail(customerId: String)  {
        val customerRq =  CustomerRqModel(RealmStore.getUserData()?.token, customerId)
        GetCustomerDetailUseCases(customerRq).execute {
            when(it) {
                is SuccessResponse -> {
                    customerDetail.value = it.value.data
                }

                is ErrorResponse -> {

                }
            }
        }
    }
}