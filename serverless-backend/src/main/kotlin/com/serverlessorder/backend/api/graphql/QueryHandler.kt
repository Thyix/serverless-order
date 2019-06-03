package com.serverlessorder.backend.api.graphql

import com.serverlessorder.backend.api.graphql.GraphQLResponse
import graphql.ExecutionInput
import graphql.GraphQL
import reactor.core.publisher.Mono

class QueryHandler(private val graphql: GraphQL) {

    fun executeQuery(request: GraphQLRequest): Mono<GraphQLResponse> = Mono.subscriberContext()
        .flatMap {
            val input = ExecutionInput.newExecutionInput()
                .query(request.query)
                .operationName(request.operationName)
                .variables(request.variables)
                .build()
            Mono.fromFuture(graphql.executeAsync(input))
                .map { executionResult -> executionResult.toGraphQLResponse() }
        }
}