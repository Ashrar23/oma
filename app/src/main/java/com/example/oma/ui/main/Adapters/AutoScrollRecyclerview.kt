package com.example.oma.ui.main.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.oma.R
import com.example.oma.data.models.Article
import java.util.ArrayList

abstract class AutoScrollRecyclerview(
    ctx: Context,
    private val ListAdapter: ArrayList<Article>
): RecyclerView.Adapter<AutoScrollRecyclerview.MyViewHolder>()  {

    private val inflater: LayoutInflater = LayoutInflater.from(ctx)

    val onItemClickListener: AdapterView.OnItemClickListener
        get() = onItemClickListener


    abstract fun load()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AutoScrollRecyclerview.MyViewHolder {

        val view = inflater.inflate(R.layout.recycle_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AutoScrollRecyclerview.MyViewHolder, position: Int) {

        /*holder.iv.setImageResource(imageModelArrayList[position].imgRes)
        holder.time.text = imageModelArrayList[position].name*/

    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        /*var time: TextView = itemView.findViewById(R.id.txtName) as TextView
        var iv: ImageView = itemView.findViewById(R.id.imageView) as ImageView*/

    }
}