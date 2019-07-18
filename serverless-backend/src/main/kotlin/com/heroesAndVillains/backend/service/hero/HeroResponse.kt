package com.heroesAndVillains.backend.service.hero

interface HeroResponse {
    val id: Long
    val type: String
    val name: String
    val universe: String
}