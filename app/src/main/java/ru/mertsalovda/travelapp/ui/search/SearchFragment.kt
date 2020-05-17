package ru.mertsalovda.travelapp.ui.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fr_search.*
import ru.mertsalovda.travelapp.R

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var adapter: CityViewPagerAdapter
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
        adapter = CityViewPagerAdapter(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewPager.setCreativeViewPagerAdapter(adapter)
        tvSize.text = "/" + adapter.getCount()
    }
}
