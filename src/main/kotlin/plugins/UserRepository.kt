package com.example.plugins

import java.sql.ResultSet

class UserRepository {

    fun createUser(first: String, last: String, email: String, hashedPassword: String): Int {
        return DbHelper.query(
            sql = SqlBlueprints.INSERT_USER,
            prepare = { ps ->
                ps.setString(1, first)
                ps.setString(2, last)
                ps.setString(3, email)
                ps.setString(4, hashedPassword)
            },
            map = { rs ->
                rs.next()
                rs.getInt("user_id")
            }
        )
    }
}