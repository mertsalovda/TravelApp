package ru.mertsalovda.travelapp.ui.details

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fr_details.*
import ru.mertsalovda.travelapp.MainActivity
import ru.mertsalovda.travelapp.R
import ru.mertsalovda.travelapp.model.CityItem


class DetailsFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailsViewModel =
            ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        return inflater.inflate(R.layout.fr_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.GONE
        val mainActivity = activity as MainActivity
        mainActivity.setSupportActionBar(toolbar)
        mainActivity.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mainActivity.supportActionBar?.title = ""

        detailsViewModel.setCityItem(arguments?.getSerializable(CITY) as CityItem)

        detailsViewModel.cityItem.observe(viewLifecycleOwner, Observer {
            tvCity.text = it.nameString
            tvCountry.text = it.country
            ivCity.setImageDrawable(ContextCompat.getDrawable(this.context!!, it.cityDrawable))
            tvFullPrice.text = it.price.toString()
        })

        bookFAB.setOnClickListener {
            val snackbar: Snackbar = Snackbar.make(it, "Добавлено в корзину", Snackbar.LENGTH_LONG)
            snackbar.setAction("hide") { v -> v.visibility = View.GONE }
            snackbar.duration = 7000
            snackbar.setAnchorView(R.id.bottomPanel)
            snackbar.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.details_toolbar, menu)
    }

    companion object{
        const val CITY = "CITY"
    }
}
