package com.atriz.home.ui.home.items

import android.graphics.Bitmap
import android.view.View
import com.atriz.home.R
import com.atriz.home.databinding.ItemGroupBinding
import com.atriz.home.utils.BitmapUtils
import com.xwray.groupie.viewbinding.BindableItem

class GroupItem(
    val groupId: Long,
    private val groupName: String,
    private val groupIcon: Bitmap? = null
) : BindableItem<ItemGroupBinding>() {

    companion object {
        private const val ICON_SIZE = 50F
    }

    override fun getLayout() = R.layout.item_group

    override fun bind(viewBinding: ItemGroupBinding, position: Int) {
        viewBinding.groupTextTitle.text = groupName

        if (groupIcon == null) {
            val icon = BitmapUtils.stringToBitmap(
                    groupName.first().toString(),
                    ICON_SIZE,
                    R.color.coal_gray)

            viewBinding.groupImageIcon.setImageBitmap(icon)
        } else {
            viewBinding.groupImageIcon.setImageBitmap(groupIcon)
        }
    }

    override fun initializeViewBinding(view: View) = ItemGroupBinding.bind(view)
}
