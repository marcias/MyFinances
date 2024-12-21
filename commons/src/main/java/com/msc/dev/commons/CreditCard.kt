package com.msc.dev.commons

import java.util.Date

data class CreditCard(
    val cardName: String,
    val limit: Long,
    val paymentDate: Date,
    val closingDate: Date
) : PaymentMethod()
