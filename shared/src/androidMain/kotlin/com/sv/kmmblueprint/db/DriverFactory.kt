package com.sv.kmmblueprint.db

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual object DriverFactory {

    lateinit var context: Context

    actual fun create(): SqlDriver =
        AndroidSqliteDriver(Database.Schema, context, "db.db")
}