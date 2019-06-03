package com.serverlessorder.backend.service

import com.serverlessorder.backend.domain.order.Order


class OrderAssembler {
    fun assembleToExternal(order: Order): OrderType {
        return OrderType(order.number)
    }

    fun assembleToInternal(orderType: OrderType): Order {
        return Order(orderType.number)
    }
}