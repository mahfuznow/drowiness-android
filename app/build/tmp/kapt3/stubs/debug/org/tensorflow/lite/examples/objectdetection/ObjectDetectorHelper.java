package org.tensorflow.lite.examples.objectdetection;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/ObjectDetectorHelper;", "", "context", "Landroid/content/Context;", "objectDetectorListener", "Lorg/tensorflow/lite/examples/objectdetection/ObjectDetectorHelper$DetectorListener;", "(Landroid/content/Context;Lorg/tensorflow/lite/examples/objectdetection/ObjectDetectorHelper$DetectorListener;)V", "getContext", "()Landroid/content/Context;", "getObjectDetectorListener", "()Lorg/tensorflow/lite/examples/objectdetection/ObjectDetectorHelper$DetectorListener;", "detect", "", "image", "Landroid/graphics/Bitmap;", "imageRotation", "", "DetectorListener", "app_debug"})
public final class ObjectDetectorHelper {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.Nullable()
    private final org.tensorflow.lite.examples.objectdetection.ObjectDetectorHelper.DetectorListener objectDetectorListener = null;
    
    public ObjectDetectorHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    org.tensorflow.lite.examples.objectdetection.ObjectDetectorHelper.DetectorListener objectDetectorListener) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final org.tensorflow.lite.examples.objectdetection.ObjectDetectorHelper.DetectorListener getObjectDetectorListener() {
        return null;
    }
    
    public final void detect(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap image, int imageRotation) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lorg/tensorflow/lite/examples/objectdetection/ObjectDetectorHelper$DetectorListener;", "", "onError", "", "error", "", "onResults", "outputTensorBuffer", "Lorg/tensorflow/lite/support/tensorbuffer/TensorBuffer;", "app_debug"})
    public static abstract interface DetectorListener {
        
        public abstract void onError(@org.jetbrains.annotations.NotNull()
        java.lang.String error);
        
        public abstract void onResults(@org.jetbrains.annotations.NotNull()
        org.tensorflow.lite.support.tensorbuffer.TensorBuffer outputTensorBuffer);
    }
}