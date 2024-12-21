package com.msc.dev.commons

data class Incoming(
    val id: String,
    val description: String,
    val plannedValue: Long,
    val dayOfPayment: Int? = null,
    val isPayed: Boolean = false
)