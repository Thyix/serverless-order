package com.serverlessorder.backend.infrastructure

import com.serverlessorder.backend.domain.order.Order
import com.serverlessorder.backend.domain.order.OrderRepository

object InMemoryOrderRepository : OrderRepository {
    private var orders: List<Order> = listOf(
            Order(
                   number = "aaa-0001"
            )
    )
    override fun findOrders(): List<Order> {
        return orders
    }
}