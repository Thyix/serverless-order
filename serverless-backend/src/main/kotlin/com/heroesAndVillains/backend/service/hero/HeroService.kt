package com.heroesAndVillains.backend.service.hero

import com.heroesAndVillains.backend.domain.hero.HeroRepository

class HeroService(
    private val repository: HeroRepository,
    private val assembler: HeroAssembler
){
    fun findHeroes(): List<HeroResponse> {
       val heroes = repository.findHeroes()
       return heroes.map { this.assembler.assembleToExternal(it) }
    }
}