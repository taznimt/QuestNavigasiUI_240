@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.navigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Import R yang benar dari proyek Anda
import com.example.navigasi.R

// Definisi TampilData menerima data yang sebenarnya
@Composable
fun TampilData(
    data: List<Pair<String, String>>, // Menerima data yang akan ditampilkan
    onBackBtnClick: () -> Unit
) {
    // Data yang diterima dipetakan ke items
    val items = data.map { (labelId, value) ->
        Pair(stringResource(id = labelId.toIntOrNull() ?: 0), value)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(), // Mengisi seluruh layar
        topBar = {
            TopAppBar(
                title = {
                    // Pastikan R.string.tampil ada di resources Anda
                    Text(
                        text = stringResource(id = R.string.tampil),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    // Pastikan R.color.teal_700 ada di resources Anda
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }) { isiRuang ->
        Column(
            modifier = Modifier.padding(paddingValues = isiRuang).fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .padding(all = dimensionResource(id = R.dimen.padding_medium)) // Pastikan R.dimen.padding_medium ada
                    .weight(1f), // Agar kolom ini mengambil sisa ruang
                verticalArrangement = Arrangement.spacedBy(space = dimensionResource(id = R.dimen.padding_small)) // Pastikan R.dimen.padding_small ada
            ) {
                items.forEach { item ->
                    Column {
                        Text(
                            text = item.first.uppercase(),
                            fontSize = 16.sp
                        )
                        Text(
                            text = item.second,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Cursive,
                            fontSize = 22.sp
                        )
                    }
                    HorizontalDivider(thickness = 1.dp, color = Color.Cyan)
                }
            }

            // Tombol "Back" ditempatkan di bagian bawah
            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.height(height = 10.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onBackBtnClick
                ) {
                    // Mengganti string "Back" hardcoded menjadi string resource
                    Text(text = stringResource(id = R.string.kembali)) // Asumsi R.string.kembali ada atau Anda bisa menggunakan "Back"
                }
            }
        }
    }
}