package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.account.LoginActivity

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // habilidades e preferencias mockadas
        val skills = listOf("Kotlin", "Mobile", "Java")
        val tvSkills = view.findViewById<TextView>(R.id.tv_skills)
        tvSkills.text = skills.joinToString(", ")

        val preferences = listOf("Segurança", "Back-End", "IA")
        val tvPreferences = view.findViewById<TextView>(R.id.tv_preferences)
        tvPreferences.text = preferences.joinToString(", ")

        val button = view.findViewById<Button>(R.id.btn_logout)

        button.setOnClickListener {
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)

        }

        return view
    }
}
