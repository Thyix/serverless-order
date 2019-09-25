package com.heroesAndVillains.backend.service.hero

import com.expedia.graphql.annotations.GraphQLDescription
import com.heroesAndVillains.backend.domain.ComicUniverse

data class HeroInput(
    val type: String,
    @GraphQLDescription("Name of the hero")
    val name: String,
    @GraphQLDescription("Name of the publisher owning the rights to this character")
    val universe: ComicUniverse,
    val superPower:String,
    val realName: String
)