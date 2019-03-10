package com.cafe.querocafe.repository

import com.cafe.querocafe.model.Person
import com.cafe.querocafe.model.Purchase
import com.cafe.querocafe.model.Shop
import java.math.BigDecimal
import java.util.*
import javax.inject.Inject

class PurchaseRepository @Inject constructor() : Repository<Purchase, Int> {

    override fun getAll(): List<Purchase> {
        return List(10) {
            Purchase(
                it,
                Person(listOf("Lucas", "Marcelo", "Thiago", "Adriano").random()),
                BigDecimal((10L..30).random()),
                Shop(listOf("Café do ponto", "Starbucks", "Brounie", "Malabarista").random()),
                Date()
            )
        }
    }

    override fun getByPk(primaryKey: Int): Purchase? {
        return getAll().firstOrNull { it.id == primaryKey }
    }

    override fun filter(predicate: (Purchase) -> Boolean): List<Purchase> {
        return getAll().filter(predicate)
    }

}
