package id.gits.library.extensions

import android.content.res.ColorStateList
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

fun MaterialButton.setBackgroundTintRes(@ColorRes color: Int) {
    backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(this.context, color))
}

fun MaterialButton.setTextColorRes(@ColorRes color: Int) {
    setTextColor(ContextCompat.getColor(this.context, color))
}