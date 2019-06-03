package com.serverlessorder.backend.api.graphql

import graphql.ErrorType
import graphql.GraphQLError
import graphql.language.SourceLocation

class GraphQLError(
        private val message: String?,
        private val locations :MutableList<SourceLocation>,
        private val errorType: ErrorType
) : GraphQLError {
    override fun getLocations(): MutableList<SourceLocation> {
        return this.locations
    }

    override fun getErrorType(): ErrorType {
        return this.errorType
    }

    override fun getMessage(): String {
        return this.message ?: ""
    }
}