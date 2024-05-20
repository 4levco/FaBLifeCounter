package com.example.fablifecounter

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
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

    private var selectedHero1: Int? = null
    private var selectedHero2: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.hero_selection)

        val gridLayout: GridLayout = findViewById(R.id.gridLayout)

        heroOptions.forEach{ entry ->
            val heroOption: View = View.inflate(this, R.layout.hero_icon, null)
            val heroIcon: ImageButton = heroOption.findViewById(R.id.heroIcon)
            val cancel: Button = findViewById(R.id.cancel)
            val intent = Intent(this, MainActivity::class.java)
            heroIcon.setImageResource(entry.value)

            gridLayout.addView(heroOption)

            fun showPopupMenu(view: View) {
                val popupMenu = PopupMenu(this, view)
                val inflater = popupMenu.menuInflater
                inflater.inflate(R.menu.hero_popup, popupMenu.menu)

                popupMenu.setOnMenuItemClickListener { item ->
                    val selectedItem = item.itemId
                    when (selectedItem) {
                        R.id.selectPlayer1 -> {
                            selectedHero1 = entry.value
                            intent.putExtra("newImageInfo1", selectedHero1)
                            if (selectedHero2 != null) {
                                intent.putExtra("newImageInfo2", selectedHero2)
                            }
                            Toast.makeText(this, "Selected for Player 1", Toast.LENGTH_SHORT).show()
                        }

                        R.id.selectPlayer2 -> {
                            selectedHero2 = entry.value
                            intent.putExtra("newImageInfo2", selectedHero2)
                            if (selectedHero1 != null) {
                                intent.putExtra("newImageInfo1", selectedHero1)
                            }
                            Toast.makeText(this, "Selected for Player 2", Toast.LENGTH_SHORT).show()
                        }
                    }

                    false
                }

                popupMenu.show()
            }

            heroIcon.setOnClickListener {
                showPopupMenu(it)
            }

            cancel.setOnClickListener {
                //startActivity(intent)
                if (selectedHero1 != null) {
                    intent.putExtra("newImageInfo1", selectedHero1)
                }
                if (selectedHero2 != null) {
                    intent.putExtra("newImageInfo2", selectedHero2)
                }
                startActivity(intent)
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}