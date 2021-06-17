package com.sv.kmmblueprint.db

import com.squareup.sqldelight.db.SqlDriver

expect object DriverFactory {
    fun create(): SqlDriver
}