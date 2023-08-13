package com.TrX

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.TrX.databinding.ActivityLoginIntroBinding

class LoginIntro : AppCompatActivity() {
    private var binding:ActivityLoginIntroBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginIntroBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.Sbutton?.setOnClickListener {

        }

    }
}