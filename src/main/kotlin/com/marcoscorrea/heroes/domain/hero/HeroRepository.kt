package com.marcoscorrea.heroes.domain.hero

interface HeroRepository {
    fun getAll(): List<Hero>
    fun getHero(id: Long): Hero ?
    fun create(request: Hero): Hero
    fun update(request: Hero): Hero
    fun delete(id: Long)
}