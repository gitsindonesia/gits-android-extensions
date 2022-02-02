package id.gits.library.extensions

import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView

fun MaterialCardView.setCardBackgroundColorRes(@ColorRes color: Int) {
    setCardBackgroundColor(ContextCompat.getColor(this.context, color))
}

fun MaterialCardView.setStrokeColorRes(@ColorRes color: Int) {
    strokeColor = ContextCompat.getColor(this.context, color)
}