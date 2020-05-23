package ru.mertsalovda.travelapp

import android.app.Application
import ru.mertsalovda.travelapp.model.CityItem
import ru.mertsalovda.travelapp.model.db.CityItemDao

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        fillTestData()
    }

    private fun fillTestData() {
        cityItemDao.insert(CityItem("Moscow", R.drawable.city_1_moscow, "Russia", 367))
        cityItemDao.insert(CityItem("Krasnodar", R.drawable.city_2_krasnodar, "Russia", 250))
        cityItemDao.insert(CityItem("St. Petersburg", R.drawable.city_3_spb, "Russia", 415))
        cityItemDao.insert(CityItem("Saratov", R.drawable.city_4_saratov, "Russia", 890))
        cityItemDao.insert(CityItem("Voronezh", R.drawable.city_5_voroneg, "Russia", 611))
        cityItemDao.insert(CityItem("Novosibirsk", R.drawable.city_6_novosib, "Russia", 300))
        cityItemDao.insert(CityItem("Kazan", R.drawable.city_7_kazan, "Russia", 200))
        cityItemDao.insert(CityItem("Anapa", R.drawable.city_8_anapa, "Russia", 512))
        cityItemDao.insert(CityItem("Sochi", R.drawable.city_9_sochi, "Russia", 256))
        cityItemDao.insert(CityItem("Armavir", R.drawable.city_10_armavir, "Russia", 1024))
        cityItemDao.insert(CityItem("Yekaterinburg", R.drawable.city_11_ekatirinburg, "Russia", 399))
        cityItemDao.insert(CityItem("Orel", R.drawable.city_12_orel, "Russia", 718))
        cityItemDao.insert(CityItem("Ufa", R.drawable.city_13_ufa, "Russia", 150))
        cityItemDao.insert(CityItem("Smolensk", R.drawable.city_14_smolensk, "Russia", 400))
    }

    companion object{
        private val cityItemDao = CityItemDao()

        fun getDB() = cityItemDao
    }
}