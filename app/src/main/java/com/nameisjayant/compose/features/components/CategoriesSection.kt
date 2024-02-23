package com.nameisjayant.compose.features.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nameisjayant.compose.R
import com.nameisjayant.compose.ui.theme.BorderColor
import com.nameisjayant.compose.ui.theme.GradientColor

@Composable
fun CategorySection(
    modifier: Modifier = Modifier,
    selectedSection: Int,
    onValueChange: (Int) -> Unit
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(vertical = 24.dp)
    ) {
        items(categoriesSectionList, key = { it.id }) {
            CategorySectionRow(
                selected = it.id == selectedSection,
                index = it.id,
                data = it,
                onValueChange = onValueChange
            )
        }
        item {
            AddingSoonSectionRow()
        }
    }
}

@Composable
fun AddingSoonSectionRow(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(GradientColor, CircleShape)
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            AppIconComponent(icon = R.drawable.stars)
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = stringResource(R.string.adding_soon),
                style = MaterialTheme.typography.labelMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.W400
                )
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            AppIconComponent(icon = R.drawable.f1)
            Text(
                text = stringResource(R.string.formula_1),
                style = MaterialTheme.typography.labelMedium.copy(
                    color = Color.White,
                    fontWeight = FontWeight.W400
                )
            )
        }
    }
}

@Composable
fun CategorySectionRow(
    modifier: Modifier = Modifier,
    selected: Boolean,
    index: Int,
    data: CategoriesSection,
    onValueChange: (Int) -> Unit
) {

    Button(
        onClick = { onValueChange(index) },
        modifier = modifier.padding(end = 16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (selected) Color.White else Color.Black
        ),
        shape = CircleShape,
        border = BorderStroke(
            width = 1.dp,
            color = BorderColor,
        )
    ) {
        AppIconComponent(
            icon = data.icon,
            tint = if (index == 1 && selected) Color.Black else Color.Unspecified
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = stringResource(id = data.title),
            style = MaterialTheme.typography.labelLarge.copy(
                fontWeight = FontWeight.W500,
                color = if (selected) Color.Black else Color.White
            )
        )
    }

}

data class CategoriesSection(
    val id: Int,
    @DrawableRes val icon: Int,
    @StringRes val title: Int
)

val categoriesSectionList = listOf(
    CategoriesSection(
        0,
        R.drawable.football,
        R.string.football
    ),
    CategoriesSection(
        1,
        R.drawable.cricket,
        R.string.cricket
    ),

    )