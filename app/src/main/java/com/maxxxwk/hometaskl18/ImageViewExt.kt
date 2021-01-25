package com.maxxxwk.hometaskl18

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun AppCompatImageView.loadImageAsCircle(path: String) {
    Glide.with(context)
        .load(path)
        .placeholder(R.drawable.ic_launcher_foreground)
        .transition(DrawableTransitionOptions.withCrossFade())
        .circleCrop()
        .into(this)
}