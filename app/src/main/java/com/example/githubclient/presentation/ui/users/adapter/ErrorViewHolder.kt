package com.example.githubclient.presentation.ui.users.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.databinding.ItemErrorBinding

class ErrorViewHolder(
    binding: ItemErrorBinding,
    onRetryClicked: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.button.setOnClickListener { onRetryClicked() }
    }
}