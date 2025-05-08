package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.account

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.feed.ContentFeedActivity

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_create_account)

        val button = findViewById<Button>(R.id.bt_login)

        button.setOnClickListener {
            val intent = Intent(this, ContentFeedActivity::class.java)
            startActivity(intent)
        }

    }
}