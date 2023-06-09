package com.feraxhp.billmate.layauts.screens.featuresEditors.components.events

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.feraxhp.billmate.activitys.MainActivity.Companion.appController
import com.feraxhp.billmate.extrendedFuntions.dateFormat
import com.feraxhp.billmate.extrendedFuntions.toMoneyFormat
import com.feraxhp.billmate.extrendedFuntions.noDescrition
import com.feraxhp.billmate.extrendedFuntions.timeFormat
import com.feraxhp.billmate.layauts.tabs.components.categories.CategoriesMessage
import com.feraxhp.billmate.layauts.tabs.components.funds.MyCardFund
import com.feraxhp.billmate.logic_database.database.entities.Events

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoEditable(
    paddingValues: PaddingValues = PaddingValues(0.dp),
    Event: Events = Events(
        name = "ExampleName",
        amount = 111000.0,
        description = "ExampleDescription",
        date = 0L,
        time = "12:30",
        type = false,
        fund_id = 0L,
        category_id = 0L
    )
) {
    val spacerPadding = 24.dp
    val state = rememberTimePickerState()

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .padding(top = 24.dp)
            .padding(horizontal = 24.dp),

    ) {
        val fund = appController.getFundByID(Event.fund_id)
        if (fund != null) {
            MyCardFund(
                accountName = fund.accountName,
                titularName = fund.titularName,
                balance = fund.amount.toMoneyFormat(),
                description = fund.description,
                type = fund.type
            )
        } else {
            MyCardFund()
        }
        Spacer(modifier = Modifier.height(spacerPadding))
        val category = appController.getCategoryByID(Event.category_id)
        if (category != null) {
            CategoriesMessage(
                name = category.name,
                amount = category.amount,
            )
        } else {
            CategoriesMessage()
        }
        Text(
            text = "Amount: ${if (Event.type) "" else "-"}${Event.amount.toMoneyFormat()}",
            modifier = Modifier.padding(vertical = 24.dp),
            maxLines = 1,
            textAlign = TextAlign.Center,
            lineHeight = MaterialTheme.typography.titleLarge.lineHeight,
            fontSize = MaterialTheme.typography.titleLarge.fontSize * 1.5f,
            fontWeight = MaterialTheme.typography.titleLarge.fontWeight,
            fontStyle = MaterialTheme.typography.titleLarge.fontStyle,
        )

        Text(
            text = "${Event.date.dateFormat()} ~ ${Event.time.timeFormat(state.is24hour)}",
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(top = 0.dp)
        )

        var maxlines by remember {mutableStateOf(false)}
        Text(
            text = Event.description.noDescrition(),
            overflow = TextOverflow.Ellipsis,
            maxLines = if (maxlines) Int.MAX_VALUE else 3,
            modifier = Modifier
                .clickable (interactionSource = MutableInteractionSource(), indication = null) {
                    maxlines = !maxlines
                }
        )

    }
}
