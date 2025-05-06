package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.chat.feed

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.forum.ForumActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.matchmaking.MatchmakingActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.profile.ProfileActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.support.SupportActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.chat.ChatActivity

class ContentFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_content_feed)

        val btnMatchmaking = findViewById<Button>(R.id.bt_matchmaking)

        btnMatchmaking.setOnClickListener {
            val intent = Intent(this, MatchmakingActivity::class.java)
            startActivity(intent)
        }

        val btnForum = findViewById<Button>(R.id.bt_forums)

        btnForum.setOnClickListener {
            val intent = Intent(this, ForumActivity::class.java)
            startActivity(intent)
        }

        val btnChat = findViewById<ImageButton>(R.id.ic_chat)

        btnChat.setOnClickListener {
            val intent = Intent(this, ChatActivity::class.java)
            startActivity(intent)
        }

        val btnSupport = findViewById<ImageButton>(R.id.ic_support)

        btnSupport.setOnClickListener {
            val intent = Intent(this, SupportActivity::class.java)
            startActivity(intent)
        }

        val btnProfile = findViewById<ImageButton>(R.id.ic_profile)

        btnProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

    }
}