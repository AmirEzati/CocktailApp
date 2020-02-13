package info.yazdan.cocktail.ui.feature.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.yazdan.cocktail.data.repository.DrinkRepository
import info.yazdan.cocktail.data.repository.IngredientRepository

@Suppress("UNCHECKED_CAST")
class DetailsViewModelFactory(private val drinkRepository: DrinkRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailsViewModel(drinkRepository) as T
    }
}