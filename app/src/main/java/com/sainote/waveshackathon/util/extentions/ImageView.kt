package com.sainote.waveshackathon.util.extentions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImage(link: String) =
    Glide.with(this.context)
        .load(link)
        .apply(
            RequestOptions()
                .fitCenter()
                .centerCrop()
        )
        .into(this)

fun ImageView.loadWithoutCrop(link: String)=
    Glide.with(this.context)
        .load(link)
        .apply(
            RequestOptions()
                .fitCenter()
        )
        .into(this)