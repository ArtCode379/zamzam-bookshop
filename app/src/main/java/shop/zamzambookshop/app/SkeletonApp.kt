package shop.zamzambookshop.app

import android.app.Application
import shop.zamzambookshop.app.di.dataModule
import shop.zamzambookshop.app.di.dispatcherModule
import shop.zamzambookshop.app.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class ZMZBKApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@ZMZBKApp)
            modules(appModules)
        }
    }
}