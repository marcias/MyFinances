package com.msc.dev.myfinancesproject.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeContent(
    onAddNewSpendingPressed: () -> Unit,
    onAddNewIncomingPressed: () -> Unit,
    onGoToMyReportsPressed: () -> Unit
) {
    Column {
        Button(onClick = { onAddNewSpendingPressed.invoke() }) {
            Text(text = "Adicionar gasto")
        }

        Button(onClick = { onAddNewSpendingPressed.invoke() }) {
            Text(text = "Adicionar recebimento")
        }

        Button(onClick = { onAddNewSpendingPressed.invoke() }) {
            Text(text = "Ir para relatórios")
        }
    }
}