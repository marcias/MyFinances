package com.msc.dev.commons

import java.util.Date

data class Spending(
    val description: String,
    val value: Long,
    val paymentMethod: PaymentMethod,
    val totalInstallments: Int = 0,
    val installment: Installment? = null,
    val date: Date,
    val category: Category,
    val subcategory: Subcategory? = null,
    val fixedSpending: Boolean = false,
    val dayOfPayment: Int? = null,
    val isPayed: Boolean = true,
)
