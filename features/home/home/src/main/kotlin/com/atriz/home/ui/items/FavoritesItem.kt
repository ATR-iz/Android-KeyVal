package com.atriz.home.ui.items

import android.graphics.Bitmap
import android.view.View
import com.atriz.core_presentation.utils.BitmapUtils
import com.atriz.home.R
import com.atriz.home.databinding.ItemFavoritesBinding
import com.xwray.groupie.viewbinding.BindableItem

class FavoritesItem(
    private val groupName: String,
    private val accountName: String,
    private val groupIcon: Bitmap? = null
) : BindableItem<ItemFavoritesBinding>() {

    companion object {
        private const val ICON_SIZE = 50F
    }

    override fun getLayout() = R.layout.item_favorites

    override fun bind(viewBinding: ItemFavoritesBinding, position: Int) {
        viewBinding.favoritesTextGroup.text = groupName
        viewBinding.favoritesTextAccountName.text = accountName

        if (groupIcon == null) {
            val icon = BitmapUtils.stringToBitmap(
                groupName.first().toString(),
                ICON_SIZE,
                R.color.coal_gray)

            viewBinding.favoritesImageGroupIcon.setImageBitmap(icon)
        } else {
            viewBinding.favoritesImageGroupIcon.setImageBitmap(groupIcon)
        }
    }

    override fun initializeViewBinding(view: View) = ItemFavoritesBinding.bind(view)
}
