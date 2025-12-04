package com.example.projekakhir_019.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projekakhir_019.R
import com.example.projekakhir_019.data.Expense
import java.text.SimpleDateFormat
import java.util.*

class ExpenseAdapter(private val list: List<Expense>) :
    RecyclerView.Adapter<ExpenseAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtCategory: TextView = view.findViewById(R.id.txtCategory)
        val txtAmount: TextView = view.findViewById(R.id.txtAmount)
        val txtDate: TextView = view.findViewById(R.id.txtDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.txtCategory.text = item.category
        holder.txtAmount.text = "Rp ${item.amount}"

        val sdf = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
        holder.txtDate.text = sdf.format(Date(item.date))
    }

    override fun getItemCount() = list.size
}
