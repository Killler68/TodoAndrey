package com.example.myapplication.hotels.hotellist.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

private const val LAST_ITEM = 1

class LastItemDecorator(private val bottomMargin: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildAdapterPosition(view) == parent.adapter?.itemCount?.minus(LAST_ITEM)) {
            outRect.bottom = bottomMargin
        }
    }
}
