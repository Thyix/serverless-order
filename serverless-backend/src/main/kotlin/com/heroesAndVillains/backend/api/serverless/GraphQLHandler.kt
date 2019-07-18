package com.heroesAndVillains.backend.api.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.heroesAndVillains.backend.api.graphql.ApiGatewayResponse
import com.heroesAndVillains.backend.api.graphql.GraphQLEndpoint
import com.heroesAndVillains.backend.api.graphql.GraphQLRequest


class GraphQLHandler : RequestHandler<Map<String, Any>, com.heroesAndVillains.backend.api.graphql.ApiGatewayResponse> {

    override fun handleRequest(input: Map<String, Any>, context: Context): com.heroesAndVillains.backend.api.graphql.ApiGatewayResponse {
        val objectMapper = ObjectMapper()
        val request: com.heroesAndVillains.backend.api.graphql.GraphQLRequest = objectMapper.readValue(input["body"] as String)

        val result = com.heroesAndVillains.backend.api.graphql.GraphQLEndpoint().execute(request)

        return com.heroesAndVillains.backend.api.graphql.ApiGatewayResponse.build {
            statusCode = 200
            objectBody = result
            headers = mapOf("Access-Control-Allow-Origin" to "*")
        }
    }
}
