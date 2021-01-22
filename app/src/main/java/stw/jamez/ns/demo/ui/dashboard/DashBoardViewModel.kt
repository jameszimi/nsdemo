package stw.jamez.ns.demo.ui.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import stw.jamez.ns.demo.data.User

class DashBoardViewModel: ViewModel() {
    val customersList = MutableLiveData<User>()

}