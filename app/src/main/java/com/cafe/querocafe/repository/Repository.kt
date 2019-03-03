package com.cafe.querocafe.repository

interface Repository<T, PK> {
    fun getAll(): List<T>
    fun getByPk(primaryKey: PK): T?
    fun filter(predicate: (T) -> Boolean): List<T>
}

