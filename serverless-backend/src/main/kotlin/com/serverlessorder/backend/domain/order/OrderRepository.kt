package com.serverlessorder.backend.domain.order


interface OrderRepository {
    fun findOrders(): List<Order>
}