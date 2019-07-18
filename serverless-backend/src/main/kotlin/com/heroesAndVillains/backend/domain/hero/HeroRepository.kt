package com.heroesAndVillains.backend.domain.hero

interface HeroRepository {
    fun findById(id: Long): Hero?
    fun findHeroes(): List<Hero>
    fun add(hero: Hero)
}