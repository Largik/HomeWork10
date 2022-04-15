package com.test.homework10

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.homework10.Models.Fish


private val TAGS =
    listOf("<ul>", "<li>", "<p>", "</ul>", "</li>", "</p>", "&nbsp", "<a>", "</a>", "\n", ";")

class FishAdapter(private val items: MutableList<Fish>) : RecyclerView.Adapter<ItemsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val rootView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ItemsViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(items[position])
    }
}

class ItemsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textNameView: TextView = itemView.findViewById(R.id.name)
    private val textCaloriesView: TextView = itemView.findViewById(R.id.calories)
    private val textLocationView: TextView = itemView.findViewById(R.id.location)
    private val textHabitatView: TextView = itemView.findViewById(R.id.habitat)
    private val textBiologyView: TextView = itemView.findViewById(R.id.biology)
    private val textAvailabilityView: TextView = itemView.findViewById(R.id.availability)
    private val photoView: ImageView = itemView.findViewById(R.id.photo)


    @SuppressLint("SetTextI18n")
    fun bind(fish: Fish) {
        textNameView.text = "Name: \n" + (fish.speciesName ?: "not found")
        textCaloriesView.text = "Calories: \n" + (fish.calories?: "not found")
        textLocationView.text = "Location: \n" + (fish.location?.removeTags() ?: "not found")
        textHabitatView.text = "Habitat: \n" + (fish.habitat?.removeTags() ?: "not found")
        textBiologyView.text = "Biology: \n" + (fish.biology?.removeTags() ?: "not found")
        textAvailabilityView.text = "Availability: \n" + (fish.availability?.removeTags() ?: "not found")
        Glide
            .with(itemView.context)
            .load(fish.speciesIllustration?.src)
            .into(photoView)
    }
}
fun String.removeTags(): String {
    var newText: String = this

    TAGS.map {
        if (newText.contains(it)) {
            newText = newText.replace(it, "")
        }
    }

    newText = newText.replace(".", ". ").replace("<.*>".toRegex(), "")
    return newText
}