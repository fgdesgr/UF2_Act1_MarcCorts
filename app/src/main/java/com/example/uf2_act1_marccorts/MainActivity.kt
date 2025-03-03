package com.example.uf2_act1_marccorts

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var player1: MediaPlayer
    private lateinit var player2: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)

        button1.setOnClickListener {
            playSound(R.raw.audio1)
        }

        button2.setOnClickListener {
            playSound(R.raw.audio2)
        }
    }

    private fun playSound(audioResId: Int) {
        val mediaPlayer = MediaPlayer.create(this, audioResId)
        mediaPlayer.start()
        Log.d("DEBUG", "Reproduciendo audio: $audioResId")

        mediaPlayer.setOnCompletionListener {
            it.release()  // Liberar memoria cuando termine el audio
            Log.d("DEBUG", "Audio terminado y liberado: $audioResId")
        }
    }
}
