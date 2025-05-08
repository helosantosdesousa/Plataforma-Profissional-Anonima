package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.matchmaking.MatchmakingFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.forum.ForumFragment

class PostListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout para o fragmento
        val rootView = inflater.inflate(R.layout.fragment_posts_list, container, false)

        // Configuração dos botões dentro do fragmento
        val btnMatchmaking: Button = rootView.findViewById(R.id.btn_matchmaking)
        val btnForum: Button = rootView.findViewById(R.id.btn_forum)

        // Ação para o botão Matchmaking
        btnMatchmaking.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MatchmakingFragment())
                .addToBackStack(null) // Para permitir voltar ao fragmento anterior
                .commit()
        }

        // Ação para o botão Forum
        btnForum.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ForumFragment())
                .addToBackStack(null) // Para permitir voltar ao fragmento anterior
                .commit()
        }

        // Retorna a view inflada
        return rootView
    }
}
