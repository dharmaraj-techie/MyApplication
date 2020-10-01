package com.e.myapplication.dataclasses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.net.Inet4Address
@Parcelize
data class User(
    val id: Long,
    val name: String,
    val username: String,
    val email: String,
//    val address: Address,
//    val phone: String,
//    val website: String,
//    val company: Company
    ): Parcelable {
}