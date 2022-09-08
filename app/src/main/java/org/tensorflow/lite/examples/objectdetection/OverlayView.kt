/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class OverlayView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private var result: DetectionLabels? = null
    private var boxPaint = Paint()
    private var textBackgroundPaint = Paint()
    private var textPaint = Paint()

    init {
        initPaints()
    }

    fun clear() {
        textPaint.reset()
        textBackgroundPaint.reset()
        boxPaint.reset()
        invalidate()
        initPaints()
    }

    private fun initPaints() {
        textBackgroundPaint.color = Color.BLACK
        textBackgroundPaint.style = Paint.Style.FILL
        textBackgroundPaint.textSize = 50f

        textPaint.color = Color.WHITE
        textPaint.style = Paint.Style.FILL
        textPaint.textSize = 50f

        boxPaint.color = ContextCompat.getColor(context!!, R.color.bounding_box_color)
        boxPaint.strokeWidth = 8F
        boxPaint.style = Paint.Style.STROKE
    }

    enum class DetectionLabels {
        YAWN,
        NO_YAWN,
        CLOSED,
        OPEN
    }

    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        val text = if (result == null) " " else result.toString()
        canvas.drawText(text, 100F, 100F, textPaint)
    }

    fun setResults(outputTensorBuffer: TensorBuffer) {
        val data = outputTensorBuffer.floatArray
        data.forEach {
            Log.d("TAG", "setResults: $it")
        }
        val maxValueIndex = data.withIndex().maxByOrNull { it.value }?.index
        Log.d("TAG", "$maxValueIndex")
        Log.d("TAG", "------------------")

        maxValueIndex?.let {
            result = DetectionLabels.values()[it]
        }
    }
}


