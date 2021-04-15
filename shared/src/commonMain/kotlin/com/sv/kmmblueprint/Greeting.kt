package com.sv.kmmblueprint

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}