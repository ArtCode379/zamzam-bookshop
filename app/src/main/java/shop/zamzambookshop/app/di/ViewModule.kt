package shop.zamzambookshop.app.di

import shop.zamzambookshop.app.ui.viewmodel.AppViewModel
import shop.zamzambookshop.app.ui.viewmodel.CartViewModel
import shop.zamzambookshop.app.ui.viewmodel.CheckoutViewModel
import shop.zamzambookshop.app.ui.viewmodel.OnboardingViewModel
import shop.zamzambookshop.app.ui.viewmodel.OrderViewModel
import shop.zamzambookshop.app.ui.viewmodel.ProductDetailsViewModel
import shop.zamzambookshop.app.ui.viewmodel.ProductViewModel
import shop.zamzambookshop.app.ui.viewmodel.SplashViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        SplashViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        OnboardingViewModel(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}