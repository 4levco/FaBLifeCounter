package com.example.fablifecounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var textp1 : TextView
    private lateinit var addp1 : Button
    private lateinit var subp1 : Button
    private lateinit var textp2 : TextView
    private lateinit var addp2 : Button
    private lateinit var subp2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textp1 = findViewById(R.id.textp1)
        addp1 = findViewById(R.id.addp1)
        subp1 = findViewById(R.id.subp1)
        textp2 = findViewById(R.id.textp2)
        addp2 = findViewById(R.id.addp2)
        subp2 = findViewById(R.id.subp2)

        var healthp1 = 40
        var healthp2 = 40

        addp1.setOnClickListener {

            healthp1 += 1

            textp1.text = "Player 1: " + healthp1.toString()
        }

        subp1.setOnClickListener {

            healthp1 -= 1

            textp1.text = "Player 1: " + healthp1.toString()
        }

        addp2.setOnClickListener {

            healthp2 += 1

            textp2.text = "Player 2: " + healthp2.toString()
        }

        subp2.setOnClickListener {

            healthp2 -= 1

            textp2.text = "Player 2: " + healthp2.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}