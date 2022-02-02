package id.gits.library.extensions

import android.text.format.DateUtils
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

private const val TAG = "DateExt"

fun Date.toFormattedString(outputPattern: String? = "dd MMM yyyy"): String {
    val outputDateFormatter = SimpleDateFormat(outputPattern, Locale.getDefault())

    return try {
        outputDateFormatter.format(this)
    } catch (e: Exception) {
        Log.e(TAG, e.message.orEmpty())
        this.toString()
    }
}

fun Date.getRelativeTimeSpanString(): String {
    return DateUtils.getRelativeTimeSpanString(
        time,
        Calendar.getInstance().timeInMillis,
        DateUtils.MINUTE_IN_MILLIS
    ).toString()
}