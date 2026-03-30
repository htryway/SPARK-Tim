package com.example.sparktim

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var messageText: TextView
    lateinit var inputTime: EditText
    lateinit var sendBtn: Button
    lateinit var resetBtn: Button
    lateinit var scrollView: ScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        messageText = findViewById(R.id.messageText)
        inputTime = findViewById(R.id.inputTime)
        sendBtn = findViewById(R.id.sendBtn)
        resetBtn = findViewById(R.id.resetBtn)
        scrollView = findViewById(R.id.scrollView)

        loadChat()

        sendBtn.setOnClickListener {
            val time = inputTime.text.toString().trim().lowercase()

            if (time.isEmpty()) return@setOnClickListener

            val response = when (time) {
                "morning" -> "Send a Good morning message to a family member ☀️"
                "mid-morning" -> "Send a quick Thank You message to a colleague 🙌"
                "afternoon" -> "Share a funny meme with a friend 😂"
                "snack time" -> "Send a 'thinking of you' message 💭"
                "dinner" -> "Call a friend for a quick catch-up 📞"
                "night" -> "Leave a thoughtful comment on a post 🌙"
                else -> "⚠️ Please enter a valid time (Morning, Afternoon, Dinner, Night)"
            }

            // Add messages like WhatsApp
            messageText.append("\n\nYou: $time")
            messageText.append("\nBot: $response")

            saveChat()

            inputTime.text.clear()

            // Auto scroll to bottom
            scrollView.post {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN)
            }
        }

        resetBtn.setOnClickListener {
            messageText.text = "Bot: Hi Cora! What time of day is it? 😊"
            saveChat()
            inputTime.text.clear()
        }
    }

    // 💾 Save chat
    private fun saveChat() {
        val prefs = getSharedPreferences("chat", Context.MODE_PRIVATE)
        prefs.edit().putString("chat_history", messageText.text.toString()).apply()
    }

    // 📂 Load chat
    private fun loadChat() {
        val prefs = getSharedPreferences("chat", Context.MODE_PRIVATE)
        val saved = prefs.getString("chat_history", null)

        if (saved != null) {
            messageText.text = saved
        } else {
            messageText.text = "Bot: Hi Cora! What time of day is it? 😊"
        }
    }
}
