package com.cafe.querocafe.model.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cafe.querocafe.repository.PurchaseRepository
import javax.inject.Inject


class PurchasesViewModel @Inject constructor() : ViewModel() {

    private val _purchases = MutableLiveData<List<PurchaseUiModel>>().apply { value = emptyList() }

    @Inject
    lateinit var purchaseRepository: PurchaseRepository

    val purchases: LiveData<List<PurchaseUiModel>> get() = _purchases

    fun getPurchases() {
        _purchases.value = purchaseRepository
            .getAll()
            .map(PurchaseUiModel.Create::fromPurchase)
    }
}