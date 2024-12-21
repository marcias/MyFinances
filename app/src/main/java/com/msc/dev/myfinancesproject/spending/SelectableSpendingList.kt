package com.msc.dev.myfinancesproject.spending

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.msc.dev.commons.Spending

@Composable
fun SelectableListDialog(
    items: List<Spending>,
    onItemSelected: (Spending) -> Unit,
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        onDismissRequest = { onDismissRequest() },
        title = { Text(text = "Select an Item") },
        text = {
            LazyColumn {
                items(items.size) { index ->
                    val item = items[index]
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .clickable { onItemSelected(item) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = item.description, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        },
        confirmButton = {}
    )
}
