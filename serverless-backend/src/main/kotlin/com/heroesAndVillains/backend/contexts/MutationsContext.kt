package com.heroesAndVillains.backend.contexts

import com.expedia.graphql.TopLevelObject

class MutationsContext {
    fun getMutations(): List<TopLevelObject> {
        val heroContext = HeroContext()
        return listOf(
            TopLevelObject(heroContext.getAddHeroMutation())
        )
    }
}