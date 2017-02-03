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

}