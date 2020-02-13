package info.yazdan.cocktail.data.preference

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager

const val KEY_INGREDIENT_SAVED_AT = "ingredient_saved_at"

class PreferenceManager(context: Context) {

    private var sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context.applicationContext)

    fun getIngredientLastSavedTime(): Long {
        return sharedPreferences.getLong(KEY_INGREDIENT_SAVED_AT, 0L)
    }

    fun saveIngredientLastSavedAt(savedAt: Long) {
        sharedPreferences.edit().putLong(KEY_INGREDIENT_SAVED_AT, savedAt).apply()
    }

}