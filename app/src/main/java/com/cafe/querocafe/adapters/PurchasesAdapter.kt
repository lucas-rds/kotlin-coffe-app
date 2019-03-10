package com.cafe.querocafe.adapters

import android.graphics.PorterDuff
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cafe.querocafe.databinding.PurchaseItemBinding
import com.cafe.querocafe.model.Purchase
import com.cafe.querocafe.model.view.PurchaseUiModel

class PurchasesAdapter(private var purchases: List<PurchaseUiModel>, private val onItemClick: View.OnClickListener) :
    RecyclerView.Adapter<PurchasesViewHolder>(),
    BindableAdapter<List<PurchaseUiModel>?> {

    companion object {
        //"#BB6B24", "#964315", "#6A2B05", "#3E1404"
        @JvmStatic val possibleColors: List<Int> = listOf(-4494556, -6929643, -9819387, -12708860)
    }
    private var colorIndex = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PurchasesViewHolder {
        val binding = PurchaseItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PurchasesViewHolder(binding)
    }

    override fun getItemCount() = purchases.size

    override fun setData(data: List<PurchaseUiModel>?) {
        this.purchases = data ?: listOf()
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: PurchasesViewHolder, position: Int) {
        if (colorIndex >= possibleColors.size) colorIndex = 0
        purchases[position].color = possibleColors[colorIndex++]
        return holder.bind(purchases[position], onItemClick)
    }
}

class PurchasesViewHolder(private var binding: PurchaseItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(purchase: PurchaseUiModel, onItemClick: View.OnClickListener) {
        binding.model = purchase
        binding.letter.background.setColorFilter(purchase.color , PorterDuff.Mode.SRC_ATOP)
        itemView.setOnClickListener(onItemClick)
        binding.executePendingBindings()
    }

}