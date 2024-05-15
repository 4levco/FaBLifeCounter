package com.example.fablifecounter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.RecyclerView

class ImageSelectionFragment : DialogFragment {

    private var selectedHeroId: Int? = null

    private val heroImageResource = listOf("Bravo", "Dorinthea", "Katsu", "Rhinar")

    val imageResources = mapOf(
        "Bravo" to  R.drawable.hero_bravo,
        "Dorinthea" to R.drawable.hero_dorinthea,
        "Katsu" to R.drawable.hero_katsu,
        "Rhinar" to R.drawable.hero_rhinar
    )

    var listener: HeroSelectionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.image_selection_dialog, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.hero_recycler_view)
    }

    private fun handleHeroSelection(HeroId: Int) {
        selectedHeroId = HeroId
        listener?.onHeroSelected(HeroImageResources[heroId])
        dismiss()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HeroSelectionListener) {
            listener = context as HeroSelectionListener
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
    }
}