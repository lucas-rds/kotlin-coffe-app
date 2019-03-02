package com.cafe.querocafe.models

import java.math.BigDecimal
import java.util.*

data class Purchase(
    val buyer: Person,
    val value: BigDecimal,
    val shop: Shop,
    val date: Date
)