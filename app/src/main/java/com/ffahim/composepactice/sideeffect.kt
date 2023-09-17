package com.ffahim.composepactice

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun Counter() {
    // Define a state variable for the count
    val count = remember { mutableStateOf(0) }

    // Use SideEffect to log the current value of count
    SideEffect {
        // Called on every recomposition
        Log.e("fahamin", "Outer Count is ${count.value}")
    }

    Column {
        Button(onClick = { count.value++ }) {
            // Use SideEffect to log the current value of count
            SideEffect {
                // Called on every recomposition
                Log.e("fahamin", "Inner Count is ${count.value}")
            }

            // This recomposition doesn't trigger the outer side effect
            // every time button has been tapped
            Text("Increase Count ${count.value}")
        }
    }
}