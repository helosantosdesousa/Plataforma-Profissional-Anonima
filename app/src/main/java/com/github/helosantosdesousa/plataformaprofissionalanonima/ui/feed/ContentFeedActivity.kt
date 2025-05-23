package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.feed

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.chat.ChatFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.profile.ProfileFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.support.SupportFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

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

    // navegar no menu
    private fun handleNavigation(itemId: Int): Boolean {
        return when (itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, PostListFragment())
                    addToBackStack("PostListFragment")
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
                    addToBackStack("SupportFragment")
                }
                true
            }

            R.id.navigation_profile -> {
                supportFragmentManager.commit {
                    replace(R.id.fragment_container, ProfileFragment())
                    addToBackStack("ProfileFragment")
                }
                true
            }

            else -> false
        }
    }



}