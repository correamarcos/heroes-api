package com.marcoscorrea.heroes.application.web.resources

import com.marcoscorrea.heroes.application.web.resources.dto.request.HeroRequest
import com.marcoscorrea.heroes.application.web.resources.dto.response.HeroResponse
import com.marcoscorrea.heroes.domain.hero.HeroRepository
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

private const val API_PATH = "/v1/api/heroes";

@RestController
@RequestMapping(API_PATH)
class HeroesController (
    @Autowired private val repository: HeroRepository
) {

    @GetMapping
    fun getHeroes(): ResponseEntity<List<HeroResponse>> =
        repository.getAll()
            .map(HeroResponse::from)
            .let { ResponseEntity.ok(it) }

    @GetMapping("/{id}")
    fun getDetails(@PathVariable("id") id:Long): ResponseEntity<HeroResponse> =
        repository.getHero(id)
            ?.let { ResponseEntity.ok(HeroResponse.from(it)) }
            ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createHero(@Valid @RequestBody request: HeroRequest): ResponseEntity<HeroResponse> =
        repository.create(request.toHero())
            .let { ResponseEntity.created(URI.create("/heroes/${it.id}")).body(HeroResponse.from(it)) }

    @PutMapping("/{id}")
    fun updateHero(@PathVariable("id") id: Long, @Valid @RequestBody request: HeroRequest): ResponseEntity<HeroResponse> =
        repository.getHero(id)
            ?.let {
                repository.update(request.toHero(id))
                ResponseEntity.ok(HeroResponse.from(it)) }
            ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteHero(@PathVariable("id") id: Long): ResponseEntity<Void> =
        repository.getHero(id)
            ?.let {
                repository.delete(id)
                ResponseEntity.accepted().build() }
            ?: ResponseEntity.notFound().build()
}