package info.yazdan.cocktail.ui.common.model

import android.view.View
import info.yazdan.cocktail.ui.common.viewmodel.DrinkViewModel

data class DrinkViewEvent(val viewModel: DrinkViewModel, val root: View)