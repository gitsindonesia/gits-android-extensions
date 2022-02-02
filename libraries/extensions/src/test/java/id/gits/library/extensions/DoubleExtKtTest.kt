package id.gits.library.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class DoubleExtKtTest {

    @Test
    fun toRupiahCurrency() {
        val value = 100000.00
        assertEquals("Rp100.000", value.toRupiahCurrency())
    }
}