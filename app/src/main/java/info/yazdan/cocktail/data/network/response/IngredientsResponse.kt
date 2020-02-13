package info.yazdan.cocktail.data.network.response

import com.google.gson.annotations.SerializedName
import info.yazdan.cocktail.data.database.entity.Ingredient

class IngredientsResponse {

    @SerializedName("drinks")
    lateinit var drinks: List<Ingredient>

}