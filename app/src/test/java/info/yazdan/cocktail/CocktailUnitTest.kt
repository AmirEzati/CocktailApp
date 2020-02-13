package info.yazdan.cocktail

import info.yazdan.cocktail.data.database.entity.Drink
import info.yazdan.cocktail.ui.common.mapper.toDrinkViewModel
import info.yazdan.cocktail.ui.common.viewmodel.DrinkViewModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CocktailUnitTest {

    @Test
    fun testMapper() {
        val drink = Drink("1", null, null, null)
        val drinkViewModel = drink.toDrinkViewModel()
        assertEquals(drink.idDrink, drinkViewModel.idDrink)
    }
}