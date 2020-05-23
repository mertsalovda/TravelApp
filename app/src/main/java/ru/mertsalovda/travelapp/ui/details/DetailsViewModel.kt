package ru.mertsalovda.travelapp.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.mertsalovda.travelapp.model.CityItem

class DetailsViewModel : ViewModel() {

    val cityItem = MutableLiveData<CityItem>()

    fun setCityItem(item: CityItem){
        cityItem.postValue(item)
    }
}