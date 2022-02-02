package id.gits.library.extensions

import org.junit.Assert.assertEquals
import org.junit.Test

class StringExtKtTest {

    @Test
    fun testCapitalize() {
        assertEquals("Gits", "gits".capitalize())
    }

    @Test
    fun testIsEmailValid() {
        assertEquals(true, "info@gits.id".isEmailValid())
        assertEquals(false, "info@gitsid".isEmailValid())
    }

    @Test
    fun testIsNumber() {
        assertEquals(true, "123".isNumber())
        assertEquals(false, "123g".isNumber())
    }
}