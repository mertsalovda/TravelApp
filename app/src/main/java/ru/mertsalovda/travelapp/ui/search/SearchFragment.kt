package ru.mertsalovda.travelapp.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fr_search.*
import ru.mertsalovda.travelapp.App
import ru.mertsalovda.travelapp.R

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel

    private lateinit var adapter: CityAdapter
    private var citiesList = App.getDB().getAllItem()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
            ViewModelProviders.of(this).get(SearchViewModel::class.java)
        return inflater.inflate(R.layout.fr_search, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        adapter = CityAdapter(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.findViewById<BottomNavigationView>(R.id.nav_view)?.visibility = View.VISIBLE

        tvSize.text = "/" + adapter.getCount()
        tvCounter.text = "1"

        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                tvCounter.text = (1 + position).toString()
            }
        })
        searchViewModel.citiesItems.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it, true)
            tvSize.text = "/" + it.size
            if (it.isNotEmpty()){
                tvCounter.text = "1"
                viewPager.setCurrentItem(0, true)
            } else {
                tvCounter.text = "0"
            }
        })
        searchViewModel.load()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    if (newText.isNotEmpty()) {
                        searchViewModel.search(newText.toLowerCase())
                    } else {
                        searchViewModel.load()
                    }
                }
                return true
            }
        })
    }
}
