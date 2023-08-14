package com.TrX

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.TrX.databinding.ActivitySignUpBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {
    private var binding:ActivitySignUpBinding? = null
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        firebaseAuth = Firebase.auth

        binding?.SignupBtn?.setOnClickListener {
            signUpUser()
        }

        binding?.tvLogin?.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun signUpUser(){
        val email:String = binding?.etSemail?.text.toString()
        val password:String = binding?.etSpassword?.text.toString()
        val confirmPassword:String = binding?.etCnfrmPass?.text.toString()

        if(email.isBlank() || password.isBlank() || confirmPassword.isBlank() ){
            Toast.makeText(this, "Fields cannot be Blank", Toast.LENGTH_LONG).show()
            return
        }
        if(password != confirmPassword){
            Toast.makeText(this, "Password do not match", Toast.LENGTH_LONG).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) {
                if(it.isSuccessful){
                    Toast.makeText(this, "User Created", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this, "Error to create User", Toast.LENGTH_LONG).show()
                }
            }

    }

}