package com.atriz.home.ui.home.items

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.atriz.home.R
import com.atriz.home.databinding.ItemFavoritesPageBinding
import com.atriz.database_api.model.AccountWithGroup
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem

class FavoritesPageItem(
    private val favorites: List<AccountWithGroup>
) : BindableItem<ItemFavoritesPageBinding>() {
    override fun getLayout() = R.layout.item_favorites_page

    override fun bind(viewBinding: ItemFavoritesPageBinding, position: Int) {
        val adapter = GroupieAdapter()

        viewBinding.favoritesPageList.layoutManager = LinearLayoutManager(viewBinding.root.context)
        viewBinding.favoritesPageList.adapter = adapter

        val items = favorites.map {
            FavoritesItem(
                    groupName = it.group.groupName,
                    verificationName = it.account.authName
            )
        }

        adapter.update(items)
    }

    override fun initializeViewBinding(view: View) = ItemFavoritesPageBinding.bind(view)
}
