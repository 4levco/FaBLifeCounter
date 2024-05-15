package com.example.fablifecounter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.Button

class OutlinedButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int = 0
) : Button(context, attrs, defStyleAttr) {

    private val outlinePaint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.STROKE
        strokeWidth = 4f
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = textColors.defaultColor
        textSize = textSize
    }

    private val backgroundPaint = Paint().apply {
        color = backgroundTintList?.defaultColor ?: Color.WHITE
    }

    private val buttonPadding = Rect()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // Draw button background
        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)

        // Draw button outline (with slight padding)
        val outlinePadding = 4f // Adjust padding as needed
        canvas?.drawRect(
            outlinePadding,
            outlinePadding,
            width.toFloat() - outlinePadding,
            height.toFloat() - outlinePadding,
            outlinePaint
        )

        // Draw button text with centered alignment
        val textBounds = Rect()
        textPaint.getTextBounds(text.toString(), 0, text.length, textBounds)
        val textX = (width - textBounds.width()) / 2f
        val textY = (height + textBounds.height()) / 2f
        canvas?.drawText(text.toString(), textX, textY, textPaint)
    }

    override fun onPaddingChanged(left: Int, top: Int, right: Int, bottom: Int) {
        super.onPaddingChanged(left, top, right, bottom)
        buttonPadding.set(paddingLeft, paddingTop, paddingRight, paddingBottom)
    }
}