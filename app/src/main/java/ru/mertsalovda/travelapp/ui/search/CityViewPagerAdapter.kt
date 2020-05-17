package ru.mertsalovda.travelapp.ui.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.tbuonomo.creativeviewpager.adapter.CreativePagerAdapter
import ru.mertsalovda.travelapp.R
import ru.mertsalovda.travelapp.model.CityItem

class CityViewPagerAdapter(private val context: Context) : CreativePagerAdapter {

    override fun getCount() = CityItem.values().size

    override fun instantiateContentItem(
        inflater: LayoutInflater,
        container: ViewGroup,
        position: Int
    ): View {
        return inflater.inflate(R.layout.header, container, false)
    }

    override fun instantiateHeaderItem(
        inflater: LayoutInflater,
        container: ViewGroup,
        position: Int
    ): View {
        val view = inflater.inflate(R.layout.cv_item, container, false)

        val ivCity = view.findViewById<ImageView>(R.id.ivCity)
        val tvCity = view.findViewById<TextView>(R.id.tvCity)

        tvCity.text = context.getString(CityItem.values()[position].nameString)
        ivCity.setImageDrawable(
            ContextCompat
                .getDrawable(context, CityItem.values()[position].cityDrawable)
        )

        view.setOnClickListener {
            tvCity.text = position.toString()
        }
        return view
    }
}