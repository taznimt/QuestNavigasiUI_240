package com.example.navigasi

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import java.lang.reflect.Modifier

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavController = rememberNavController(),
    modifier: Modifier
){

}