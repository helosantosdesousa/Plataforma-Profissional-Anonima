package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.matchmaking

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.R

class MatchmakingFragment : Fragment(R.layout.fragment_matchmaking) {

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializa a lista de habilidades
        val skills = listOf("SQL", "Python", "Data Science")
        val tvAboutUser = view.findViewById<TextView>(R.id.tv_about_user)
        tvAboutUser.text = skills.joinToString(", ")

        // Configura o botão "Interested"
        val btnInterested = view.findViewById<Button>(R.id.bt_interested)
        println("segui")
        }

        /*// Configura o botão "Ignore"
        val btnIgnore = view.findViewById<Button>(R.id.bt_ignore)
        btnIgnore.setOnClickListener {
            // Substitui o fragmento atual pelo ForumFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ForumFragment()) // Substitui o fragmento atual pelo ForumFragment
                .addToBackStack(null) // Permite que o usuário volte ao fragmento anterior
                .commit()
        }
    }*/
    }
