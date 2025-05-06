package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.profile

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.account.LoginActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.chat.feed.ContentFeedActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val skills = listOf("Kotlin", "Mobile", "Java")
        val tvSkills = findViewById<TextView>(R.id.tv_skills)
        tvSkills.text = skills.joinToString(", ")


        val preferences = listOf("Segurança", "Back-End", "IA")
        val tvPreferences = findViewById<TextView>(R.id.tv_preferences)
        tvPreferences.text = skills.joinToString(", ")



        val button = findViewById<Button>(R.id.btn_logout)

        button.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

}
