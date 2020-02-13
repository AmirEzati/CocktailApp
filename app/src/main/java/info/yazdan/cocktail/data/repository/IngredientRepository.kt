package info.yazdan.cocktail.data.repository

import androidx.lifecycle.MutableLiveData
import info.yazdan.cocktail.data.database.AppDatabase
import info.yazdan.cocktail.data.database.entity.Ingredient
import info.yazdan.cocktail.data.network.Api
import info.yazdan.cocktail.data.network.SafeApiRequest
import info.yazdan.cocktail.data.preference.PreferenceManager
import info.yazdan.cocktail.helper.coroutines.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * one hour by millisecond
 */
private const val MINIMUM_INTERVAL = 3_600_000

class IngredientRepository(
    private val api: Api,
    private val db: AppDatabase,
    private val preferenceManager: PreferenceManager
) : SafeApiRequest() {

    private val ingredients = MutableLiveData<List<Ingredient>>()

    init {
        ingredients.observeForever {
            saveIngredients(it)
        }
    }

    /**
     * Fetch ingredients from api
     */
    private suspend fun fetchIngredients() {
        val response = apiRequest {
            api.fetchIngredients()
        }
        ingredients.postValue(response.drinks)
    }

    suspend fun getIngredients(): List<Ingredient> {
        return withContext(Dispatchers.IO) {
            if (isFetchNeeded(preferenceManager.getIngredientLastSavedTime())) {
                fetchIngredients()
            }
            db.getIngredientDao().getIngredients()
        }
    }

    /**
     * returns true when last saved ingredients time is more than one hour
     */
    private fun isFetchNeeded(savedAt: Long): Boolean {
        return System.currentTimeMillis() - savedAt > MINIMUM_INTERVAL
    }

    /**
     * Save new ingredients to database, update last saved time
     */
    private fun saveIngredients(ingredient: List<Ingredient>) {
        Coroutines.io {
            preferenceManager.saveIngredientLastSavedAt(System.currentTimeMillis())
            db.getIngredientDao().saveAllIngredients(ingredient)
        }
    }
}