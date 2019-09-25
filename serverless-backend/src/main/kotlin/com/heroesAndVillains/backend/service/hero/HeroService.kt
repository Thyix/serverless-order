package com.heroesAndVillains.backend.service.hero

import com.heroesAndVillains.backend.domain.hero.HeroRepository
import com.heroesAndVillains.backend.domain.hero.Human
import com.heroesAndVillains.backend.domain.hero.Robot
import com.heroesAndVillains.backend.domain.hero.SuperHuman
import java.lang.Exception
import java.util.*

class HeroService(
    private val repository: HeroRepository,
    private val assembler: HeroAssembler
){
    fun findHeroes(): List<HeroResponse> {
       val heroes = repository.findHeroes()
       return heroes.map { this.assembler.assembleToExternal(it) }
    }

    fun findHero(id:String): HeroResponse {
        val hero = repository.findById(id)
        return this.assembler.assembleToExternal(hero!!)
    }

    fun addHero(heroInput: HeroInput): HeroResponse {
        val heroResponse =  when(heroInput.type) {
            "Human" -> HumanResponse(
                id = UUID.randomUUID().toString(),
                name = heroInput.name,
                realName = heroInput.realName,
                universe = heroInput.universe,
                type = heroInput.type
            )
            "SuperHuman" -> SuperHumanResponse(
                id = UUID.randomUUID().toString(),
                name = heroInput.name,
                realName = heroInput.realName,
                superPower = heroInput.superPower,
                universe = heroInput.universe,
                type = heroInput.type
            )
            "Robot" -> RobotResponse(
                id = UUID.randomUUID().toString(),
                name = heroInput.name,
                universe = heroInput.universe,
                superPower = heroInput.superPower,
                type = heroInput.type
            )
            else -> throw Exception("${heroInput.type} is not supported")
        }
        return assembler.assembleToExternal(repository.add(this.assembler.assembleToInternal((heroResponse))))
    }
}