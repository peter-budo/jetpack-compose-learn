package com.peter.compose.layoutscodelab

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.peter.compose.layoutscodelab.ui.LayoutsCodelabTheme

@Preview
@Composable
fun TextWithPAddingToBaselinePreview() {
    LayoutsCodelabTheme {
        Text(text = "Hi there!", Modifier.firstBaselineToTop(32.dp))
    }
}

@Preview
@Composable
fun TextWithNormALPADDINGPREVIEW() {
    LayoutsCodelabTheme {
        Text(text = "Hi there!", Modifier.padding(top = 32.dp))
    }
}

fun Modifier.firstBaselineToTop(firstBaselineToTop: Dp) = Modifier.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    check(placeable[FirstBaseline]  != AlignmentLine.Unspecified)
    val firstBaseline = placeable[FirstBaseline]

    val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
        placeable.placeRelative(0, placeableY)
    }
}

@Preview
@Composable
fun MyOwnColumnPreview(modifier: Modifier = Modifier) {
    LayoutsCodelabTheme {
        Surface(Modifier.padding(8.dp)) {
            MyOwnColumn {
                Text(text = "MyOwnColumn")
                Text(text = "places items")
                Text(text = "vertically.")
                Text("We've done it by hand!")
            }
        }
    }
}

@Composable
fun MyOwnColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) {measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        var yPosition = 0

        layout(constraints.maxWidth, constraints.maxHeight) {
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height
            }
        }
    }
}

