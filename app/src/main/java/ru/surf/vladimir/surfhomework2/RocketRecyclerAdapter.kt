package ru.surf.vladimir.surfhomework2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class RocketRecyclerAdapter(private val rockets: List<RocketDTO>) :
    RecyclerView.Adapter<RocketRecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val picture: ImageView = itemView.findViewById(R.id.rocket_item_picture)
        val name: TextView = itemView.findViewById(R.id.rocket_item_name)
        val status: TextView = itemView.findViewById(R.id.rocket_item_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rocket_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return rockets.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.picture.setImageResource(rockets[position].picture)
        holder.name.text = rockets[position].name
        if (rockets[position].status) {
            holder.status.text = activeStr
            holder.status.backgroundTintList =
                ContextCompat.getColorStateList(holder.status.context, R.color.green)

        }
        else {
            holder.status.text = inactiveStr
            holder.status.backgroundTintList =
                ContextCompat.getColorStateList(holder.status.context, R.color.red)
        }
    }
}