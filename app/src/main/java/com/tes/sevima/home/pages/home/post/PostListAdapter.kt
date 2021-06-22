package com.tes.sevima.home.pages.home.post

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.tes.sevima.R

class PostListAdapter(private val context: Context, private val list: ArrayList<PostModel>): BaseAdapter() {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.list_home_post, parent, false)
        var name = convertView.findViewById(R.id.name_label) as TextView
        var date = convertView.findViewById(R.id.date_label) as TextView
        var avatar = convertView.findViewById(R.id.avatar_image) as ImageView

//        deleteButton.setOnClickListener {
//            val c = context as CustomerActivity
//            c.onAlertDialog(context, "Apakah Anda yakin ingin menghapus toko ${list[position].CustomerName}", list[position])
//        }

        name.setText(list[position].name)
        date.setText(list[position].date)
        avatar.setImageResource(R.drawable.sentra_vidya_utama_pt)

        return convertView
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}