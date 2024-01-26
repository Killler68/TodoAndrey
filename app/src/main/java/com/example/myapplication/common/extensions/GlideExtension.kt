package com.example.myapplication.common.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.ImageView.ScaleType
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.myapplication.R
import jp.wasabeef.glide.transformations.CropTransformation

private const val SIZE_IMAGE_WIDTH = 800
private const val SIZE_IMAGE_HEIGHT = 500
fun glide(image: ImageView, context: Context, url: String) {

    Glide
        .with(context)
        .load(url)
        .transform(CropTransformation(SIZE_IMAGE_WIDTH,SIZE_IMAGE_HEIGHT))
        .listener(object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                image.scaleType = ScaleType.FIT_CENTER
                image.setImageResource(R.drawable.empty)
                return true
            }

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: Target<Drawable>?,
                dataSource: com.bumptech.glide.load.DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                image.scaleType = ScaleType.CENTER_CROP
                return false
            }
        })
        .into(image)
}