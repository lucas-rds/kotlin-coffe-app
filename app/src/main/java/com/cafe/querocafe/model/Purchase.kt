package com.cafe.querocafe.model

import java.math.BigDecimal
import java.util.*

data class Purchase(
    val id: Int,
    val buyer: Person,
    val value: BigDecimal,
    val shop: Shop,
    val date: Date
)