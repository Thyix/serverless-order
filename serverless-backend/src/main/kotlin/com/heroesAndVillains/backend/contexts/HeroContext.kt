package com.heroesAndVillains.backend.contexts

import com.heroesAndVillains.backend.api.graphql.resolvers.mutations.AddHeroMutation
import com.heroesAndVillains.backend.api.graphql.resolvers.queries.HeroQuery
import com.heroesAndVillains.backend.api.graphql.resolvers.queries.HeroesQuery
import com.heroesAndVillains.backend.infrastructure.InMemoryHeroRepository
import com.heroesAndVillains.backend.service.hero.HeroAssembler
import com.heroesAndVillains.backend.service.hero.HeroService

class HeroContext {

    fun getHeroesQuery(): HeroesQuery {
        val repository = InMemoryHeroRepository
        val assembler = HeroAssembler()
        val service = HeroService(repository, assembler)

        return HeroesQuery(service)
    }

    fun getHeroQuery(): HeroQuery {
        val repository = InMemoryHeroRepository
        val assembler = HeroAssembler()
        val service = HeroService(repository, assembler)

        return HeroQuery(service)
    }

    fun getAddHeroMutation(): AddHeroMutation {
        val repository = InMemoryHeroRepository
        val assembler = HeroAssembler()
        val service = HeroService(repository, assembler)

        return AddHeroMutation(service)
    }
}