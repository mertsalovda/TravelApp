package ru.mertsalovda.travelapp.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.travelapp.App
import ru.mertsalovda.travelapp.model.CityItem

class SearchViewModel : ViewModel() {

    private val items = App.getDB().getAllItem()

    val citiesItems = MutableLiveData<MutableList<CityItem>>()

    fun load() {
        citiesItems.postValue(items)
    }

    fun search(query: String) {
        val filter =
            items.filter {
                it.nameString.toLowerCase().contains(query)
                        || it.price.toString() == query
            }
        citiesItems.postValue(filter as MutableList<CityItem>)
    }
}