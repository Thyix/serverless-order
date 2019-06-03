package com.serverlessorder.backend.api.serverless

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.serverlessorder.backend.api.graphql.ApiGatewayResponse
import com.serverlessorder.backend.api.graphql.GraphQLEndpoint
import com.serverlessorder.backend.api.graphql.GraphQLRequest


class GraphQLHandler : RequestHandler<Map<String, Any>, ApiGatewayResponse> {

    override fun handleRequest(input: Map<String, Any>, context: Context): ApiGatewayResponse {
        val objectMapper = ObjectMapper()
        val request: GraphQLRequest = objectMapper.readValue(input["body"] as String)

        val result = GraphQLEndpoint().execute(request)

        return ApiGatewayResponse.build {
            statusCode = 200
            objectBody = result
            headers = mapOf("Access-Control-Allow-Origin" to "*")
        }
    }
}
