package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.matchmaking

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.R

class MatchmakingFragment : Fragment(R.layout.fragment_matchmaking) {

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // habilidads e bio mockada
        val skills = listOf("SQL", "Python", "Data Science")
        val tvAboutUser = view.findViewById<TextView>(R.id.tv_about_user)
        val bio = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse dolor eros, feugiat id purus quis, malesuada luctus ex. Vivamus molestie leo a ligula semper gravida. Sed consectetur sapien non dolor condimentum gravida. Cras egestas felis a nisl ultricies rutrum at non magna. Vivamus ac facilisis ex. Donec eu eros volutpat."
        val tvBio = view.findViewById<TextView>(R.id.tv_bio_user)

        tvAboutUser.text = skills.joinToString(", ")
        tvBio.text = bio



    }
}
