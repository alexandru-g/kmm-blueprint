package com.sv.kmmblueprint.db

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual object DriverFactory {

    actual fun create(): SqlDriver =
        NativeSqliteDriver(Database.Schema, "db.db")
}