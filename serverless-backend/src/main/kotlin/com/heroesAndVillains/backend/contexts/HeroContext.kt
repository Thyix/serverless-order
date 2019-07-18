package com.heroesAndVillains.backend.contexts

import com.heroesAndVillains.backend.api.graphql.resolvers.queries.HeroQuery
import com.heroesAndVillains.backend.infrastructure.InMemoryHeroRepository
import com.heroesAndVillains.backend.service.hero.HeroAssembler
import com.heroesAndVillains.backend.service.hero.HeroService

class HeroContext {

    fun getHeroesQuery(): HeroQuery {
        val repository = InMemoryHeroRepository
        val assembler = HeroAssembler()
        val service = HeroService(repository, assembler)

        return HeroQuery(service)
    }
}