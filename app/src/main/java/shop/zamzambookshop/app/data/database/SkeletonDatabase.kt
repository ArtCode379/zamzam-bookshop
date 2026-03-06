package shop.zamzambookshop.app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import shop.zamzambookshop.app.data.dao.CartItemDao
import shop.zamzambookshop.app.data.dao.OrderDao
import shop.zamzambookshop.app.data.database.converter.Converters
import shop.zamzambookshop.app.data.entity.CartItemEntity
import shop.zamzambookshop.app.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class ZMZBKDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}