package com.example.fablifecounter

import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var healthtextp1 : TextView
    private lateinit var addp1 : Button
    private lateinit var subp1 : Button
    private lateinit var healthtextp2 : TextView
    private lateinit var addp2 : Button
    private lateinit var subp2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        healthtextp1 = findViewById(R.id.healthtextp1)
        addp1 = findViewById(R.id.addp1)
        subp1 = findViewById(R.id.subp1)
        healthtextp2 = findViewById(R.id.healthtextp2)
        addp2 = findViewById(R.id.addp2)
        subp2 = findViewById(R.id.subp2)

        var healthp1 = 40
        var healthp2 = 40

        addp1.setOnClickListener {

            healthp1 += 1

            healthtextp1.text = healthp1.toString()
        }

        subp1.setOnClickListener {

            healthp1 -= 1

            healthtextp1.text = healthp1.toString()
        }

        addp2.setOnClickListener {

            healthp2 += 1

            healthtextp2.text = healthp2.toString()
        }

        subp2.setOnClickListener {

            healthp2 -= 1

            healthtextp2.text = healthp2.toString()
        }

        private fun showImageSelectionDialog() {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            val imageSelectionFragment = ImageSelectionFragment()
            fragmentTransaction.replace(R.id.fragment_container, imageSelectionFragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        val menuButton = findViewById<ImageButton>(R.id.menu)

        menuButton.setOnClickListener {
            val popupMenu = PopupMenu(this, menuButton)
            val inflater = menuInflater
            inflater.inflate(R.menu.change_hero, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { menuItem ->
                val itemId = menuItem.itemId
                if (itemId == R.id.change_hero) {
                    showImageSelectionDialog()
                    return@setOnMenuItemClickListener true
                }

                false
            }

            popupMenu.show()
        }

        /*
        val imageOptions = listOf("Bravo", "Dorinthea", "Katsu", "Rhinar")

        val imageResources = mapOf(
            "Bravo" to  R.drawable.hero_bravo,
            "Dorinthea" to R.drawable.hero_dorinthea,
            "Katsu" to R.drawable.hero_katsu,
            "Rhinar" to R.drawable.hero_rhinar
        )

        menuButton.setOnClickListener {
            val popupMenu = PopupMenu(this,menuButton)

            for (option in imageOptions) {
                popupMenu.menu.add(Menu.NONE, option.hashCode(), Menu.NONE, option)
            }

            popupMenu.setOnMenuItemClickListener { menuItem ->
                val selectedOption = menuItem.title.toString()
                val imageID = imageResources[selectedOption] ?:
                return@setOnMenuItemClickListener false

                val selectedImage = resources.getDrawable(imageID)
                val imageView = findViewById<ImageView>(R.id.backgroundp1)
                imageView.setImageDrawable(selectedImage)

                true
            }
            popupMenu.show()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        */
    }
}