package com.example.plugins

import java.math.BigDecimal

class TransactionRepository {

    fun insertTransaction(
        userId: Int,
        title: String,
        category: String,
        subCategory: String,
        txType: String,
        amount: BigDecimal,
        isoDate: String,
        description: String,
        location: String
    ) {
        DbHelper.update(
            sql = SqlBlueprints.INSERT_TRANSACTION,
            prepare = { ps ->
                ps.setInt(1, userId)
                ps.setString(2, title)
                ps.setString(3, category)
                ps.setString(4, subCategory)
                ps.setString(5, txType)
                ps.setBigDecimal(6, amount)
                ps.setString(7, isoDate)
                ps.setString(8, description)
                ps.setString(9, location)
            }
        )
    }
}