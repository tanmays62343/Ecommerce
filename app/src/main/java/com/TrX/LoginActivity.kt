package com.TrX

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.TrX.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private var binding:ActivityLoginBinding? = null
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        firebaseAuth = Firebase.auth

        binding?.loginButton?.setOnClickListener {
            loginUser()
        }

        binding?.tvSignup?.setOnClickListener{
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun loginUser(){
        val email:String = binding?.etEmail?.text.toString()
        val password:String = binding?.etPassword?.text.toString()

        if(email.isBlank() || password.isBlank()){
            Toast.makeText(this, "Fields cannot be Blank", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                Toast.makeText(this, "Logged in", Toast.LENGTH_SHORT).show()
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }
        }

    }

}