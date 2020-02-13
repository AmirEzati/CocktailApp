package info.yazdan.cocktail.ui.feature.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.yazdan.cocktail.data.database.entity.Drink
import info.yazdan.cocktail.data.database.entity.Ingredient
import info.yazdan.cocktail.data.repository.DrinkRepository
import info.yazdan.cocktail.data.repository.IngredientRepository
import info.yazdan.cocktail.helper.NoInternetException
import info.yazdan.cocktail.helper.coroutines.Coroutines
import java.lang.Exception

class DetailsViewModel(private val drinkRepository: DrinkRepository) : ViewModel() {

    lateinit var listener: IDetailsFragment
    var progressState: MutableLiveData<Boolean> = MutableLiveData(true)
    var drink: MutableLiveData<Drink> = MutableLiveData()

    fun fetchIngredient(id: String) {
        Coroutines.main {
            try {
                drink.postValue(drinkRepository.fetchDrink(id))
            } catch (e: NoInternetException) {
                listener.onError(e)
            } catch (e: Exception) {
                listener.onError(e)
            }
        }
    }

}