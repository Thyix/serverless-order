package com.serverlessorder.backend.api.rest

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.serverlessorder.backend.api.graphql.GraphQLEndpoint
import com.serverlessorder.backend.api.graphql.GraphQLRequest
import spark.Spark.*

fun main() {
    staticFiles.location("/public")

    options("/*") { _, response ->
        response.header("Access-Control-Allow-Methods", "POST,OPTIONS")
        response.header("Access-Control-Allow-Origin", "*")
        response.header(
                "Access-Control-Allow-Headers",
                "Content-Type,X-Amz-Date,Authorization,X-Api-Key,X-Amz-Security-Token,X-Amz-User-Agent"
        )
        response.header("Access-Control-Allow-Credentials", "true")
        "OK"
    }

    post("/graphql") { req, res ->
        val objectMapper = ObjectMapper()
        val request: GraphQLRequest = objectMapper.readValue(req.body())
        val result = GraphQLEndpoint().execute(request)
        res.header("Content-Type", "application/json")
        res.header("Access-Control-Allow-Origin", "*")
        res.status(200)
        objectMapper.writeValueAsString(result)
    }
}