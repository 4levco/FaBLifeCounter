package com.example.fablifecounter

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
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

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val healthtextp1: TextView = findViewById(R.id.healthtextp1)
        val addp1: Button = findViewById(R.id.addp1)
        val subp1: Button = findViewById(R.id.subp1)
        val healthtextp2: TextView = findViewById(R.id.healthtextp2)
        val addp2: Button = findViewById(R.id.addp2)
        val subp2: Button = findViewById(R.id.subp2)
        val menuButton: ImageButton = findViewById(R.id.menu)
        val backgroundP1: ImageView = findViewById(R.id.backgroundp1)
        val backgroundP2: ImageView = findViewById(R.id.backgroundp2)

        var healthp1 = 40
        var healthp2 = 40

        val newImageInfo1 = intent.getIntExtra("newImageInfo1", 0)
        backgroundP1.setImageResource(newImageInfo1)

        val newImageInfo2 = intent.getIntExtra("newImageInfo2", 0)
        backgroundP2.setImageResource(newImageInfo2)

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
            val itemID = menuItem.itemId
            when (itemID) {
                0 -> {
                    startActivity(Intent(this, HeroSelection::class.java))
                    invalidateMenu()
                    true
                }
                1 -> {
                    //to-do options
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
}