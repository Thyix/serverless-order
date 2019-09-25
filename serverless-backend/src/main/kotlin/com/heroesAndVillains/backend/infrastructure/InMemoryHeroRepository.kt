package com.heroesAndVillains.backend.infrastructure

import com.fasterxml.jackson.annotation.ObjectIdGenerators
import com.heroesAndVillains.backend.domain.*
import com.heroesAndVillains.backend.domain.hero.*
import java.util.*

object InMemoryHeroRepository : HeroRepository {
    private var heroes: List<Hero> = listOf(
        Human(id = UUID.randomUUID().toString(), name = "Iron Man", realName = "Tony Stark", universe = ComicUniverse.MARVEL),
        SuperHuman(id =UUID.randomUUID().toString(), name = "Superman", realName = "Clark Kent", superPower = "A lot", universe = ComicUniverse.DC),
        Robot(id = UUID.randomUUID().toString(), name= "Vision", superPower = "Phasing", universe = ComicUniverse.MARVEL)
    )

    override fun findById(id: String): Hero? = heroes.find { it.id == id }

    override fun findHeroes(): List<Hero> = heroes

    override fun add(hero: Hero): Hero{
        this.heroes  = this.heroes + hero

        return hero
    }
}