package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.model.Post
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.forum.ForumFragment
import com.github.helosantosdesousa.plataformaprofissionalanonima.ui.matchmaking.MatchmakingFragment
import kotlin.random.Random

class PostListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_posts_list, container, false)


        //posts mockados
        val posts = arrayListOf(
            Post("Acabei de sair de um webinar sobre inteligência emocional no ambiente de trabalho. Incrível como pequenas mudanças no comportamento podem melhorar tanto a convivência com colegas! Fico pensando como seria bom se isso fosse ensinado na faculdade… alguém mais participou?", Random.nextInt()),
            Post("Finalizei um curso de UX Design hoje e tô impressionado com o quanto isso muda a forma de pensar soluções. Sempre achei que era só “deixar bonito”, mas é muito mais profundo. Alguém aí fez algo parecido e aplicou no trabalho?", Random.nextInt()),
            Post("Às vezes cansa tentar crescer na carreira sem saber se estou indo pelo caminho certo. Vejo tanta gente fazendo mil cursos, eventos, networking, e me sinto perdido. Só queria dizer que, se você também sente isso, você não está sozinho.", Random.nextInt()),
            Post("Fui num evento sobre liderança para jovens profissionais e saí com a cabeça borbulhando de ideias. Pena que na minha empresa ainda não há espaço pra aplicar isso. Mas sigo tentando me desenvolver. Valeu a pena cada segundo!", Random.nextInt()),
            Post("Hoje me dei conta de como subestimei minhas experiências. Nunca achei que contar minha trajetória de erros e aprendizados fosse ajudar alguém, mas recebi várias mensagens depois de um post antigo. A gente compartilha, desabafa, e no fim inspira.", Random.nextInt()),
            Post("Hoje me dei conta de como subestimei minhas experiências. Nunca achei que contar minha trajetória de erros e aprendizados fosse ajudar alguém, mas recebi várias mensagens depois de um post antigo. A gente compartilha, desabafa, e no fim inspira.", Random.nextInt()),
            Post("Hoje me dei conta de como subestimei minhas experiências. Nunca achei que contar minha trajetória de erros e aprendizados fosse ajudar alguém, mas recebi várias mensagens depois de um post antigo. A gente compartilha, desabafa, e no fim inspira.", Random.nextInt()),
        )

        // adiciona posts ao layout
        val linearPosts: LinearLayout = rootView.findViewById(R.id.linear_posts)

        for (post in posts) {
            val postView = layoutInflater.inflate(R.layout.item_post, linearPosts, false)

            val imageView = postView.findViewById<ImageView>(R.id.post_image)
            val descTextView = postView.findViewById<TextView>(R.id.post_description)

            descTextView.text = post.description

            postView.setOnClickListener {
                Toast.makeText(requireContext(), "Clicou no post ${post.id}", Toast.LENGTH_SHORT).show()
            }

            linearPosts.addView(postView)
        }

        val btnMatchmaking: Button = rootView.findViewById(R.id.btn_matchmaking)
        val btnForum: Button = rootView.findViewById(R.id.btn_forum)

        btnMatchmaking.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MatchmakingFragment())
                .addToBackStack(null)
                .commit()
        }

        btnForum.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, ForumFragment())
                .addToBackStack(null)
                .commit()
        }

        return rootView
    }
}

