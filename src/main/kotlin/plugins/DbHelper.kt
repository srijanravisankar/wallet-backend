package com.example.plugins

import com.example.Database
import java.sql.PreparedStatement
import java.sql.ResultSet

object DbHelper {

    // Generic Query (returns a result)
    fun <T> query(
        sql: String,
        prepare: (PreparedStatement) -> Unit,
        map: (ResultSet) -> T
    ): T {
        Database.connect().use { connection ->
            connection.prepareStatement(sql).use { ps ->
                prepare(ps)
                ps.executeQuery().use { rs ->
                    return map(rs)
                }
            }
        }
    }

    // Generic Update (INSERT, UPDATE, DELETE without returning rows)
    fun update(
        sql: String,
        prepare: (PreparedStatement) -> Unit
    ) {
        Database.connect().use { connection ->
            connection.prepareStatement(sql).use { ps ->
                prepare(ps)
                ps.executeUpdate()
            }
        }
    }

    // Generic Batch Insert
    fun batch(
        sql: String,
        buildBatch: (PreparedStatement) -> Unit
    ) {
        Database.connect().use { connection ->
            connection.prepareStatement(sql).use { ps ->
                buildBatch(ps)
                ps.executeBatch()
            }
        }
    }
}