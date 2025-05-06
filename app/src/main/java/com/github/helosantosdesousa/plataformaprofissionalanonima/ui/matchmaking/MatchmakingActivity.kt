package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.matchmaking

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.forum.ForumActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.R

class MatchmakingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_matchmaking)

        val skills = listOf("SQL", "Python", "Data Science")
        val tvAboutUser = findViewById<TextView>(R.id.tv_about_user)
        tvAboutUser.text = skills.joinToString(", ")


        val btnInterested = findViewById<Button>(R.id.bt_interested)

        btnInterested.setOnClickListener {
            val intent = Intent(this, MatchmakingActivity::class.java)
            startActivity(intent)
        }

        val btnIgnore = findViewById<Button>(R.id.bt_ignore)

        btnIgnore.setOnClickListener {
            val intent = Intent(this, ForumActivity::class.java)
            startActivity(intent)
        }


    }
}