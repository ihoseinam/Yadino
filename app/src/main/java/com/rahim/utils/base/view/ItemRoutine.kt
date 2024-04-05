package com.rahim.utils.base.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rahim.R
import com.rahim.data.modle.Rotin.Routine
import com.rahim.ui.theme.CornflowerBlueLight
import com.rahim.ui.theme.Porcelain
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import me.saket.swipe.rememberSwipeableActionsState

@Composable
fun ItemRoutine(
    routine: Routine,
    modifier: Modifier = Modifier,
    onChecked: (Routine) -> Unit,
    openDialogEdit: (Routine) -> Unit,
    openDialogDelete: (Routine) -> Unit,
) {
    val delete = SwipeAction(
        icon = painterResource(id = R.drawable.delete),
        background = MaterialTheme.colorScheme.background,
        onSwipe = {
            openDialogDelete(routine)
        }
    )

    val edit = SwipeAction(
        icon = painterResource(id = R.drawable.edit),
        background = MaterialTheme.colorScheme.background,
        onSwipe = {
            openDialogEdit(routine)
        },
    )
    SwipeableActionsBox(
        backgroundUntilSwipeThreshold = MaterialTheme.colorScheme.background,
        startActions = listOf(delete),
        endActions = listOf(edit)
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
            border = if (routine.isChecked) BorderStroke(1.dp, color = Porcelain) else BorderStroke(
                1.dp,
                Brush.verticalGradient(gradientColors)
            ),
            onClick = {
                onChecked(routine.apply {
                    isChecked = !isChecked
                })
            },
            modifier = modifier
                .fillMaxWidth()
                .sizeIn(minHeight = 120.dp)
                .padding(bottom = 12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 12.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.weight(0.3f)
                ) {
                    Checkbox(
                        checked = routine.isChecked,
                        onCheckedChange = {
                            onChecked(routine.apply {
                                isChecked = it
                            })
                        },
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = CornflowerBlueLight,
                            checkedColor = MaterialTheme.colorScheme.background,
                        )
                    )
                    Row(modifier = Modifier.padding(top = 22.dp, start = 12.dp)) {
                        Text(
                            text = routine.timeHours.toString() + " ",
                            style = TextStyle(
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                        Text(
                            text = stringResource(id = R.string.remmeber),
                            style = TextStyle(
                                fontSize = 13.sp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp)
                        .weight(0.7f),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = routine.name,
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    )
                    Row(modifier = Modifier.padding(top = 12.dp)) {
                        if (!routine.explanation.isNullOrEmpty()){
                            Text(
                                textAlign = TextAlign.End,
                                modifier = Modifier
                                    .weight(0.7f)
                                    .padding(bottom = 14.dp, end = 4.dp),
                                text = routine.explanation.toString() + " ",
                                color = MaterialTheme.colorScheme.secondaryContainer
                            )
                            Text(
                                modifier = Modifier.weight(0.3f),
                                text = stringResource(id = R.string.explanation),
                                color = MaterialTheme.colorScheme.secondaryContainer
                            )
                        }
                    }
                }
            }
        }
    }
}
