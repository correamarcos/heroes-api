package com.marcoscorrea.heroes.application.web.resources.dto.request

import com.marcoscorrea.heroes.domain.hero.Hero
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class HeroRequest(
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val nick: String,
    @field:NotNull
    @field:NotBlank
    @field:NotEmpty
    val person: String,
    val description: String? = null,
    val history: String? = null
) {
    fun toHero(id: Long? = null) = Hero(
        id = id,
        nick = nick,
        person = person,
        description = description,
        history = history
    )

    companion object {
        fun to(id: Long, hero: HeroRequest) = Hero(
            id = id,
            nick = hero.nick,
            person = hero.person,
            description = hero.description,
            history = hero.history
        )
    }
}
