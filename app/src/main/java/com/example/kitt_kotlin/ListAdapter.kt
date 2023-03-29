package com.example.kitt_kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListAdapter(private val mContext: Context, items: List<ListItem?>?) : ArrayAdapter<ListItem?>(mContext, 0, items!!) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false)
        }
        val currentItem = getItem(position)
        val nameTextView = listItemView!!.findViewById<View>(R.id.name_text_view) as TextView
        nameTextView.text = currentItem!!.name
        val genreTextView = listItemView.findViewById<View>(R.id.genre_text_view) as TextView
        genreTextView.text = currentItem.genre
        val yearTextView = listItemView.findViewById<View>(R.id.year_text_view) as TextView
        yearTextView.text = currentItem.year
        return listItemView
    }
}