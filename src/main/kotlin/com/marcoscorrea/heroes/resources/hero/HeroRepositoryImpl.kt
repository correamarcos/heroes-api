package com.marcoscorrea.heroes.resources.hero

import com.marcoscorrea.heroes.domain.hero.Hero
import com.marcoscorrea.heroes.domain.hero.HeroRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class HeroRepositoryImpl (
    @Autowired private val repository: HeroEntityRepository
) : HeroRepository {
    override fun getAll(): List<Hero> =
        repository.findAll().map { it.toHero() }

    override fun getHero(id: Long): Hero? =
        repository.findByIdOrNull(id)?.toHero()

    override fun create(request: Hero): Hero =
        repository.save(HeroEntity.from(request)).toHero();

    override fun update(request: Hero): Hero =
        repository.save(HeroEntity.from(request)).toHero();

    override fun delete(id: Long) =
        repository.deleteById(id)
}