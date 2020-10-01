package com.e.myapplication

import android.util.JsonReader
import com.e.myapplication.dataclasses.Address
import com.e.myapplication.dataclasses.Company
import com.e.myapplication.dataclasses.Geo
import com.e.myapplication.dataclasses.User
import com.squareup.moshi.JsonDataException


public fun parse(reader: JsonReader): List<User> {
    val result = mutableListOf<User>()

    reader.beginArray()
    while (reader.hasNext()) {
        var id: Long = -1L
        var name: String = ""
        var username: String = ""
        var email: String = ""
        var address: Address = Address()
        var phone: String = ""
        var website: String = ""
        var company: Company = Company()

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "id" -> id = reader.nextLong()
                "name" -> name = reader.nextString()
                "username" -> username = reader.nextString()
                "email" -> email = reader.nextString().toLowerCase()
                "address" -> address = getAddress(reader)
                "phone" -> phone = reader.nextString()
                "website" -> website = reader.nextString()
                "company" -> company = getCompany(reader)
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        if (id == -1L || name == "") {
            throw JsonDataException("Missing required field")
        }
        val person = User(id, name, username, email, address, phone, website, company)
        result.add(person)
    }
    reader.endArray()

    return result
}


fun getAddress(reader: JsonReader): Address {
    var street: String = ""
    var suite: String = ""
    var city: String = ""
    var zipcode: String = ""
    var geo: Geo = Geo()
    reader.beginObject()
    while (reader.hasNext()) {
        when (reader.nextName()) {
            "street" -> street = reader.nextString()
            "suite" -> suite = reader.nextString()
            "city" -> city = reader.nextString()
            "zipcode" -> zipcode = reader.nextString().toLowerCase()
            "geo" -> geo = getGeo(reader)
            else -> reader.skipValue()
        }
    }
    reader.endObject()
    return Address(street, suite, city, zipcode, geo)
}

fun getGeo(reader: JsonReader): Geo {

    var lat: String = ""
    var lng: String = ""
    reader.beginObject()
    while (reader.hasNext()) {
        when (reader.nextName()) {
            "lat" -> lat = reader.nextString()
            "lng" -> lng = reader.nextString()
            else -> reader.skipValue()
        }
    }
    reader.endObject()
    return Geo(lat, lng)
}

fun getCompany(reader: JsonReader): Company {
    var name: String = ""
    var catchPhrase: String = ""
    var bs: String = ""
    reader.beginObject()
    while (reader.hasNext()) {
        when (reader.nextName()) {
            "name" -> name = reader.nextString()
            "catchPhrase" -> catchPhrase = reader.nextString()
            "bs" -> bs = reader.nextString()
            else -> reader.skipValue()
        }
    }
    reader.endObject()
    return Company(name, catchPhrase, bs)
}


