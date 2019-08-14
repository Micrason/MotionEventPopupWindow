package com.kcrason.library

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.*

/**
 * @author KCrason
 * @date 2019/8/14 10:05
 * @description
 */
class CommonOptionsAdapter : BaseAdapter() {
    override fun getItem(p0: Int): String {
        return mOptionsArray[p0]
    }

    private var mOptionsArray: List<String> = ArrayList()

    fun showOptions(options: List<String>) {
        this.mOptionsArray = options
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View
        val commonOptionsViewHolder: CommonOptionsViewHolder
        if (convertView == null) {
            itemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_list_options_view, parent, false)
            commonOptionsViewHolder = CommonOptionsViewHolder(itemView)
            itemView.tag = commonOptionsViewHolder
        } else {
            itemView = convertView
            commonOptionsViewHolder = itemView.tag as CommonOptionsViewHolder
        }
        commonOptionsViewHolder.txtOption.text = mOptionsArray[position]
        return itemView
    }


    class CommonOptionsViewHolder(itemView: View) {
        val txtOption: TextView = itemView.findViewById(R.id.txtOption)
    }


    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return mOptionsArray.size
    }
}