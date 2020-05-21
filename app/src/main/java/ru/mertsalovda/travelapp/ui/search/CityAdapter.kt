package ru.mertsalovda.travelapp.ui.search

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.viewpager.widget.PagerAdapter
import ru.mertsalovda.travelapp.MainActivity
import ru.mertsalovda.travelapp.R
import ru.mertsalovda.travelapp.model.CityItem

class CityAdapter(private val models: Array<CityItem>, private val context: Context) :
    PagerAdapter() {

    private lateinit var layoutInflater: LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any) = view == `object`

    override fun getCount() = models.size

    @SuppressLint("ResourceType")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.cv_item, container, false)

        view.setOnClickListener{
            it.findNavController().navigate(R.id.action_global_navigation_details)
        }

        val ivCity = view.findViewById<ImageView>(R.id.ivCity)
        val tvCity = view.findViewById<TextView>(R.id.tvCity)

        tvCity.text = context.getString(models[position].nameString)
        ivCity.setImageDrawable(
            ContextCompat
                .getDrawable(context, models[position].cityDrawable)
        )
        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}