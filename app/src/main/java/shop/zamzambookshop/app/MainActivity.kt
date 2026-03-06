package shop.zamzambookshop.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import shop.zamzambookshop.app.ui.composable.approot.AppRoot
import shop.zamzambookshop.app.ui.theme.ZMZBKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ZMZBKTheme {
                AppRoot()
            }
        }
    }
}