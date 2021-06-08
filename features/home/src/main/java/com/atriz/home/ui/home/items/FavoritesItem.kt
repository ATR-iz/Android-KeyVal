package com.atriz.home.ui.home.items

import android.graphics.Bitmap
import android.view.View
import com.atriz.home.R
import com.atriz.home.databinding.ItemFavoritesBinding
import com.atriz.home.utils.BitmapUtils
import com.xwray.groupie.viewbinding.BindableItem

class FavoritesItem(
    private val groupName: String,
    private val verificationName: String,
    private val groupIcon: Bitmap? = null
) : BindableItem<ItemFavoritesBinding>() {

    companion object {
        private const val ICON_SIZE = 50F
    }

    override fun getLayout() = R.layout.item_favorites

    override fun bind(viewBinding: ItemFavoritesBinding, position: Int) {
        viewBinding.favoritesTextGroup.text = groupName
        viewBinding.favoritesTextAccountName.text = verificationName

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
