package com.example.utsmobileprograming

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(context: Context, resource: Int, objects: ArrayList<AdobeItem>) : ArrayAdapter<AdobeItem>(context, resource, objects) {
    private val mContext: Context = context
    private val mResource: Int = resource

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(mResource, parent, false)
        }

        val adobeItem = getItem(position)

        val imageView = convertView!!.findViewById<ImageView>(R.id.photo)
        val titleTextView = convertView.findViewById<TextView>(R.id.tvNama)
        val descriptionTextView = convertView.findViewById<TextView>(R.id.tvDeskripsi)

        if (adobeItem != null) {
            imageView.setImageResource(adobeItem.imageResource)
            titleTextView.text = adobeItem.title
            descriptionTextView.text = adobeItem.description
        }

        return convertView
    }
}