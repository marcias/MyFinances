package com.msc.dev.myfinancesproject.spending

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.msc.dev.commons.Category
import com.msc.dev.commons.PaymentMethod
import com.msc.dev.commons.Spending
import com.msc.dev.commons.Subcategory
import com.msc.dev.commons.theme.PrimaryButton
import com.msc.dev.commons.theme.TransparentButton
import com.msc.dev.commons.utils.getName

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddSpendingContent(
    fixedSpending: Spending?  = null,
    defaultPaymentMethod: PaymentMethod,
    paymentMethodList: List<PaymentMethod> = emptyList(),
    categoryList: List<Category> = emptyList(),
    subcategoryList: List<Subcategory> = emptyList(),
    showSelectFixedExpensesList: Boolean = false,
    onBackButtonPressed: () -> Unit = {},
    onSelectedCategory: (category: Category) -> Unit = {},
    onFixedExpensePressed: () -> Unit = {},
    onSaveButtonPressed: (value: Long, description: String, selectedPaymentMethod: PaymentMethod, category: Category, subcategory: Subcategory?) -> Unit = { _, _, _, _, _ -> },
    selectFixedExpensesContent: @Composable () -> Unit
) {

    var description = remember { "" }
    var valueStr = remember { "" }
    var selectedPaymentMethod = remember { defaultPaymentMethod }
    var selectedCategory: Category? = remember { null }
    var selectedSubcategory: Subcategory? = remember { null }
    var expandedPaymentMethod = remember { false }
    var expandedCategoryMenu = remember { false }
    var expandedSubcategoryMenu = remember { false }
    var isSaveButtonEnabled = remember { false }
    var showSelectDialog = remember { false }

    LaunchedEffect(showSelectFixedExpensesList) { showSelectDialog = showSelectFixedExpensesList }

    LaunchedEffect(fixedSpending) {
        if(fixedSpending!=null) {
            description = fixedSpending.description
            valueStr = fixedSpending.value.toString()
            selectedPaymentMethod = fixedSpending.paymentMethod
            selectedCategory = fixedSpending.category
            selectedSubcategory = fixedSpending.subcategory
        }
    }

    Scaffold {
        Column {
            if (showSelectDialog) {
                selectFixedExpensesContent.invoke()
            }

            TextField(
                value = description,
                onValueChange = { description += it },
                placeholder = { Text(text = "Descrição") },
                maxLines = 1
            )

            TextField(
                value = valueStr,
                onValueChange = { valueStr += it },
                placeholder = { Text(text = "Valor do gasto") },
                maxLines = 1
            )
        }

        DropdownMenu(
            expanded = expandedPaymentMethod,
            onDismissRequest = { expandedPaymentMethod = false }) {
            paymentMethodList.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(text = item.getName())
                    },
                    onClick = {
                        selectedPaymentMethod = item
                        expandedPaymentMethod = false
                    })
            }
        }

        DropdownMenu(
            expanded = expandedCategoryMenu,
            onDismissRequest = { expandedCategoryMenu = false }) {
            categoryList.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(text = item.name)
                    },
                    onClick = {
                        selectedCategory = item
                        expandedCategoryMenu = false
                        onSelectedCategory.invoke(item)
                    })
            }
        }

        DropdownMenu(
            expanded = expandedCategoryMenu,
            onDismissRequest = { expandedCategoryMenu = false }) {
            categoryList.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(text = item.name)
                    },
                    onClick = {
                        selectedCategory = item
                        expandedCategoryMenu = false
                    })
            }
        }

        if (subcategoryList.isNotEmpty()) {
            DropdownMenu(
                expanded = expandedSubcategoryMenu,
                onDismissRequest = { expandedSubcategoryMenu = false }) {
                subcategoryList.forEach { item ->
                    DropdownMenuItem(
                        text = {
                            Text(text = item.name)
                        },
                        onClick = {
                            selectedSubcategory = item
                            expandedCategoryMenu = false
                        })
                }
            }
        }
        TransparentButton("Gasto Fixo", isEnabled = true) { onFixedExpensePressed.invoke() }

        PrimaryButton(
            "Salvar Gasto",
            isEnabled = isSaveButtonEnabled
        ) {
            onSaveButtonPressed.invoke(
                valueStr.toLong(),
                description,
                selectedPaymentMethod,
                selectedCategory!!,
                selectedSubcategory
            )
        }

    }
}