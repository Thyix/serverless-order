package com.heroesAndVillains.backend.service.hero

import com.heroesAndVillains.backend.domain.*
import com.heroesAndVillains.backend.domain.hero.Hero
import com.heroesAndVillains.backend.domain.hero.Human
import com.heroesAndVillains.backend.domain.hero.Robot
import com.heroesAndVillains.backend.domain.hero.SuperHuman
import java.lang.Exception


class HeroAssembler {
    fun assembleToExternal(hero: Hero): HeroResponse {
        return when(hero.javaClass.simpleName) {
            "Human" -> HumanResponse(
                id = hero.id,
                name = (hero as Human).name,
                realName = hero.realName,
                universe = hero.universe.toString(),
                type = hero.javaClass.name
            )
            "SuperHuman" -> SuperHumanResponse(
                id = hero.id,
                name = (hero as SuperHuman).name,
                realName = hero.realName,
                superPower = hero.superPower,
                universe = hero.universe.toString(),
                type = hero.javaClass.name
            )
            "Robot" -> RobotResponse(
                id = hero.id,
                name = (hero as Robot).name,
                universe = hero.universe.toString(),
                superPower = hero.superPower,
                type = hero.javaClass.name
            )
            else -> throw Exception("${hero.javaClass.simpleName} is not supported")
        }
    }

    fun assembleToInternal(heroType: HeroResponse): Hero {
        return when(heroType.type) {
            "Human" -> Human(
                id = heroType.id,
                name = (heroType as HumanResponse).name,
                realName = heroType.realName,
                universe = ComicUniverse.valueOf(heroType.universe)
            )
            "SuperHuman" -> SuperHuman(
                id = heroType.id,
                name = (heroType as SuperHumanResponse).name,
                realName = heroType.realName,
                superPower = heroType.superPower,
                universe = ComicUniverse.valueOf(heroType.universe)
            )
            "Robot" -> Robot(
                id = heroType.id,
                name = (heroType as RobotResponse).name,
                superPower = heroType.superPower,
                universe = ComicUniverse.valueOf(heroType.universe)
            )
            else -> throw Exception("${heroType.type} is not supported")
        }
    }
}