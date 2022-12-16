package com.evan.uilstep.proj

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListViewHolder<in V>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bindData(v: V)
}