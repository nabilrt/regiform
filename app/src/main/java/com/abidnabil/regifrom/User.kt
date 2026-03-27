package com.abidnabil.regifrom

import java.io.Serializable

data class User(
    val jobTitle: String,
    val fullName: String,
    val email: String,
    val phone: String,
    val password: String
): Serializable
