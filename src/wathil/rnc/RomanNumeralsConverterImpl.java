package wathil.rnc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
public enum RomanNumeralsConverterImpl implements RomanNumeralsConverter  {

    INSTANCE;

    private Map numeralToRoman;

    RomanNumeralsConverterImpl() {
        numeralToRoman = new LinkedHashMap<Integer, String>(13);
        numeralToRoman.put(1000, "M");
        numeralToRoman.put(900, "CM");
        numeralToRoman.put(500, "D");
        numeralToRoman.put(400, "CD");
        numeralToRoman.put(100, "C");
        numeralToRoman.put(90, "XC");
        numeralToRoman.put(50, "L");
        numeralToRoman.put(40, "XL");
        numeralToRoman.put(10, "X");
        numeralToRoman.put(9, "IX");
        numeralToRoman.put(5, "V");
        numeralToRoman.put(4, "IV");
        numeralToRoman.put(1, "I");
    }

    @Override
    public String convert(final int numberToConvert) {
        validate(numberToConvert);

        StringBuilder resultSB = new StringBuilder();

        Set<Integer> linkedHMEntrySet = this.numeralToRoman.entrySet();
        Iterator iterator = linkedHMEntrySet.iterator();

        int number = numberToConvert;
        while (iterator.hasNext() && number > 0) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();

            int numberKey = (Integer) mapEntry.getKey();

            while (number >= numberKey) {
                number -= numberKey;
                resultSB.append(mapEntry.getValue());
            }
        }

        return resultSB.toString();
    }

    private void validate(final int numberToConvert) {
        if (numberToConvert < MIN_VALUE || numberToConvert > MAX_VALUE)
            throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
