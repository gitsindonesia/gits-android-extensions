package id.gits.library.extensions

import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.core.content.ContextCompat

fun TextView.setTextColorRes(res: Int) {
    setTextColor(ContextCompat.getColor(context, res))
}

@Suppress("DEPRECATION")
fun TextView.setTextFromHtml(text: String?) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        setText(Html.fromHtml(text ?: "", Html.FROM_HTML_MODE_COMPACT))
    } else {
        setText(Html.fromHtml(text ?: ""))
    }
}