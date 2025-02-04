package com.example.fragment.module.wan.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.viewbinding.ViewBinding
import com.example.fragment.library.base.adapter.BaseAdapter
import com.example.fragment.library.common.activity.RouterActivity
import com.example.fragment.library.common.constant.Keys
import com.example.fragment.library.common.bean.TreeBean
import com.example.fragment.library.common.constant.Router
import com.example.fragment.module.wan.R
import com.example.fragment.module.wan.databinding.ItemSystemBinding

class SystemAdapter : BaseAdapter<TreeBean>() {

    override fun onCreateViewBinding(viewType: Int): (LayoutInflater, ViewGroup, Boolean) -> ViewBinding {
        return ItemSystemBinding::inflate
    }

    override fun onItemView(holder: ViewBindHolder, position: Int, item: TreeBean) {
        val binding = holder.binding as ItemSystemBinding
        val baseActivity: RouterActivity = contextToActivity(binding.root.context)
        binding.name.text = item.name
        binding.fbl.removeAllViews()
        item.children?.forEachIndexed { index, treeBean ->
            val inflater = LayoutInflater.from(binding.fbl.context)
            val tv: TextView =
                inflater.inflate(R.layout.fbl_system_children, binding.fbl, false) as TextView
            tv.text = treeBean.name
            tv.setOnClickListener {
                item.childrenSelectPosition = index
                val args = bundleOf(Keys.CID to treeBean.id)
                baseActivity.navigation(Router.SYSTEM, args)
            }
            binding.fbl.addView(tv)
        }
    }

}