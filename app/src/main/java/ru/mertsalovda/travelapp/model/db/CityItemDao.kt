package ru.mertsalovda.travelapp.model.db

import ru.mertsalovda.travelapp.model.CityItem

class CityItemDao : DAO<CityItem> {
    private val list = mutableListOf<CityItem>()

    override fun insert(item: CityItem) {
        list.add(item)
    }
    override fun delete(item: CityItem) = list.remove(item)

    override fun getAllItem(): MutableList<CityItem> {
        val result = mutableListOf<CityItem>()
        result.addAll(list)
        return result
    }

    override fun getItemByIndex(index: Int) = list[index]
}