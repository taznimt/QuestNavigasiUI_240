package com.example.navigasi

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
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
    Scaffold { isiRuang->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,

            modifier= Modifier.padding(paddingValues= isiRuang)){
            FormIsian(
                OnSubmiitBtnClick = {
                    navController.navigate(route = Navigasi.Detail.name)
                }
            )
        }
        composable(route = Navigasi.Detail.name){
            TampilData(
                onBackBtnClick = {cancelAndBackToFormulir(navController)}
            )
        }

    }
}