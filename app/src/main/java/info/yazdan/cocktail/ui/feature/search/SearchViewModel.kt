package info.yazdan.cocktail.ui.feature.search

import android.os.Parcelable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import info.yazdan.cocktail.data.database.entity.Drink
import info.yazdan.cocktail.data.repository.DrinkRepository
import info.yazdan.cocktail.data.repository.IngredientRepository
import info.yazdan.cocktail.helper.NoInternetException
import info.yazdan.cocktail.helper.coroutines.Coroutines
import info.yazdan.cocktail.ui.common.mapper.toArray

class SearchViewModel(private val drinkRepository: DrinkRepository, private val ingredientRepository: IngredientRepository) : ViewModel() {

    var recyclerViewState: Parcelable? = null
    var listener: ISearchFragment? = null
    var progressState: MutableLiveData<Boolean> = MutableLiveData(true)
    val drinks: MutableLiveData<List<Drink>> = MutableLiveData()
    val ingredients: MutableLiveData<Array<String>> = MutableLiveData()

    init {
        Coroutines.main {
            ingredients.postValue(ingredientRepository.getIngredients().toArray())
        }
    }

    fun searchFor(query: String) {
        Coroutines.main {
            try {
                drinks.postValue(drinkRepository.searchIngredient(query))
            } catch (e: NoInternetException) {
                listener?.onError(e)
            } catch (e: Exception) {
                listener?.onError(e)
            }
        }
    }
}