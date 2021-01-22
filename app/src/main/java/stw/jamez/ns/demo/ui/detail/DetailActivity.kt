package stw.jamez.ns.demo.ui.detail

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import stw.jamez.ns.demo.R
import stw.jamez.ns.demo.base.BaseActivity
import stw.jamez.ns.demo.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity() {

    private val binding: ActivityDetailBinding by binding(R.layout.activity_detail)
    private lateinit var viewModel: DetailViewModel

    companion object {
        const val CUSTOMER_ID = "CUSTOMER_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.apply {
            customerDetail.observe(this@DetailActivity,   {
                binding.apply {
                    nameLayout.apply {
                        title = getString(R.string.title_name)
                        value = it.name
                    }
                    genderLayout.apply {
                        title = getString(R.string.title_gender)
                        value = it.sex
                    }
                    gradeLayout.apply {
                        title = getString(R.string.title_grade)
                        value = it.customerGrade
                    }
                    premiumStatus.apply {
                        title = getString(R.string.title_premium)
                        value = if (it.isCustomerPremium) "YES" else "NO"
                    }
                }

                binding.mainToolbar.apply {
                    toolbarTitle = it.name
                    toolbar.apply {
                        setNavigationIcon(R.drawable.ic_detail_back)
                        setNavigationOnClickListener {
                            this@DetailActivity.onBackPressed()
                        }
                    }
                }

            })

            intent.getStringExtra(CUSTOMER_ID)?.let {
                getCustomerDetail(it)
            } ?: kotlin.run {
                this@DetailActivity.finish()
                Toast.makeText(this@DetailActivity, "error try again later", Toast
                    .LENGTH_SHORT).show()
            }
        }
    }


}