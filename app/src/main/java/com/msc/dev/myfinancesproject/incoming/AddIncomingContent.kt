package com.msc.dev.myfinancesproject.incoming

import androidx.compose.runtime.Composable
import com.msc.dev.commons.Incoming


@Composable
fun AddIncomingContent(
    plannedIncomingList: List<Incoming> = emptyList(),
    onBackButtonPressed: () -> Unit = {},
    onSaveButtonPressed: (value: Long, incoming: Incoming?) -> Unit = {_, _ -> }
) {
}