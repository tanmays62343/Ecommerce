package com.TrX.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.TrX.databinding.ActivityLoginIntroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginIntro : AppCompatActivity() {
    private var binding:ActivityLoginIntroBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginIntroBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val auth:FirebaseAuth = Firebase.auth
        if(auth.currentUser != null){
            Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show()
            redirect("MAIN")
        }

        binding?.getStarted?.setOnClickListener {
            redirect("LOGIN")
        }
    }

    private fun redirect(name:String){
        val intent = when(name){
            "LOGIN" -> Intent(this, LoginActivity::class.java)
            "MAIN" -> Intent(this, MainActivity::class.java)
            else -> throw Exception("No path exists")
        }
        startActivity(intent)
        finish()
    }

}