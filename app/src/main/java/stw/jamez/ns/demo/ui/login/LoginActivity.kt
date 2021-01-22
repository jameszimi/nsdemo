package stw.jamez.ns.demo.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import io.realm.Realm
import stw.jamez.ns.demo.R
import stw.jamez.ns.demo.base.BaseActivity
import stw.jamez.ns.demo.data.RealmStore
import stw.jamez.ns.demo.databinding.ActivityLoginBinding
import stw.jamez.ns.demo.ui.dashboard.DashBoardActivity
import stw.jamez.ns.demo.ui.login.model.LoginModel
import stw.jamez.ns.demo.util.LoginCallback

class LoginActivity : BaseActivity() {

    private val binding: ActivityLoginBinding by binding(R.layout.activity_login)
    private lateinit var viewModel: LoginViewModel
    private lateinit var realm: Realm



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        RealmStore.getUserData()?.let {
            startDashboard()
        }

        binding.apply {
            loginButton.setOnClickListener {
                when {
                    usernameField.text.trim().isBlank() -> {
                    }

                    passwordField.text.trim().isBlank() -> {
                    }

                    else -> {
                        this@LoginActivity.viewModel.loginModel.value = LoginModel(
                            username = usernameField.text.trim().toString(),
                            password = passwordField.text.trim().toString()
                        )
                        this@LoginActivity.viewModel.login(object : LoginCallback {
                            override fun success() {
                                startDashboard()
                            }

                            override fun fail(errorMsg: String) {
                                Toast.makeText(this@LoginActivity, errorMsg, Toast.LENGTH_SHORT).show()
                            }


                        })
                    }
                }
            }
        }
    }

    private fun startDashboard() {
        startActivity(Intent(this@LoginActivity, DashBoardActivity::class.java))
        this@LoginActivity.finish()
    }
}