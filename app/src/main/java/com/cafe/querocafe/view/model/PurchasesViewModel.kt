package com.cafe.querocafe.view.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cafe.querocafe.model.Purchase


class PurchasesViewModel() : ViewModel() {

    private val _purchases = MutableLiveData<List<Purchase>>().apply { value = emptyList() }

    val purchases: LiveData<List<Purchase>> get() = _purchases

    fun getPurchases() {
//        private val repository: PurchaseRepository
//        _purchases.value = repository.getAll()
    }
}