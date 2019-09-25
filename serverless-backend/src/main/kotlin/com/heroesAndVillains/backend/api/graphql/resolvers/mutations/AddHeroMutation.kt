package com.heroesAndVillains.backend.api.graphql.resolvers.mutations

import com.heroesAndVillains.backend.service.hero.HeroInput
import com.heroesAndVillains.backend.service.hero.HeroResponse
import com.heroesAndVillains.backend.service.hero.HeroService

class AddHeroMutation(val heroService: HeroService) {
    fun addHeroMutation(heroInput: HeroInput): HeroResponse{
       return this.heroService.addHero(heroInput)
    }
}