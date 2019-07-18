package com.heroesAndVillains.backend.contexts

import com.expedia.graphql.TopLevelObject

class QueryContext {
    fun getQueries(): List<TopLevelObject> {
        val heroContext = HeroContext()
        return listOf(
            TopLevelObject(heroContext.getHeroesQuery())
        )
    }
}