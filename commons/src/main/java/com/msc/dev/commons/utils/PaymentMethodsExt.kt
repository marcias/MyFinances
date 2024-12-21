package com.msc.dev.commons.utils

import com.msc.dev.commons.Cash
import com.msc.dev.commons.CreditCard
import com.msc.dev.commons.DebtCard
import com.msc.dev.commons.PaymentMethod

fun PaymentMethod.getName(): String {
    val paymentMethod = this
    return when (paymentMethod) {
        is CreditCard -> {
            "Crédito ${paymentMethod.cardName}"
        }

        is Cash -> {
            "Dinheiro"
        }

        is DebtCard -> {
            "Débito ${paymentMethod.bank}"
        }

        else -> {
            "Desconhecido"
        }
    }
}