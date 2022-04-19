package com.test.homework10

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.test.homework10.domain.Fish
import com.test.homework10.presentation.FishViewModel
import java.security.AccessController.getContext


private val TAGS =
    listOf("<ul>", "<li>", "<p>", "</ul>", "</li>", "</p>", "&nbsp", "<a>", "</a>", "\n", ";")

class FishAdapter(private val items: List<Fish>, private val vm: ViewModel) : RecyclerView.Adapter<ItemsViewHolder>() {

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
        holder.bind(items[position], vm as FishViewModel)
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
    private val favoriteBtn: FloatingActionButton = itemView.findViewById(R.id.favorite)

    @SuppressLint("SetTextI18n")
    fun bind(fish: Fish, vm: FishViewModel) {
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

        favoriteBtn.setOnClickListener {
            if(vm.inFavorite(fish)){
                favoriteBtn.setColorFilter(Color.BLACK)
                Toast.makeText(it.context, "Removed from favorites", Toast.LENGTH_SHORT).show()
            }else{
                favoriteBtn.setColorFilter(Color.MAGENTA)
                Toast.makeText(it.context, "Add to favorites", Toast.LENGTH_SHORT).show()
            }
            vm.updateFavorites(fish)
        }
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