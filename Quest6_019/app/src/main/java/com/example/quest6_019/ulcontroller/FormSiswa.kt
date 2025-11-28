package com.example.quest6_019.ulcontroller

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.quest6_019.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki - laki", "Perempuan"),
    onSubmitBtnClick: () -> Unit
) {
    var nama by remember { mutableStateOf("") }
    var jenisKelamin by remember { mutableStateOf(jenisK[0]) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = nama,
                singleLine = true,
                modifier = Modifier
                    .padding(top = dimensionResource(R.dimen.padding_medium))
                    .width(250.dp),
                label = { Text(text = stringResource(R.string.nama_lengkap)) },
                onValueChange = { nama = it },
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .width(250.dp),
                thickness = dimensionResource(R.dimen.thickness_divider),
                color = Color.Red
            )

            Row {
                pilihanJK.forEach { item ->
                    Row(modifier = modifier.selectable)
                        selected= txtGender == item,
                            onClick = {
                                txtGender = item
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .width(250.dp),
                thickness = dimensionResource(R.dimen.thickness_divider),
                color = Color.Red
            )

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium)),
                onClick = onSubmitBtnClick
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}
