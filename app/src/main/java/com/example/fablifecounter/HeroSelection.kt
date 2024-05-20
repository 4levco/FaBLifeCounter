package com.example.fablifecounter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HeroSelection : AppCompatActivity() {
    private val heroOptions = mapOf(
        "Bravo" to  R.drawable.hero_bravo,
        "Dorinthea" to R.drawable.hero_dorinthea,
        "Katsu" to R.drawable.hero_katsu,
        "Rhinar" to R.drawable.hero_rhinar
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.hero_selection)

        val gridLayout: GridLayout = findViewById(R.id.gridLayout)

        heroOptions.forEach{ entry ->
            val heroOption: View = View.inflate(this, R.layout.hero_icon, null)
            val heroIcon: ImageButton = heroOption.findViewById(R.id.heroIcon)
            heroIcon.setImageResource(entry.value)

            gridLayout.addView(heroOption)

            heroIcon.setOnClickListener {
                setContentView(R.layout.selected_hero)

                val selectedHeroLayout: ConstraintLayout = findViewById(R.id.selectedHeroLayout)
                val selectedHero: View = View.inflate(this, R.layout.hero_image, null)
                val heroImage: ImageView = selectedHero.findViewById(R.id.heroImage)
                heroImage.setImageResource(entry.value)

                selectedHeroLayout.addView(selectedHero)

                val selectP1: Button = findViewById(R.id.selectP1)
                val selectP2: Button = findViewById(R.id.selectP2)
                val cancel: Button = findViewById(R.id.cancel)
                val intent = Intent(this, MainActivity::class.java)

                selectP1.setOnClickListener {
                    //val intent1 = Intent(this, MainActivity::class.java)
                    intent.putExtra("newImageInfo1", entry.value)
                    //startActivity(intent1)
                }

                selectP2.setOnClickListener {
                    //val intent2 = Intent(this, MainActivity::class.java)
                    intent.putExtra("newImageInfo2", entry.value)
                    //startActivity(intent2)
                }

                cancel.setOnClickListener {
                    startActivity(intent)
                }
            }
        }

        gridLayout.invalidate()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}