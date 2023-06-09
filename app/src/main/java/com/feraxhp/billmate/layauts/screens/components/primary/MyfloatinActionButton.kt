package com.feraxhp.billmate.layauts.screens.components.primary

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyFloatingActionButton(onClick: @Composable () -> Unit = {}, text:String = "", withIcon: Boolean = true, icon: @Composable (() -> Unit)? = null) {
    var withIcon_ = withIcon

    var isClicked by remember { mutableStateOf(false) }
    if (isClicked) onClick(); isClicked = false
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.surfaceTint,
        onClick = { isClicked = true },
        modifier = Modifier
            .height(60.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
        ) {
            if (icon != null) {
                withIcon_ = false
                icon()
            }
            if (withIcon_) Icon(Icons.Filled.Add, "", tint = MaterialTheme.colorScheme.inverseOnSurface)
            Text(text = text, fontSize = MaterialTheme.typography.titleMedium.fontSize)
        }
    }
}