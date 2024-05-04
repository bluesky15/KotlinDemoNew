package com.example.testapp

fun main() {
    println("make me happy".happy())
}


//extension function
fun String.happy(): String {
    val emoji = "\uD83D\uDE0A"
    return "$this $emoji"
}