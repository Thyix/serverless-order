package com.heroesAndVillains.backend.api.graphql


import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include
import graphql.ExceptionWhileDataFetching
import graphql.ExecutionResult
import java.lang.reflect.InvocationTargetException

@JsonInclude(Include.NON_NULL)
data class GraphQLResponse(
    val data: Any? = null,
    val errors: List<graphql.GraphQLError>? = null,
    val extensions: Map<Any, Any>? = null
) : Response()

internal fun ExecutionResult.toGraphQLResponse(): GraphQLResponse {
    val filteredErrors = if (errors?.isNotEmpty() == true) errors else null
    val sanitizedErrors = sanitizeErrors(filteredErrors)
    val filteredExtensions = if (extensions?.isNotEmpty() == true) extensions else null
    return GraphQLResponse(getData(), sanitizedErrors, filteredExtensions)
}

fun sanitizeErrors(errorsToSanitize: List<graphql.GraphQLError>?) :  List<graphql.GraphQLError>?{
    return errorsToSanitize?.map{e: graphql.GraphQLError ->
        if (e.locations != null) {
            when (e) {
                is ExceptionWhileDataFetching -> com.heroesAndVillains.backend.api.graphql.GraphQLError(
                    (e.exception as InvocationTargetException).targetException.message,
                    e.locations,
                    e.errorType
                )
                else -> com.heroesAndVillains.backend.api.graphql.GraphQLError(e.message, e.locations, e.errorType)
            }
        } else {
            throw Exception(e.message)
        }
    }
}