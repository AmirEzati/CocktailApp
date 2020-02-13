package info.yazdan.cocktail.data.network.response

import com.google.gson.annotations.SerializedName
import info.yazdan.cocktail.data.database.entity.Drink

class IngredientResponse {

    @SerializedName("drinks")
    lateinit var ingredients: List<Drink>

}