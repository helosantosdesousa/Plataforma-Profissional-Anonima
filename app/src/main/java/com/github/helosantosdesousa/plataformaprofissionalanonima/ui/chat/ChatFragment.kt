package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.model.ChatMessage

class ChatFragment : Fragment() {

    private lateinit var recyclerChat: RecyclerView
    private lateinit var editMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById<TextView>(R.id.tv_name)
        tvName.text = "ByteKing"

        recyclerChat = view.findViewById(R.id.recycler_chat)
        editMessage = view.findViewById(R.id.edit_message)
        btnSend = view.findViewById(R.id.btn_send)

        chatAdapter = ChatAdapter(mutableListOf())
        recyclerChat.adapter = chatAdapter
        recyclerChat.layoutManager = LinearLayoutManager(requireContext()).apply {
            stackFromEnd = true
        }

        // Mensagens mockadas
        chatAdapter.addMessage(ChatMessage("Oi, tudo bem?", isUser = true))
        chatAdapter.addMessage(ChatMessage("Tudo sim e você?", isUser = false))
        chatAdapter.addMessage(ChatMessage("Vi que você gosta de Python. Tem interesse em entrar na comunidade de Python Brasil?", isUser = true))

        btnSend.setOnClickListener {
            val msg = editMessage.text.toString()
            if (msg.isNotBlank()) {
                chatAdapter.addMessage(ChatMessage(msg, isUser = true))
                editMessage.text.clear()

                recyclerChat.post {
                    chatAdapter.addMessage(ChatMessage("Recebido: \"$msg\"", isUser = false))
                    recyclerChat.scrollToPosition(chatAdapter.itemCount - 1)
                }
            }
        }

        //some com o menu
        requireActivity().findViewById<View>(R.id.bottom_navigation)?.visibility = View.GONE

        //volta com o menu
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            parentFragmentManager.setFragmentResult("chatClosed", Bundle())
            parentFragmentManager.popBackStack()
        }


    }

}