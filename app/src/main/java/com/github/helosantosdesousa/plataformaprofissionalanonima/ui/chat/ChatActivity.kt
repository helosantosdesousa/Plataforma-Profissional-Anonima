package com.github.helosantosdesousa.plataformaprofissionalanonima.ui.chat

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.helosantosdesousa.plataformaprofissionalanonima.R
import com.github.helosantosdesousa.plataformaprofissionalanonima.model.ChatMessage

class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerChat: RecyclerView
    private lateinit var editMessage: EditText
    private lateinit var btnSend: Button
    private lateinit var chatAdapter: ChatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_chat)

        val tvName = findViewById<TextView>(R.id.tv_name)
        tvName.text = "ByteKing"


        recyclerChat = findViewById(R.id.recycler_chat)
        editMessage = findViewById(R.id.edit_message)
        btnSend = findViewById(R.id.btn_send)

        chatAdapter = ChatAdapter(mutableListOf())
        recyclerChat.adapter = chatAdapter
        recyclerChat.layoutManager = LinearLayoutManager(this).apply {
            stackFromEnd = true // mostra a última mensagem
        }

        // Mensagens mockadas
        chatAdapter.addMessage(ChatMessage("Oi, tudo bem?", isUser = true))
        chatAdapter.addMessage(ChatMessage("Tudo sim e você?", isUser = false))
        chatAdapter.addMessage(ChatMessage("teste?", isUser = true))

        // Envio de nova mensagem
        btnSend.setOnClickListener {
            val msg = editMessage.text.toString()
            if (msg.isNotBlank()) {
                chatAdapter.addMessage(ChatMessage(msg, isUser = true))
                editMessage.text.clear()

                // mocka resposta do "sistema"
                recyclerChat.post {
                    chatAdapter.addMessage(ChatMessage("Recebido: \"$msg\"", isUser = false))
                    recyclerChat.scrollToPosition(chatAdapter.itemCount - 1)
                }
            }
        }
    }
}
