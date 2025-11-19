package com.example.plugins

import java.math.BigDecimal
import java.time.LocalDate

class BudgetRepository {

    fun insertBudget(
        userId: Int,
        category: String,
        subCategory: String,
        limit: BigDecimal,
        periodType: String,
        start: LocalDate,
        end: LocalDate,
        description: String
    ) {
        DbHelper.update(
            sql = SqlBlueprints.INSERT_BUDGET,
            prepare = { ps ->
                ps.setInt(1, userId)
                ps.setString(2, category)
                ps.setString(3, subCategory)
                ps.setBigDecimal(4, limit)
                ps.setString(5, periodType)
                ps.setString(6, start.toString())
                ps.setString(7, end.toString())
                ps.setString(8, description)
            }
        )
    }
}