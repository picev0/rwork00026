package com.example.rworksample00026.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.rworksample00026.R
import com.example.rworksample00026.databinding.ActivityAuthBinding
import com.example.rworksample00026.ui.util.GoogleAuthController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AuthActivity : AppCompatActivity() {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val googleAuthController: GoogleAuthController by lazy {
        GoogleAuthController(this)
    }

    private lateinit var binding : ActivityAuthBinding
    private val viewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signInButton.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                googleAuthController.startSignIn {
                    coroutineScope.launch{
                        val email = it.email
                        val name = it.displayName
                        withContext(Dispatchers.Main){
                            Log.d("[email]", email)
                            Log.d("[name]", name)
                            binding.userIdTextView.text = email
                            binding.userNameTextView.text = name
                            coroutineScope.launch (Dispatchers.Default){
                                viewModel.insert(name, email)
                            }
                        }
                    }
                }
            }
        })

        binding.signOutButton.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                googleAuthController.startSignOut()
                binding.userIdTextView.text = ""
                binding.userNameTextView.text = ""
            }
        })

        binding.nextPageBtn.setOnClickListener (object: View.OnClickListener{
            override fun onClick(v: View?) {
                coroutineScope.launch {
                    withContext(Dispatchers.Default){
                        //viewModel.insert(binding.userNameTextView.text.toString(), binding.userIdTextView.text.toString())
                    }
                }
                val intent = Intent(this@AuthActivity, AttendantActivity::class.java)
                startActivity(intent)
            }
        })

        coroutineScope.launch(Dispatchers.IO) {
            val currentUser = googleAuthController.currentUser
            if (currentUser != null) {
                val email = currentUser.email
                val name = currentUser.displayName
                withContext(Dispatchers.Main){
                    Log.d("[email]", email.toString())
                    Log.d("[name]", name.toString())
                    binding.userIdTextView.text = email
                    binding.userNameTextView.text = name
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        googleAuthController.onActivityResult(requestCode, resultCode, data)
    }
}