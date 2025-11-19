package com.example.plugins

object SqlBlueprints {

    // ========= USERS =========
    const val INSERT_USER = """
        INSERT INTO users (first_name, last_name, email, password)
        VALUES (?, ?, ?, ?)
        RETURNING user_id
    """

    const val FIND_USER_BY_EMAIL = """
        SELECT user_id, first_name, last_name, email, password, created_at, updated_at
        FROM users
        WHERE email = ?
    """

    // ========= TRANSACTIONS =========
    const val INSERT_TRANSACTION = """
        INSERT INTO transactions (
            user_id,
            title,
            category,
            sub_category,
            transaction_type,
            amount,
            date,
            description,
            location
        )
        VALUES (?, ?, ?, ?, ?::transaction_type, ?, ?::timestamp with time zone, ?, ?)
    """

    // ========= BUDGETS =========
    const val INSERT_BUDGET = """
        INSERT INTO budgets (
            user_id,
            category,
            sub_category,
            budget_limit,
            period_type,
            start_date,
            end_date,
            description
        )
        VALUES (?, ?, ?, ?, ?::period_type, ?::date, ?::date, ?)
    """
}