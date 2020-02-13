package info.yazdan.cocktail.data.database.dao

import androidx.room.*
import info.yazdan.cocktail.data.database.entity.Drink

@Dao
interface DrinkDao {

    @Query("SELECT * FROM drink")
    fun getDrinks(): List<Drink>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllDrinks(drinks: List<Drink>)

    @Query("DELETE FROM drink")
    fun deleteDrinks()

}