package com.serverlessorder.backend.api.graphql

import com.expedia.graphql.SchemaGeneratorConfig
import com.expedia.graphql.toSchema
import com.serverlessorder.backend.contexts.MutationsContext
import com.serverlessorder.backend.contexts.QueryContext
import graphql.schema.GraphQLSchema

class GraphQLSchemaGenerator {

    fun getSchema(): GraphQLSchema {
        val queryContext = QueryContext()
        val mutationContext = MutationsContext()

        val config = SchemaGeneratorConfig(
            supportedPackages = listOf("com.serverlessorder.backend"),
            dataFetcherFactoryProvider = DataFetcherFactoryProvider()
        )
        val queries = queryContext.getQueries()
        val mutations = mutationContext.getMutations()

        return toSchema(config, queries, mutations)
    }
}
