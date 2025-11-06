package com.example.navigasi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.navigasi.view.FormIsian
import com.example.navigasi.view.TampilData

enum class Navigasi {
    Formulir,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            // Route Formulir
            composable(Navigasi.Formulir.name) {
                FormIsian(
                    OnSubmitBtnClick = { nama, alamat, jenisKelamin ->
                        // Bisa diteruskan ke TampilData lewat ViewModel / NavArgs
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            // Route Detail
            composable(Navigasi.Detail.name) {
                TampilData(
                    data = listOf(
                        "Nama" to "Tasnim",
                        "Alamat" to "Yogyakarta",
                        "Jenis Kelamin" to "Laki-laki"
                    ),
                    onBackBtnClick = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(navController: NavHostController) {
    navController.popBackStack(route = Navigasi.Formulir.name, inclusive = false)
}
