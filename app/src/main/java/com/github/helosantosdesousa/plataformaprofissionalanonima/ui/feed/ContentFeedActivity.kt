package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.feed

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.commit
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.account.CreateAccountActivity
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.chat.ChatFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.forum.ForumFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.profile.ProfileFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.support.SupportFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.matchmaking.MatchmakingFragment

class ContentFeedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_feed)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            handleNavigation(item.itemId)
        }

        supportFragmentManager.commit {
            replace(R.id.fragment_container, PostListFragment())
        }

        supportFragmentManager.setFragmentResultListener("chatClosed", this) { _, _ ->
            findViewById<View>(R.id.bottom_navigation)?.visibility = View.VISIBLE
        }



    }

    // Função para lidar com navegação na BottomNavigationView
    private fun handleNavigation(itemId: Int): Boolean {
        return when (itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, PostListFragment()) // Exibe o fragmento principal
                }
                true
            }
            R.id.navigation_chat -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, ChatFragment())
                    addToBackStack(null)
                }
                true
            }
            R.id.navigation_support -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, SupportFragment())
                }
                true
            }
            R.id.navigation_profile -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, ProfileFragment())
                }
                true
            }
            else -> false
        }
    }

    // Função para configurar a navegação por botões
    private fun setupButtonNavigation(buttonId: Int, fragment: Fragment) {
        val button: Button = findViewById(buttonId)
        button.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, fragment)
                addToBackStack(null) // Para permitir voltar ao fragmento anterior
            }
        }
    }

    // Função para exibir os botões
    private fun showMatchmakingAndForumButtons() {
        val btnMatchmaking: Button = findViewById(R.id.btn_matchmaking)
        val btnForum: Button = findViewById(R.id.btn_forum)
        btnMatchmaking.visibility = View.VISIBLE
        btnForum.visibility = View.VISIBLE
    }

    // Função para esconder os botões
    private fun hideMatchmakingAndForumButtons() {
        val btnMatchmaking: Button = findViewById(R.id.btn_matchmaking)
        val btnForum: Button = findViewById(R.id.btn_forum)
        btnMatchmaking.visibility = View.GONE
        btnForum.visibility = View.GONE
    }

    fun showBottomNav(show: Boolean) {
        findViewById<View>(R.id.bottom_navigation).visibility = if (show) View.VISIBLE else View.GONE
    }
}

