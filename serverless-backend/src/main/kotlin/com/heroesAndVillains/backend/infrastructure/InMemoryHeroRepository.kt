package com.heroesAndVillains.backend.infrastructure

import com.heroesAndVillains.backend.domain.*
import com.heroesAndVillains.backend.domain.hero.Hero
import com.heroesAndVillains.backend.domain.hero.HeroRepository
import com.heroesAndVillains.backend.domain.hero.Human
import com.heroesAndVillains.backend.domain.hero.SuperHuman

object InMemoryHeroRepository : HeroRepository {
    private var heroes: List<Hero> = listOf(
        Human(id = 1, name = "Iron Man", realName = "Tony Stark", universe = ComicUniverse.MARVEL),
        SuperHuman(id = 2, name = "Superman", realName = "Clark Kent", superPower = "A lot", universe = ComicUniverse.DC)
    )

    override fun findById(id: Long): Hero? = heroes.find { it.id == id }

    override fun findHeroes(): List<Hero> = heroes

    override fun add(hero: Hero){
        this.heroes  = this.heroes + hero
    }
}