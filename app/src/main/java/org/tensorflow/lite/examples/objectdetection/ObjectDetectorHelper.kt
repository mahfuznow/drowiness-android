/*
 * Copyright 2022 The TensorFlow Authors. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *             http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.tensorflow.lite.examples.objectdetection

import android.content.Context
import android.graphics.Bitmap
import org.tensorflow.lite.DataType
import org.tensorflow.lite.examples.objectdetection.ml.Drowiness
import org.tensorflow.lite.support.image.ImageProcessor
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.image.ops.ResizeOp
import org.tensorflow.lite.support.image.ops.ResizeOp.ResizeMethod
import org.tensorflow.lite.support.image.ops.Rot90Op
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer


class ObjectDetectorHelper(
    val context: Context,
    val objectDetectorListener: DetectorListener?
) {
    fun detect(image: Bitmap, imageRotation: Int) {
        val imageProcessor: ImageProcessor = ImageProcessor.Builder()
            .add(ResizeOp(145, 145, ResizeMethod.NEAREST_NEIGHBOR))
            .add(Rot90Op(-imageRotation / 90))
            .build()
        val tensorImage = TensorImage(DataType.FLOAT32)
        tensorImage.load(image)
        val resizedTensorImage = imageProcessor.process(tensorImage)
        val resizedBitmap = resizedTensorImage.bitmap
        val model = Drowiness.newInstance(context)
        val outputs = model.process(resizedTensorImage.tensorBuffer)
        val outputFeature0 = outputs.outputFeature0AsTensorBuffer

        model.close()

        objectDetectorListener?.onResults(outputFeature0)
    }

    interface DetectorListener {
        fun onError(error: String)
        fun onResults(outputTensorBuffer: TensorBuffer)
    }
}
