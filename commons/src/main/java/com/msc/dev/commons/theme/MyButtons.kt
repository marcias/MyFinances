package com.msc.dev.commons.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PrimaryButton(text: String, isEnabled: Boolean = false, onClick: () -> Unit) {
    MyAppButton(
        text = text,
        modifier = Modifier.background(color = Color.Blue),
        isEnabled = isEnabled
    ) { onClick.invoke() }
}

@Composable
fun SecondaryButton(text: String, isEnabled: Boolean = false, onClick: () -> Unit) {
    MyAppButton(
        text = text,
        modifier = Modifier.background(color = Color.Blue),
        isEnabled = isEnabled
    ) { onClick.invoke() }
}

@Composable
fun TransparentButton(text: String, isEnabled: Boolean = false, onClick: () -> Unit) {
    MyAppButton(
        text = text,
        modifier = Modifier.background(color = Color.Transparent),
        isEnabled = isEnabled
    ) { onClick.invoke() }
}

@Composable
fun MyAppButton(text: String, modifier: Modifier, isEnabled: Boolean, onClick: () -> Unit) {
    Button(modifier = modifier.fillMaxWidth(), enabled = isEnabled, onClick = onClick) {
        Text(text = text, style = TextStyle(fontWeight = FontWeight.Medium))
    }
}

@Preview
@Composable
fun PrimaryButtonPreview() {

}

@Preview
@Composable
fun SecondaryButtonPreview() {

}