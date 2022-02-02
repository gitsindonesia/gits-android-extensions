package id.gits.library.extensions

import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.util.PatternsCompat
import java.util.*

fun String?.isEmailValid(): Boolean {
    return PatternsCompat.EMAIL_ADDRESS.matcher(this ?: "").matches()
}

fun String?.isNumber(): Boolean {
    val value = this?.toBigIntegerOrNull()
    return value != null
}

fun String?.isPhoneNumberValid(): Boolean = this?.length in 9..13

fun String.hasSymbol(): Boolean {
    return !this.matches("[A-Za-z0-9 ]*".toRegex())
}

fun String.hasUpperCase(): Boolean {
    return this != this.lowercase()
}

fun String.hasLowerCase(): Boolean {
    return this != this.uppercase()
}

fun String.capitalize(
    locale: Locale = Locale.getDefault()
): String {
    return replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(locale)
        else it.toString()
    }
}

fun String?.toSpanned(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this ?: "", Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(this ?: "")
    }
}

fun String.toFormattedPhoneNumber(countryCode: String? = "+62"): String {
    if (length < 2) {
        return this
    }

    return when {
        first() == '0' -> {
            "$countryCode${this.substring(1, this.length)}"
        }
        take(2) == countryCode?.replace("+", "") -> {
            "+$this"
        }
        else -> {
            this
        }
    }
}