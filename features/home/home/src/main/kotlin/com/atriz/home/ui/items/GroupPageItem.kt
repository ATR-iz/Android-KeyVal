package com.atriz.home.ui.items

import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.atriz.home.R
import com.atriz.home.databinding.ItemGroupPageBinding
import com.atriz.database_api.model.Group
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.viewbinding.BindableItem

class GroupPageItem(
    private val groups: List<Group>,
    private val onGroupClicked: (idGroup: Long) -> Unit
) : BindableItem<ItemGroupPageBinding>() {
    override fun getLayout() = R.layout.item_group_page

    override fun bind(viewBinding: ItemGroupPageBinding, position: Int) {
        val adapter = GroupieAdapter()

        viewBinding.groupPageList.layoutManager = LinearLayoutManager(viewBinding.root.context)
        viewBinding.groupPageList.adapter = adapter

        val items = groups.map {
            GroupItem(
                groupId = it.groupId,
                groupName = it.groupName
            )
        }

        adapter.setOnItemClickListener { item, _ ->
            onGroupClicked.invoke((item as GroupItem).groupId)
        }

        adapter.update(items)
    }

    override fun initializeViewBinding(view: View) = ItemGroupPageBinding.bind(view)
}
