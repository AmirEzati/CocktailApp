package info.yazdan.cocktail.ui.common.viewholder

import android.view.View
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import info.yazdan.cocktail.ui.common.model.DrinkViewEvent
import info.yazdan.cocktail.ui.common.util.ImageLoaderContext
import info.yazdan.cocktail.ui.common.viewmodel.DrinkViewModel
import io.github.janbarari.genericrecyclerview.listener.GenericUriListener
import io.github.janbarari.genericrecyclerview.model.GenericViewModel
import io.github.janbarari.genericrecyclerview.viewholder.GenericViewHolder
import kotlinx.android.synthetic.main.drink_adapter_cell.view.*

class DrinkViewHolder(private val view: View, private val listener: GenericUriListener) : GenericViewHolder(view,  listener) {

    override fun bind(dataModel: GenericViewModel) {
        super.bind(dataModel)
        val data = dataModel as DrinkViewModel
        with(view) {
            title.text = data.strDrink
            ImageLoaderContext.imageLoader.bind(image, data.strDrinkThumb)
            ViewCompat.setTransitionName(image, "image_${data.idDrink}")
            root.setOnClickListener {
                listener.onClick(DrinkViewEvent(data, view))
            }
        }
    }
}