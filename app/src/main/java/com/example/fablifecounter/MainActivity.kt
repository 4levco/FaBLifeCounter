package com.example.fablifecounter

import android.media.Image
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
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
    private lateinit var menuButton: ImageButton

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
        menuButton = findViewById(R.id.menu)

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

        menuButton.setOnClickListener {
            showPopupMenu(it)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)

        val menuOptions = resources.getStringArray(R.array.popup_menu_options)
            for (option in menuOptions) {
                popupMenu.menu.add(option)
            }


        popupMenu.setOnMenuItemClickListener { menuItem ->
            val itemId = menuItem.itemId
            when (itemId) {
                R.id.menu_choose_hero -> {
                    //to-do choose hero
                    true
                }
                R.id.menu_options -> {
                    //to-do options
                    true
                }
                else -> false
            }
        }



        popupMenu.show()

    }
}