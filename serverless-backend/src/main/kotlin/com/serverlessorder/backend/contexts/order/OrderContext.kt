package com.serverlessorder.backend.contexts.order

import com.serverlessorder.backend.api.graphql.resolvers.queries.OrderQuery
import com.serverlessorder.backend.infrastructure.InMemoryOrderRepository
import com.serverlessorder.backend.service.OrderAssembler
import com.serverlessorder.backend.service.OrderService

class OrderContext {
    fun getOrderQuery(): OrderQuery {
        val orderRepository = InMemoryOrderRepository
        val assembler = OrderAssembler()
        val service = OrderService(repository = orderRepository, assembler = assembler)

        return OrderQuery(service)
    }
}