package com.example.fablifecounter

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import android.widget.GridView
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TableLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import androidx.constraintlayout.widget.VirtualLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.internal.FlowLayout

class MainActivity : AppCompatActivity() {
    private lateinit var healthtextp1 : TextView
    private lateinit var addp1 : Button
    private lateinit var subp1 : Button
    private lateinit var healthtextp2 : TextView
    private lateinit var addp2 : Button
    private lateinit var subp2 : Button
    private lateinit var menuButton: ImageButton

    val heroOptions = mapOf(
        "Bravo" to  R.drawable.icon_bravo,
        "Dorinthea" to R.drawable.icon_dorinthea,
        "Katsu" to R.drawable.icon_katsu,
        "Rhinar" to R.drawable.icon_rhinar
    )

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
            val itemID = menuItem.itemId
            when (itemID) {
                0 -> {
                    setContentView(R.layout.hero_selection)
                    heroSelection()
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

    private fun heroSelection() {
        val gridLayout: GridLayout = findViewById(R.id.gridLayout)

        heroOptions.forEach{ entry ->
            val heroOption: View = View.inflate(this, R.layout.hero_image, null)

            val heroImage: ImageButton = heroOption.findViewById(R.id.heroImage)
            heroImage.setImageResource(entry.value)

            gridLayout.addView(heroOption)
        }

        gridLayout.invalidate()
    }
}