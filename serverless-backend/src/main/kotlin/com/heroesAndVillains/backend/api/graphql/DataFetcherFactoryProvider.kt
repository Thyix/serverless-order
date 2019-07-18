package com.heroesAndVillains.backend.api.graphql

import com.expedia.graphql.execution.KotlinDataFetcherFactoryProvider
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

class DataFetcherFactoryProvider : KotlinDataFetcherFactoryProvider(com.heroesAndVillains.backend.api.graphql.NoopSchemaGeneratorHooks()) {
    private val relatedDataFetcherFactory: com.heroesAndVillains.backend.api.graphql.RelatedDataFetcherFactory = com.heroesAndVillains.backend.api.graphql.RelatedDataFetcherFactory()

    override fun propertyDataFetcherFactory(
        kClass: KClass<*>,
        kProperty: KProperty<*>
    ): graphql.schema.DataFetcherFactory<Any> =
        if (kProperty.isLateinit) relatedDataFetcherFactory
        else super.propertyDataFetcherFactory(kClass, kProperty)
}
