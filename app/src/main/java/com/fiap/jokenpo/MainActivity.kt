package com.fiap.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playGame: Button = findViewById(R.id.playGame)
        playGame.setOnClickListener{
            val intent = Intent(this, JKPGame::class.java)
            startActivity(intent)
        }
    }
}
