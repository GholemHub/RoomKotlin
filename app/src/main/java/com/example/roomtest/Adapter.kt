package com.example.roomtest

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.roomtest.data.Photo
import org.w3c.dom.Text

class Adapter: RecyclerView.Adapter<Adapter.ViewHolder>() {
    lateinit var textView: TextView
    lateinit var textView2: TextView
    lateinit var textView3: TextView
    lateinit var imageView: ImageView

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    private var list = emptyList<Photo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]

        textView = holder.itemView.findViewById(R.id.textView)
        textView2 = holder.itemView.findViewById(R.id.textView2)
        textView3 = holder.itemView.findViewById(R.id.textView3)
        imageView = holder.itemView.findViewById(R.id.imageView)

        textView.text = currentItem.id.toString()
        textView2.text = currentItem.name
        textView3.text = currentItem.logo
        imageView.load(currentItem.logo2)
    }

    fun setData(photo: List<Photo>){
        this.list = photo
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }
}