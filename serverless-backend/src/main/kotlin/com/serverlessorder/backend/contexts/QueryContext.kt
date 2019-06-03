package com.serverlessorder.backend.contexts

import com.expedia.graphql.TopLevelObject
import com.serverlessorder.backend.contexts.order.OrderContext

class QueryContext {
    fun getQueries(): List<TopLevelObject> {
        val orderContext = OrderContext()
        return listOf(
            TopLevelObject(orderContext.getOrderQuery())
        )
    }
}