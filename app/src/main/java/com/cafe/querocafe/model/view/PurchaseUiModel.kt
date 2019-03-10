package com.cafe.querocafe.model.view

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import com.cafe.querocafe.model.Purchase
import java.math.BigDecimal
import java.util.*

data class PurchaseUiModel(
    private var _id: Int,
    private var _buyerName: String,
    private var _shopName: String,
    private var _price: BigDecimal,
    private var _date: Date
) : BaseObservable() {

    var id: Int
        @Bindable get() = _id
        set(value) {
            _id = value
            notifyPropertyChanged(BR.id)
        }

    var buyerName: String
        @Bindable get() = _buyerName
        set(value) {
            _buyerName = value
            notifyPropertyChanged(BR.buyerName)
        }

    var price: BigDecimal
        @Bindable get() = _price
        set(value) {
            _price = value
            notifyPropertyChanged(BR.price)
        }

    var shopName: String
        @Bindable get() = _shopName
        set(value) {
            _shopName = value
            notifyPropertyChanged(BR.shopName)
        }

    var date: Date
        @Bindable get() = _date
        set(value) {
            _date = value
            notifyPropertyChanged(BR.date)
        }

    private var _color = -1
    var color: Int
        @Bindable get() = _color
        set(value) {
            _color = value
            notifyPropertyChanged(BR.color)
        }

    val firstLetter: String
        @Bindable get() = _buyerName.first().toUpperCase().toString()

    companion object Create {
        fun fromPurchase(purchase: Purchase): PurchaseUiModel {
            return PurchaseUiModel(
                purchase.id,
                purchase.buyer.name,
                purchase.shop.name,
                purchase.value,
                purchase.date
            )
        }
    }
}