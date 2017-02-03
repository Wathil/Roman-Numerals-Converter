package wathil.rnc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static wathil.rnc.RomanNumeralsConverter.ERROR_MESSAGE;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
class RomanNumeralsConverterImplTest {

    private RomanNumeralsConverter converter = RomanNumeralsConverterImpl.getInstance();

    @Test
    public void should_throw_an_IllegalArgumentException_when_0() {
        try {
            converter.convert(0);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ERROR_MESSAGE);
        }
    }

    @Test
    public void should_throw_an_IllegalArgumentExcepion_when_5000() {
        try {
            converter.convert(5000);
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), ERROR_MESSAGE);
        }
    }

    @Test
    public void should_return_I_when_1() {
        final String expected = "I";
        final String result = converter.convert(1);
        assertTrue("I".equals(result));
    }

    @Test
    public void should_return_IV_when_4() {
        final String expected = "IV";
        final String result = converter.convert(4);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_MCMLIV_when_1954() {
        final String expected = "MCMLIV";
        final String result = converter.convert(1954);
        assertTrue(expected.equals(result));
    }

    @Test
    public void should_return_MMMCMXCIX_when_3999() {
        final String expected = "MMMCMXCIX";
        final String result = converter.convert(3999);
        assertTrue(expected.equals(result));
    }
}