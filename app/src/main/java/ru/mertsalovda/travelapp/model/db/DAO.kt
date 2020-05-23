package ru.mertsalovda.travelapp.model.db

interface DAO<T> {
    fun insert(item: T)
    fun delete(item: T): Boolean
    fun getAllItem(): MutableList<T>
    fun getItemByIndex(index: Int): T
}