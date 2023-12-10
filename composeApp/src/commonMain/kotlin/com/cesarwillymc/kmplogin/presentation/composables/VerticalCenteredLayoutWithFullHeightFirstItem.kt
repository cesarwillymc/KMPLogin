package com.cesarwillymc.kmplogin.presentation.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import com.cesarwillymc.kmplogin.util.constants.ONE
import com.cesarwillymc.kmplogin.util.constants.TWO
import com.cesarwillymc.kmplogin.util.constants.ZERO

/**
 * Created by Cesar Canaza on 12/9/23.
 * cesarwilly.mc@gmail.com
 *
 * IOWA, United States.
 *
 * This method fill all the width available after assigning the width of the others composables putting the composables in the middle vertical
 */
@Composable
fun VerticalCenteredLayoutWithFullHeightFirstItem(
    modifier: Modifier,
    content: @Composable () -> Unit
) {
    Layout(modifier = modifier, content = content) { measurables, constraints ->
        // Identify if there are more than one children
        val measurablesMoreThanOne = measurables.size > ONE
        // Identity the metrics like height - width of each children using constraints
        val placeables = if (measurablesMoreThanOne) measurables.subList(ONE, measurables.size)
            .map { measurable ->
                measurable.measure(constraints)
            } else measurables.map { measurable ->
            measurable.measure(constraints)
        }


        layout(constraints.maxWidth, constraints.maxHeight) {
            // the tallest of all composables
            val max =  measurables.maxOf { it.minIntrinsicHeight(constraints.maxHeight) } / TWO
            // the first position in x is the maximum width
            var xPosition = constraints.maxWidth
            for (i in placeables.lastIndex downTo ZERO) {
                // we got the started point of the position of this composable
                xPosition -= placeables[i].width
                // we got calculate the middle of the maximum height
                val currentHeight = max - placeables[i].measuredHeight/2
                // we assign the position in x and y
                placeables[i].placeRelative(y = if(currentHeight< ZERO) ZERO else currentHeight, x = xPosition)
            }
            if (measurablesMoreThanOne){
                // here we said that the first composable use all the space available
                measurables[ZERO].measure(constraints.copy(maxWidth = xPosition, minWidth = ZERO)).let {
                    it.placeRelative(y = max - placeables[ZERO].measuredHeight/2, x = ZERO)
                }
            }
        }
    }
}