package com.heroesAndVillains.backend.api.graphql.resolvers.queries

import com.heroesAndVillains.backend.service.hero.HeroService
import com.heroesAndVillains.backend.service.hero.HeroResponse

class HeroesQuery(var heroService : HeroService) {

    fun heroes(): List<HeroResponse> {
        return this.heroService.findHeroes()
    }
}