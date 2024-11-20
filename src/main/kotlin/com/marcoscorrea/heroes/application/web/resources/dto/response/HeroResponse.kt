package com.marcoscorrea.heroes.application.web.resources.dto.response

import com.marcoscorrea.heroes.domain.hero.Hero

data class HeroResponse(
    val id: Long?,
    val nick: String,
    val person: String,
    val description: String?,
    val history: String?
) {
    companion object {
        fun from(hero: Hero) = HeroResponse(
            id = hero.id,
            nick = hero.nick,
            person = hero.person,
            description = hero.description,
            history = hero.history
        )
    }
}
