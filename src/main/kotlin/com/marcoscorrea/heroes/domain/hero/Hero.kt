package com.marcoscorrea.heroes.domain.hero

data class Hero(
    val id: Long? = null,
    val nick: String,
    val person: String,
    val description: String?,
    val history: String?
)
