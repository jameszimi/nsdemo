package stw.jamez.ns.demo.ui.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import stw.jamez.ns.demo.R
import stw.jamez.ns.demo.base.BaseActivity
import stw.jamez.ns.demo.data.Customer
import stw.jamez.ns.demo.data.RealmStore
import stw.jamez.ns.demo.databinding.ActivityDashboardBinding
import stw.jamez.ns.demo.ui.detail.DetailActivity
import stw.jamez.ns.demo.ui.login.LoginActivity

class DashBoardActivity : BaseActivity() {

    private val binding: ActivityDashboardBinding by binding(R.layout.activity_dashboard)
    private lateinit var viewModel: DashBoardViewModel

    interface DashBoardCallback {
        fun customerOnClick(customer: Customer)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DashBoardViewModel::class.java)

        binding.mainToolbar.logoutBtn.apply {
            visibility = View.VISIBLE
            setOnClickListener {
                RealmStore.clearData()
                startActivity(Intent(this@DashBoardActivity, LoginActivity::class.java))
                this@DashBoardActivity.finish()
            }
        }

        val dashBoardCallback = object :DashBoardCallback  {
            override fun customerOnClick(customer: Customer) {
                val intent = Intent(this@DashBoardActivity, DetailActivity::class.java)
                intent.putExtra(DetailActivity.CUSTOMER_ID, customer.id)
                startActivity(intent)
            }

        }

        val dashBoardAdapter = DashBoardAdapter(dashBoardCallback)

        binding.dashboardRv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter  = dashBoardAdapter
        }

        viewModel.apply {
            customersList.observe(this@DashBoardActivity, {
                binding.dashboardRv.apply {
                    dashBoardAdapter.submitList(it.customers)
                }
            })
            customersList.value = RealmStore.getUserData()

        }
    }
}