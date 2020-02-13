package info.yazdan.cocktail.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import info.yazdan.cocktail.APP_DATABASE_NAME
import info.yazdan.cocktail.APP_DATABASE_VERSION
import info.yazdan.cocktail.data.database.dao.DrinkDao
import info.yazdan.cocktail.data.database.dao.IngredientDao
import info.yazdan.cocktail.data.database.entity.Drink
import info.yazdan.cocktail.data.database.entity.Ingredient

@Database(entities = [Drink::class, Ingredient::class], version = APP_DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getDrinkDao(): DrinkDao

    abstract fun getIngredientDao(): IngredientDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, APP_DATABASE_NAME
        ).build()
    }

}