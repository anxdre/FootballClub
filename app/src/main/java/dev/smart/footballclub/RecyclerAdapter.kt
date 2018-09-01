package dev.smart.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.items_list.view.*

class RecyclerAdapter(private val context:Context,private val items:List<Item>,private val listener:(Item)->Unit)
    :RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewtype: Int)
            = ViewHolder(LayoutInflater.from(context).inflate(R.layout.items_list,parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binditem(items [position],listener)
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder (view: View):RecyclerView.ViewHolder(view){

        fun binditem(items:Item,listener: (Item) -> Unit){
            itemView.name.text = items.name
            Glide.with(itemView.context).load(items.imageview).into(itemView.pic )
            itemView.setOnClickListener{
                listener(items)
            }
        }
    }
}