package com.serverlessorder.backend.service

import com.serverlessorder.backend.domain.order.OrderRepository

class OrderService(
    private val repository: OrderRepository,
    private val assembler: OrderAssembler
){
    fun fetchOrders(): List<OrderType> {
       val orders = repository.findOrders()
       return orders.map { order -> this.assembler.assembleToExternal(order) }
    }
}