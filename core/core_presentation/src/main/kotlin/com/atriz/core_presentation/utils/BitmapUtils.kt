package com.atriz.core_presentation.utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint

object BitmapUtils {

    fun stringToBitmap(text: String?, textSize: Float, textColor: Int): Bitmap? {
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        paint.textSize = textSize
        paint.color = textColor
        paint.textAlign = Paint.Align.LEFT
        val baseline: Float = -paint.ascent()
        val width = paint.measureText(text).toInt()
        val height = (baseline + paint.descent()).toInt()
        val image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(image)
        if (text != null) {
            canvas.drawText(text, 0F, baseline, paint)
        }
        return image
    }
}
