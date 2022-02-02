package id.gits.library.extensions

import java.text.NumberFormat
import java.util.*

fun Double.toRupiahCurrency(): String {
    return NumberFormat
        .getCurrencyInstance(Locale("in", "ID")).apply {
            maximumFractionDigits = 0
        }
        .format(this)
}