package com.example.githubclient.presentation.ui.users.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.size.ViewSizeResolver
import com.example.githubclient.databinding.ItemUserBinding
import com.example.githubclient.domain.model.user.User

class UserViewHolder(
    private val binding: ItemUserBinding,
    private val onUserClicked: (User) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(user: User) {
        with(binding) {
            image.load(user.avatarUrl) {
                scale(Scale.FIT)
                size(ViewSizeResolver(root))
            }
            textName.text = user.login

            root.setOnClickListener {
                onUserClicked(user)
            }
        }
    }
}