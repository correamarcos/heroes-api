package com.marcoscorrea.heroes.resources.hero

import com.marcoscorrea.heroes.domain.hero.Hero
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "hero")
data class HeroEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(nullable = false)
    val nick: String,
    @Column(nullable = false)
    val person: String,
    val description: String?,
    val history: String?
){
    fun toHero() = Hero(id, nick, person, description, history)

    companion object{
        fun from(hero: Hero) = HeroEntity(
            id = hero.id,
            nick = hero.nick,
            person = hero.person,
            description = hero.description,
            history = hero.history
        )
    }
}
