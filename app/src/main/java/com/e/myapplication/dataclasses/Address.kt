package com.e.myapplication.dataclasses

data class Address(
    val street:String,
    val suit: String,
    val city: String,
    val zipCode: String,
    val geo: Geo
) {
}