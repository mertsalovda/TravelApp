package ru.mertsalovda.travelapp.ui.search

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.viewpager.widget.PagerAdapter
import ru.mertsalovda.travelapp.R
import ru.mertsalovda.travelapp.model.CityItem
import ru.mertsalovda.travelapp.ui.details.DetailsFragment

class CityAdapter(private val listItems: MutableList<CityItem>, private val context: Context) :
    PagerAdapter() {

    private lateinit var layoutInflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = listItems.size

    @SuppressLint("ResourceType")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.cv_item, container, false)

        view.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable(DetailsFragment.CITY, listItems[position])
            it.findNavController().navigate(R.id.action_global_navigation_details, bundle)
        }

        val ivCity = view.findViewById<ImageView>(R.id.ivCity)
        val tvCity = view.findViewById<TextView>(R.id.tvCity)
        val tvCountry = view.findViewById<TextView>(R.id.tvCountry)
        val tvPrice = view.findViewById<TextView>(R.id.tvPrice)

        tvCity.text = listItems[position].nameString
        ivCity.setImageDrawable(
            ContextCompat.getDrawable(context, listItems[position].cityDrawable)
        )
        tvCountry.text = listItems[position].country
        tvPrice.text = listItems[position].price.toString()

        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}