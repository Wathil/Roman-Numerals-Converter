package wathil.rnc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
class RomanNumeralsConverterImplTest {

    @Test
    public void should_return_I_when_1() {
        final int i = 1;
        final String result = new RomanNumeralsConverterImpl().convert(i);
        assertTrue("I".equals(result));
    }

    @Test
    public void should_return_IV_when_4() {
        final int i = 4;
        final String result = new RomanNumeralsConverterImpl().convert(i);
        assertTrue("IV".equals(result));
    }

    @Test
    public void should_return_MCMLIV_when_1954() {
        final int i = 1954;
        final String result = new RomanNumeralsConverterImpl().convert(i);
        assertTrue("MCMLIV".equals(result));
    }

    @Test
    public void should_return_MCMXC_when_1990() {
        final int i = 1990;
        final String result = new RomanNumeralsConverterImpl().convert(i);
        assertTrue("MCMXC".equals(result));
    }

}