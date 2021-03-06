package com.example.planetapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view.view.*

class Adapter(var planet: List<PlanetData>) : RecyclerView.Adapter<Adapter.myViewHolder>() {

    class myViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title = view.title
        var planetimg = view.planet_img
        var galaxy = view.galaxy
        var distance = view.distance
        var gravity = view.gravity

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.view, parent, false)

        return myViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        var dummyImage: Int? = null
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, PlanetDetail::class.java)
            intent.putExtra("planet", planet[position])
            intent.putExtra("planetImage", dummyImage)
            holder.itemView.context.startActivity(intent)
        }
        holder.title.text = planet[position].title
        holder.galaxy.text = planet[position].galaxy
        holder.distance.text = planet[position].distance + "m km"
        holder.gravity.text = planet[position].gravity + " m/s²"

        when (planet[position].title!!.toLowerCase()) {
            "earth" -> {
                dummyImage = R.drawable.ic_earth
            }
            "jupiter" -> {
                dummyImage = R.drawable.ic_jupiter
            }
            "mars" -> {
                dummyImage = R.drawable.ic_mars
            }
            "mercury" -> {
                dummyImage = R.drawable.ic_mercury
            }
            "moon" -> {
                dummyImage = R.drawable.ic_moon
            }
            "neptune" -> {
                dummyImage = R.drawable.ic_neptune
            }
            "saturn" -> {
                dummyImage = R.drawable.ic_saturn
            }
            "sun" -> {
                dummyImage = R.drawable.ic_sun
            }
            "uranus" -> {
                dummyImage = R.drawable.ic_uranus
            }
            "venus" -> {
                dummyImage = R.drawable.ic_venus
            }
        }

        holder.planetimg.setImageResource(dummyImage!!)

    }

    override fun getItemCount(): Int {
        return planet.size
    }
}

