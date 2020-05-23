package ru.mertsalovda.travelapp.model

import java.io.Serializable

data class CityItem(
    val nameString: String,
    val cityDrawable: Int,
    val country: String,
    val price: Int
) :
    Serializable