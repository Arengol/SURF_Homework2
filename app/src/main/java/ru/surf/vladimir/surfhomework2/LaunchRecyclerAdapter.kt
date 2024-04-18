package ru.surf.vladimir.surfhomework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class LaunchRecyclerAdapter(private val launches: List<LaunchDTO>) :
    RecyclerView.Adapter<LaunchRecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val picture: ImageView = itemView.findViewById(R.id.launch_item_picture)
        val name: TextView = itemView.findViewById(R.id.launch_item_name)
        val site: TextView = itemView.findViewById(R.id.launch_item_site)
        val date: TextView = itemView.findViewById(R.id.launch_item_date)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.launch_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return launches.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.picture.setImageResource(launches[position].picture)
        holder.name.text = launches[position].name
        holder.site.text = launches[position].site
        holder.date.text = launches[position].date
    }
}