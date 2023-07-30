package com.ffahim.composepactice

import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@Composable
fun Disposableeffet() {
    val view = LocalView.current

    DisposableEffect(key1 = Unit)
    {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {

            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(WindowInsetsCompat.Type.ime())
            Log.e("fahamin", isKeyboardVisible.toString())

        }
        view.viewTreeObserver.addOnGlobalLayoutListener { listener }
        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener { listener }
        }
    }
}