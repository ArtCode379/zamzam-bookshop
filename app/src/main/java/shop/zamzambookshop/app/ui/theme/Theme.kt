package shop.zamzambookshop.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = ForestGreenLight,
    onPrimary = Color.White,
    primaryContainer = ForestGreenDark,
    onPrimaryContainer = ForestGreenContainer,
    secondary = GoldenAmberLight,
    onSecondary = DarkBrown,
    secondaryContainer = GoldenAmberDark,
    onSecondaryContainer = GoldenAmberContainer,
    background = Color(0xFF1A1C19),
    onBackground = Cream,
    surface = Color(0xFF1A1C19),
    onSurface = Cream,
    surfaceVariant = Color(0xFF3A3C39),
    onSurfaceVariant = CreamDark,
)

private val LightColorScheme = lightColorScheme(
    primary = ForestGreen,
    onPrimary = Color.White,
    primaryContainer = ForestGreenContainer,
    onPrimaryContainer = OnForestGreenContainer,
    secondary = GoldenAmber,
    onSecondary = Color.White,
    secondaryContainer = GoldenAmberContainer,
    onSecondaryContainer = OnGoldenAmberContainer,
    tertiary = GoldenAmberDark,
    background = Cream,
    onBackground = DarkBrown,
    surface = Color.White,
    onSurface = DarkBrown,
    surfaceVariant = CreamDark,
    onSurfaceVariant = WarmGray,
    outline = LightBorder,
)

@Composable
fun ZMZBKTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}