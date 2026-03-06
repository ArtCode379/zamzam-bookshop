package shop.zamzambookshop.app.di

import androidx.room.Room
import shop.zamzambookshop.app.data.database.ZMZBKDatabase
import org.koin.dsl.module

private const val DB_NAME = "skeleton_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = ZMZBKDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<ZMZBKDatabase>().cartItemDao() }

    single { get<ZMZBKDatabase>().orderDao() }
}