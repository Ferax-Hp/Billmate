package com.feraxhp.billmate.layauts.tabs.components.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyCards(
    modifier: Modifier = Modifier.size(100.dp),
    color: Color = MaterialTheme.colorScheme.primaryContainer,
    components: @Composable () -> Unit = {}
) {
    Card(
        modifier = modifier
            .shadow(
                elevation = 7.dp,
                shape = CardDefaults.shape,
            )
            .background(
                color = color,
                shape = CardDefaults.shape,
            )
    ) {
        components()
    }
}

@Preview
@Composable
fun MyCardsPreview() {
    MyCards() {

    }
}