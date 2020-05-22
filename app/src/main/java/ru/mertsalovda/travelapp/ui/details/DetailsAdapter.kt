package ru.mertsalovda.travelapp.ui.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mertsalovda.travelapp.R
import ru.mertsalovda.travelapp.model.HotelOrFlightItem

class DetailsAdapter : RecyclerView.Adapter<ItemCardHolder>() {

    private val list = mutableListOf<HotelOrFlightItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemCardHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = when (viewType) {
            CardType.HOTEL.ordinal -> inflater.inflate(R.layout.cv_hotel, parent, false)
            else -> inflater.inflate(R.layout.cv_flight, parent, false)
        }
        return ItemCardHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemCardHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemViewType(position: Int): Int {
        val card = list[position]
        return when (card.type) {
            "hotel" -> CardType.HOTEL.ordinal
            else -> CardType.FLIGHT.ordinal
        }
    }

    fun addData(data: List<HotelOrFlightItem>, clear: Boolean) {
        if (clear) {
            list.clear()
        }
        list.addAll(data)
        notifyDataSetChanged()
    }
}


enum class CardType {
    HOTEL,
    FLIGHT
}