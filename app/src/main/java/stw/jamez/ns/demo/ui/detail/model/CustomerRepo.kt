package stw.jamez.ns.demo.ui.detail.model

data class CustomerRepo(
    val status: Int?,
    val data: CustomerData?
) {
    data class CustomerData (
        val id: String?,
        val name: String?,
        val sex: String?,
        val customerGrade: String?,
        val isCustomerPremium: Boolean = false
    )
}