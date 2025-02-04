package com.example.fragment.module.wan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.fragment.library.base.adapter.BaseAdapter
import com.example.fragment.module.wan.R
import com.example.fragment.module.wan.databinding.ItemSearchHistoryBinding

class SearchHistoryAdapter : BaseAdapter<String>() {

    init {
        addOnClickListener(R.id.delete)
    }

    override fun onCreateViewBinding(viewType: Int): (LayoutInflater, ViewGroup, Boolean) -> ViewBinding {
        return ItemSearchHistoryBinding::inflate
    }

    override fun onItemView(holder: ViewBindHolder, position: Int, item: String) {
        val binding = holder.binding as ItemSearchHistoryBinding
        binding.title.text = item
    }

}