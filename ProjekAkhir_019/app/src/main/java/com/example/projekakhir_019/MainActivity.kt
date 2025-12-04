package com.example.projekakhir_019

package com.example.projekakhir_019

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.projekakhir_019.adapter.ExpenseAdapter
import com.example.projekakhir_019.data.AppDatabase
import com.example.projekakhir_019.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            startActivity(Intent(this, AddExpenseActivity::class.java))
        }

        loadData()
    }

    private fun loadData() {
        val db = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "expense_db"
        ).build()

        scope.launch {
            val data = withContext(Dispatchers.IO) {
                db.expenseDao().getAllExpenses()
            }

            binding.rvExpense.layoutManager = LinearLayoutManager(this@MainActivity)
            binding.rvExpense.adapter = ExpenseAdapter(data)
        }
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }
}
