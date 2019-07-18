package com.heroesAndVillains.backend.api.graphql.resolvers.queries

import com.heroesAndVillains.backend.service.hero.HeroService
import com.heroesAndVillains.backend.service.hero.HeroResponse

class HeroQuery(var heroService : HeroService) {

    fun heroes(): List<HeroResponse> {
        return this.heroService.findHeroes()
    }
}