package com.e.myapplication

import android.util.JsonReader
import com.e.myapplication.dataclasses.User
import com.squareup.moshi.JsonDataException
import java.io.StringReader


public fun parse(reader: JsonReader): List<User> {
    val result = mutableListOf<User>()

    reader.beginArray()
    while (reader.hasNext()) {
        var id: Long = -1L
        var name: String = ""
        var username: String = ""
        var email: String = ""

        reader.beginObject()
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "id" -> id = reader.nextLong()
                "name" -> name = reader.nextString()
                "username" -> username = reader.nextString()
                "email" -> email = reader.nextString()
                else -> reader.skipValue()
            }
        }
        reader.endObject()

        if (id == -1L || name == "") {
            throw JsonDataException("Missing required field")
        }
        val person = User(id, name, username, email)
        result.add(person)
    }
    reader.endArray()

    return result
}

