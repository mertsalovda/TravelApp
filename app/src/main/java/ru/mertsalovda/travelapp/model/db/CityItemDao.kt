package ru.mertsalovda.travelapp.model.db

import ru.mertsalovda.travelapp.model.CityItem

class CityItemDao : DAO<CityItem> {
    private val list = mutableListOf<CityItem>()

    override fun insert(item: CityItem) {
        list.add(item)
    }
    override fun delete(item: CityItem) = list.remove(item)

    override fun getAllItem() = list

    override fun getItemByIndex(index: Int) = list[index]
}