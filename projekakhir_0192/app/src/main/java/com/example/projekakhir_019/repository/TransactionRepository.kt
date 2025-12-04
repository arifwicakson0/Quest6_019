package com.example.projekakhir_019.repository

class TransactionRepository(private val dao: TransactionDao) {

    val transactions = dao.getAll()

    suspend fun add(transaction: TransactionEntity) {
        dao.insert(transaction)
    }
}
