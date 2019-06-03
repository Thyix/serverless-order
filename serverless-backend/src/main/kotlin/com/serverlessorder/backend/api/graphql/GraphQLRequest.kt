package com.serverlessorder.backend.api.graphql

data class GraphQLRequest(val query: String, val operationName: String?, val variables: Map<String, Any>?) {
    //Jackson constructor
    constructor() : this("", null, null)
}
