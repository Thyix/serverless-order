package com.serverlessorder.backend.api.graphql.resolvers.queries

import com.serverlessorder.backend.service.OrderService
import com.serverlessorder.backend.service.OrderType

class OrderQuery(var orderService : OrderService) {

    fun orders(): List<OrderType> {
        return this.orderService.fetchOrders()
    }
}