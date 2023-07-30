package com.ffahim.composepactice

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

@Composable
fun RememberUpdatedState() {
    var counter = remember { mutableStateOf(0) }
   
    LaunchedEffect(key1 = Unit)
    {
        delay(2000)
        counter.value = 10
    }
    Counter(value = counter.value)
}

@Composable
fun Counter(value :Int)
{
    val state = rememberUpdatedState(newValue = value)

    LaunchedEffect(key1 = Unit)
    {
        delay(5000)
        Log.e("Fahamin",state.value.toString())
    }
    Text(text = value.toString())
}