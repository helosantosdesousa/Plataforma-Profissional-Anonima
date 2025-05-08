package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.model.Post
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.matchmaking.MatchmakingFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.forum.ForumFragment

class PostListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla o layout para o fragmento
        val rootView = inflater.inflate(R.layout.fragment_posts_list, container, false)

        // Lista de posts
        val posts = arrayListOf(
            Post("Maria"),
            Post("João")
            // Adicione outros posts conforme necessário
        )

        // Encontrar o LinearLayout onde os posts serão adicionados
        val linearPosts: LinearLayout = rootView.findViewById(R.id.linear_posts)

        // Iterar sobre a lista de posts e criar os TextViews dinamicamente
        for (post in posts) {
            // Criar um LinearLayout para o contêiner do post com fundo branco
            val postContainer = LinearLayout(requireContext())
            postContainer.orientation = LinearLayout.VERTICAL
            postContainer.setPadding(12, 12, 12, 12)
            postContainer.setBackgroundColor(resources.getColor(R.color.white))

            // Definir margens para separar os posts
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 0, 0, 12)
            postContainer.layoutParams = params

            // Criar o TextView para o nome
            val nomeTextView = TextView(requireContext())
            nomeTextView.text = "Nome: ${post.description}"
            nomeTextView.textSize = 16f
            nomeTextView.setTypeface(nomeTextView.typeface, android.graphics.Typeface.BOLD)

            // Adicionar os TextViews no layout do post
            postContainer.addView(nomeTextView)

            // Adicionar o layout do post no LinearLayout principal
            linearPosts.addView(postContainer)
        }

        // Acessar os botões do layout
        val btnMatchmaking: Button = rootView.findViewById(R.id.btn_matchmaking)
        val btnForum: Button = rootView.findViewById(R.id.btn_forum)

        // Configurar os listeners dos botões para navegar entre os fragmentos
        btnMatchmaking.setOnClickListener {
            // Navegar para o fragmento de matchmaking
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MatchmakingFragment())
                .addToBackStack(null)
                .commit()
        }

        btnForum.setOnClickListener {
            // Navegar para o fragmento de fórum
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ForumFragment())
                .addToBackStack(null)
                .commit()
        }

        // Retorna a view inflada
        return rootView
    }
}
