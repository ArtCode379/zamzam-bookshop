package shop.zamzambookshop.app.ui.composable.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import shop.zamzambookshop.app.ui.composable.screen.articledetail.ArticleDetailScreen
import shop.zamzambookshop.app.ui.composable.screen.cart.CartScreen
import shop.zamzambookshop.app.ui.composable.screen.checkout.CheckoutScreen
import shop.zamzambookshop.app.ui.composable.screen.onboarding.OnboardingScreen
import shop.zamzambookshop.app.ui.composable.screen.orders.OrdersScreen
import shop.zamzambookshop.app.ui.composable.screen.productdetails.ProductDetailsScreen
import shop.zamzambookshop.app.ui.composable.screen.products.ProductsScreen
import shop.zamzambookshop.app.ui.composable.screen.settings.SettingsScreen
import shop.zamzambookshop.app.ui.composable.screen.splash.SplashScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Splash,
        modifier = modifier,
    ) {
        composable<NavRoute.Splash> {
            SplashScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(route = NavRoute.Home) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                },
                onNavigateToOnboarding = {
                    navController.navigate(route = NavRoute.Onboarding) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Onboarding> {
            OnboardingScreen(
                onNavigateToHomeScreen = {
                    navController.navigate(NavRoute.Home) {
                        popUpTo(NavRoute.Onboarding) {
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<NavRoute.Home> {
            ProductsScreen(
                onNavigateToProductDetails = { id: Int ->
                    navController.navigate(
                        route = NavRoute.ProductDetails(id = id)
                    )
                },
                onNavigateToArticle = { index: Int ->
                    navController.navigate(
                        route = NavRoute.ArticleDetail(articleIndex = index)
                    )
                },
            )
        }

        composable<NavRoute.ProductDetails> { backStackEntry ->
            val productDetails: NavRoute.ProductDetails = backStackEntry.toRoute()
            ProductDetailsScreen(
                productId = productDetails.id,
            )
        }

        composable<NavRoute.Cart> {
            CartScreen(
                onNavigateToCheckoutScreen = {
                    navController.navigate(NavRoute.Checkout)
                }
            )
        }

        composable<NavRoute.Checkout> {
            CheckoutScreen(
                onNavigateToOrdersScreen = {
                    navController.navigate(NavRoute.Orders) {
                        popUpTo(NavRoute.Home) { inclusive = false }
                    }
                }
            )
        }

        composable<NavRoute.Orders> {
            OrdersScreen()
        }

        composable<NavRoute.Settings> {
            SettingsScreen()
        }

        composable<NavRoute.ArticleDetail> { backStackEntry ->
            val articleDetail: NavRoute.ArticleDetail = backStackEntry.toRoute()
            ArticleDetailScreen(
                articleIndex = articleDetail.articleIndex,
            )
        }
    }
}