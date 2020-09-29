package com.e.myapplication.dataclasses

import java.net.Inet4Address

data class User(
    val id: Int,
    val name: String,
    val userName: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
    ) {
}