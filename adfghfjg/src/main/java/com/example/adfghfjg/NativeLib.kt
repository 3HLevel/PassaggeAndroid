package com.example.adfghfjg

class NativeLib {

    /**
     * A native method that is implemented by the 'adfghfjg' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'adfghfjg' library on application startup.
        init {
            System.loadLibrary("adfghfjg")
        }
    }
}