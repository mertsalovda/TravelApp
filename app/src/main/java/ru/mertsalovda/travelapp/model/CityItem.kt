package ru.mertsalovda.travelapp.model

import ru.mertsalovda.travelapp.R

enum class CityItem(open val nameString: Int, open val cityDrawable: Int) {
    CITY0(R.string.moscow, R.drawable.city_1_moscow),
    CITY1(R.string.krd, R.drawable.city_2_krasnodar),
    CITY2(R.string.spb , R.drawable.city_3_spb),
    CITY3(R.string.saratov, R.drawable.city_4_saratov),
    CITY4(R.string.voronezh, R.drawable.city_5_voroneg),
    CITY5(R.string.novosibirsk, R.drawable.city_6_novosib),
    CITY6(R.string.kazan, R.drawable.city_7_kazan),
    CITY7(R.string.anapa, R.drawable.city_8_anapa),
    CITY8(R.string.sochi, R.drawable.city_9_sochi),
    CITY9(R.string.armavir, R.drawable.city_10_armavir),
    CITY10(R.string.yekaterinburg, R.drawable.city_11_ekatirinburg),
    CITY11(R.string.orel, R.drawable.city_12_orel),
    CITY12(R.string.ufa, R.drawable.city_13_ufa),
    CITY13(R.string.smolensk, R.drawable.city_14_smolensk)
}