import android.annotation.SuppressLint
import android.widget.ToggleButton
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    onClick: () -> Unit,
    text: String = "Button",
    modifier: Modifier = Modifier,
    buttonIcon: ImageVector = Icons.Outlined.Build,
    ColorBackgroud: Color = MaterialTheme.colorScheme.primary,
    ShapeBackground: Shape = MaterialTheme.shapes.medium
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            /*.padding(0.dp)*/
            .clickable { onClick() }
    ) {
        Box(
            contentAlignment = Alignment.Center
        ){
            Text(text = "",
                modifier = Modifier
                    .padding(top = 15.dp)
                    .size(width = 50.dp, height = 25.dp)
                    .background(color = ColorBackgroud.copy(alpha = .3f), shape = ShapeBackground,)
            )
            Icon(
                imageVector = buttonIcon,
                contentDescription = text,
                modifier = Modifier
                    .padding(top = 15.dp)
                    .size(25.dp)
                    .padding(4.dp)
            )
        }
        Text(
            text = text,
            textAlign = TextAlign.Center,
            maxLines = 1,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier/*.clickable() { onClick() }*/
                .padding(bottom = 15.dp, top = 5.dp)
                .padding(horizontal = 10.dp)
        )
    }
}

@Preview()
@Composable
fun PrimaryUiPreview() {
    IconButton(onClick = { }, modifier = Modifier)
}