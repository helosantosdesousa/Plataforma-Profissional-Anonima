package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.account

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.databinding.ActivityMainBinding
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.feed.ContentFeedActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)


        val createAccount = findViewById<TextView>(R.id.tv_create_account)

        createAccount.setOnClickListener {
            val intent = Intent(this, CreateAccountActivity::class.java)
            startActivity(intent)
        }

        val button = findViewById<Button>(R.id.bt_login)

        button.setOnClickListener {
            val intent = Intent(this, ContentFeedActivity::class.java)
            startActivity(intent)
        }

    }
}