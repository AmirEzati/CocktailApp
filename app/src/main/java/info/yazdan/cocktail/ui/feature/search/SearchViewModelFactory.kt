package info.yazdan.cocktail.ui.feature.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import info.yazdan.cocktail.data.repository.DrinkRepository
import info.yazdan.cocktail.data.repository.IngredientRepository

@Suppress("UNCHECKED_CAST")
class SearchViewModelFactory(private val drinkRepository: DrinkRepository,private val ingredientRepository: IngredientRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(drinkRepository, ingredientRepository) as T
    }
}