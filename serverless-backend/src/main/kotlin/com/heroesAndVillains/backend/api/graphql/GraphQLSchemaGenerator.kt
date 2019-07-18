package com.heroesAndVillains.backend.api.graphql

import com.expedia.graphql.SchemaGeneratorConfig
import com.expedia.graphql.toSchema
import com.heroesAndVillains.backend.contexts.MutationsContext
import com.heroesAndVillains.backend.contexts.QueryContext
import graphql.schema.GraphQLSchema

class GraphQLSchemaGenerator {

    fun getSchema(): GraphQLSchema {
        val queryContext = QueryContext()
        val mutationContext = MutationsContext()

        val config = SchemaGeneratorConfig(
            supportedPackages = listOf("com.heroesAndVillains.backend"),
            dataFetcherFactoryProvider = com.heroesAndVillains.backend.api.graphql.DataFetcherFactoryProvider()
        )
        val queries = queryContext.getQueries()
        val mutations = mutationContext.getMutations()

        return toSchema(config, queries, mutations)
    }
}
