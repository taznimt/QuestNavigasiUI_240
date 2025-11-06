@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.navigasi.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

// Pastikan ini adalah import R yang benar dari proyek Anda
import com.example.navigasi.R

@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-laki", "Perempuan"),
    OnSubmitBtnClick: (nama: String, alamat: String, jenisKelamin: String) -> Unit // Mengubah OnSubmitBtnClick agar menerima data
) {
    // --- State Management untuk menyimpan data form ---
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var selectedJenisKelamin by remember { mutableStateOf(jenisK.first()) }
    // ----------------------------------------------------

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.home),
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. TextField untuk Nama Lengkap
            OutlinedTextField(
                value = nama, // Menggunakan state 'nama'
                onValueChange = { nama = it }, // Memperbarui state 'nama'
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(width = 250.dp),
                label = { Text(text = "Nama Lengkap") },
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(width = 250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // 2. RadioButton untuk Jenis Kelamin
            Row {
                jenisK.forEach { item ->
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .width(100.dp), // Memberi lebar tetap
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = item == selectedJenisKelamin, // Memeriksa apakah item terpilih
                            onClick = { selectedJenisKelamin = item } // Memperbarui state saat diklik
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(width = 250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // 3. TextField untuk Alamat
            OutlinedTextField(
                value = alamat, // Menggunakan state 'alamat'
                onValueChange = { alamat = it }, // Memperbarui state 'alamat'
                singleLine = true,
                modifier = Modifier
                    .width(width = 250.dp),
                label = { Text(text = "Alamat") },
            )

            Spacer(modifier = Modifier.height(height = 30.dp))

            // 4. Tombol Submit
            Button(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp),
                onClick = {
                    // Meneruskan data yang sudah tersimpan di state saat tombol diklik
                    OnSubmitBtnClick(nama, alamat, selectedJenisKelamin)
                }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}