package com.heroesAndVillains.backend.service.hero

import com.expedia.graphql.annotations.GraphQLDescription
import com.heroesAndVillains.backend.domain.ComicUniverse

interface HeroResponse {
    val id: String
    val type: String
    @GraphQLDescription("Name of the hero")
    val name: String
    @GraphQLDescription("Name of the publisher owning the rights to this character")
    val universe: ComicUniverse
}