package com.pawsaj;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseNumberTest {
    private ReverseNumber reverseNumber = new ReverseNumber();

    @Test
    void reverse() {
        assertEquals(54321, reverseNumber.reverse(12345));
        assertEquals(0, reverseNumber.reverse(0));
        assertEquals(9, reverseNumber.reverse(9));
        assertEquals(9, reverseNumber.reverse(90));
        assertEquals(192837, reverseNumber.reverse(738291));
        assertEquals(-12, reverseNumber.reverse(-21));
        assertEquals(-54321, reverseNumber.reverse(-12345));
    }

    @Test
    void reverseWithPrecision() {
        assertEquals(54.321d, reverseNumber.reverse(12.345d));
        assertEquals(0.0d, reverseNumber.reverse(0.0d));
        assertEquals(9.1d, reverseNumber.reverse(1.9d));
        assertEquals(1.92837d, reverseNumber.reverse(7.382910d));
        assertEquals(7.382910d, reverseNumber.reverse(.192837d));
        assertEquals(-12.3d, reverseNumber.reverse(-32.1d));
        assertEquals(-10.54321f, reverseNumber.reverse(-12.34501f));
    }

}