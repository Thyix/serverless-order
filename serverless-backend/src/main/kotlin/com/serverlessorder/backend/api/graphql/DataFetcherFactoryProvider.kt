package com.serverlessorder.backend.api.graphql

import com.expedia.graphql.execution.KotlinDataFetcherFactoryProvider
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class DataFetcherFactoryProvider : KotlinDataFetcherFactoryProvider(NoopSchemaGeneratorHooks()) {
    private val relatedDataFetcherFactory: RelatedDataFetcherFactory = RelatedDataFetcherFactory()

    override fun propertyDataFetcherFactory(
        kClass: KClass<*>,
        kProperty: KProperty<*>
    ): graphql.schema.DataFetcherFactory<Any> =
        if (kProperty.isLateinit) relatedDataFetcherFactory
        else super.propertyDataFetcherFactory(kClass, kProperty)
}
