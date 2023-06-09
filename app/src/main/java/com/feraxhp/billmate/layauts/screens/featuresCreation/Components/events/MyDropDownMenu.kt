package com.feraxhp.billmate.layauts.screens.featuresCreation.Components.events

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu(
    modifier: Modifier = Modifier,
    label: String,
    expanded: Boolean,
    setExpanded: (Boolean) -> Unit,
    options: List<String>,
    omitOption: String? = null,
    optionColors: List<Color> = listOf(MaterialTheme.colorScheme.secondaryContainer),
    colorsSelector: List<Int> = List(options.size){0},
    selectedOptionText: String,
    setSelectedOptionText: (String) -> Unit
) {
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { setExpanded(!expanded) },
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onSurface,
                    shape = MaterialTheme.shapes.small
                )
                .clickable { setExpanded(!expanded) }
                .menuAnchor(),
            readOnly = true,
            value = selectedOptionText,
            onValueChange = {},
            label = {
                Text(
                    label
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(
                    expanded = expanded
                )
            },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                focusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                unfocusedContainerColor = MaterialTheme.colorScheme.secondaryContainer,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary.copy(
                    alpha = 0f
                ),
                unfocusedIndicatorColor = MaterialTheme.colorScheme.primary.copy(
                    alpha = 0f
                ),
            ),
            shape = MaterialTheme.shapes.small,
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { setExpanded(false) },
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.secondaryContainer
                )
        ) {
            options.forEach { selectionOption ->
                if (omitOption == selectionOption) return@forEach
                if (selectionOption != options.first()) Divider()
                DropdownMenuItem(
                    colors = MenuDefaults.itemColors(
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer
                    ),
                    text = { Text(selectionOption) },
                    onClick = {
                        setSelectedOptionText(selectionOption)
                        setExpanded(!expanded)
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    modifier = Modifier
                        .background(
                            color = optionColors[colorsSelector[options.indexOf(selectionOption)]],
                        )
                )

            }
        }
    }
}

@Preview
@Composable
fun MyDropDownMenuPreview() {
    MyDropDownMenu(
        label = "Label",
        expanded = false,
        setExpanded = {},
        options = listOf("Option 1", "Option 2"),
        selectedOptionText = "Option 1",
        setSelectedOptionText = {}
    )
}
