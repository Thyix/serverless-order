package com.heroesAndVillains.backend.api.graphql

import graphql.GraphQL
import java.lang.Exception

class GraphQLEndpoint {
    fun execute(request: com.heroesAndVillains.backend.api.graphql.GraphQLRequest) : com.heroesAndVillains.backend.api.graphql.GraphQLResponse? {
        try{
            val schema = GraphQLSchemaGenerator().getSchema()
            val queryHandler = QueryHandler(GraphQL.newGraphQL(schema).build())
            return queryHandler.executeQuery(request).block()
        }catch(e: Exception){
            println(e.toString())
            throw e
        }
    }
}