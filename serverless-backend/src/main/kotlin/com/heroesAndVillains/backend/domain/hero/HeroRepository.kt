package com.heroesAndVillains.backend.domain.hero

interface HeroRepository {
    fun findById(id: String): Hero?
    fun findHeroes(): List<Hero>
    fun add(hero: Hero): Hero
}