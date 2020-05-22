package ru.mertsalovda.travelapp.ui.details

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fr_details.*
import ru.mertsalovda.travelapp.MainActivity
import ru.mertsalovda.travelapp.R
import ru.mertsalovda.travelapp.model.HotelOrFlightItem


class DetailsFragment : Fragment() {

    private lateinit var detailsViewModel: DetailsViewModel
    private val adapter = DetailsAdapter()

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

        val list = mutableListOf(HotelOrFlightItem("hotel"), HotelOrFlightItem("flight"))
        adapter.addData(list, false)

        val layoutManager = LinearLayoutManager(activity)
        detailsRecycler.layoutManager = layoutManager
        detailsRecycler.adapter = adapter

        bookFAB.setOnClickListener {
            val snackbar: Snackbar = Snackbar.make(it, "Добавлено в корзину", Snackbar.LENGTH_LONG)
            snackbar.setAction("hide") { v -> v.visibility = View.GONE }
            snackbar.duration = 7000
            snackbar.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.details_toolbar, menu)
    }
}
