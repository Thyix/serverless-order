package com.heroesAndVillains.backend.api.graphql

import com.expedia.graphql.extensions.deepName
import graphql.schema.DataFetcher
import graphql.schema.DataFetcherFactory
import graphql.schema.DataFetcherFactoryEnvironment

class RelatedDataFetcherFactory : DataFetcherFactory<Any> {
    private lateinit var dataFetchers: HashMap<String, DataFetcher<Any>>

    init {
        initializeDataFetchers()
    }

    private fun initializeDataFetchers() {
        this.dataFetchers = hashMapOf()
    }

    override fun get(environment: DataFetcherFactoryEnvironment?): DataFetcher<Any>? {
        val fieldType = environment?.fieldDefinition?.type?.deepName ?: return null
        val graphType = "^\\[?([a-zA-Z0-9]*)(?:Type|Interface)!?\\]?!?\$"
            .toRegex()
            .find(fieldType)
            ?.groupValues
            ?.get(1)

        return dataFetchers[graphType]
    }
}
