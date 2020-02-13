package info.yazdan.cocktail.ui.common.util

import android.widget.ImageView

interface IImageLoader {

    fun bind(imageView: ImageView, url: String?)

}