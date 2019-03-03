package com.cafe.querocafe.repository

import com.cafe.querocafe.model.Person
import com.cafe.querocafe.model.Purchase
import com.cafe.querocafe.model.Shop
import java.math.BigDecimal
import java.util.*

class PurchaseRepository : Repository<Purchase, Int> {

    override fun getAll(): List<Purchase> {
        return listOf(
            Purchase(
                1,
                Person("lucas"),
                BigDecimal(2),
                Shop("Café do ponto"),
                Date()
            ),
            Purchase(
                2,
                Person("lucas"),
                BigDecimal(5),
                Shop("Starbucks"),
                Date()
            )
        )
    }

    override fun getByPk(primaryKey: Int): Purchase? {
        return getAll().firstOrNull { it.id == primaryKey }
    }

    override fun filter(predicate: (Purchase) -> Boolean): List<Purchase> {
        return getAll().filter(predicate)
    }

}
