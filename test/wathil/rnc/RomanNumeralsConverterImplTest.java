package wathil.rnc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wathil.rnc.RomanNumeralsConverter.ERROR_MESSAGE;
import static wathil.rnc.RomanNumeralsConverterImpl.INSTANCE;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
class RomanNumeralsConverterImplTest {

    @Test
    public void should_throw_an_IllegalArgumentException_when_0() {
        try {
            INSTANCE.convert(0);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ERROR_MESSAGE);
        }
    }

    @Test
    public void should_throw_an_IllegalArgumentException_when_5000() {
        try {
            INSTANCE.convert(5000);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ERROR_MESSAGE);
        }
    }

    @Test
    public void should_return_I_when_1() {
        final String expected = "I";
        final String result = INSTANCE.convert(1);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_II_when_2() {
        final String expected = "II";
        final String result = INSTANCE.convert(2);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_III_when_3() {
        final String expected = "III";
        final String result = INSTANCE.convert(3);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_IV_when_4() {
        final String expected = "IV";
        final String result = INSTANCE.convert(4);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_V_when_5() {
        final String expected = "V";
        final String result = INSTANCE.convert(5);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_VI_when_6() {
        final String expected = "VI";
        final String result = INSTANCE.convert(6);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_VII_when_7() {
        final String expected = "VII";
        final String result = INSTANCE.convert(7);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_VIII_when_8() {
        final String expected = "VIII";
        final String result = INSTANCE.convert(8);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_IX_when_9() {
        final String expected = "IX";
        final String result = INSTANCE.convert(9);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_X_when_10() {
        final String expected = "X";
        final String result = INSTANCE.convert(10);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_XI_when_11() {
        final String expected = "XI";
        final String result = INSTANCE.convert(11);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_CMXCIX_when_999() {
        final String expected = "CMXCIX";
        final String result = INSTANCE.convert(999);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_CMXCIX_when_1990() {
        final String expected = "MCMXC";
        final String result = INSTANCE.convert(1990);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_MCMLIV_when_1954() {
        final String expected = "MCMLIV";
        final String result = INSTANCE.convert(1954);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_MMMCMXCIX_when_3999() {
        final String expected = "MMMCMXCIX";
        final String result = INSTANCE.convert(3999);
        assertTrue(expected.equals(result));
    }
}