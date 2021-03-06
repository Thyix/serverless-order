package com.heroesAndVillains.backend.api.graphql.resolvers.queries

import com.heroesAndVillains.backend.service.hero.HeroService
import com.heroesAndVillains.backend.service.hero.HeroResponse

class HeroQuery(var heroService : HeroService) {

    fun hero(id: String): HeroResponse {
        return this.heroService.findHero(id)
    }
}