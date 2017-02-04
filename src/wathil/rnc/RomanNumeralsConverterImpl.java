package wathil.rnc;

import java.util.*;
import java.util.function.Function;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
public enum RomanNumeralsConverterImpl implements RomanNumeralsConverter  {

    INSTANCE;

    private Map<Integer, String> numeralToRomanMap;

    RomanNumeralsConverterImpl() {
        Map<Integer, String> map = new LinkedHashMap<>(13);
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        this.numeralToRomanMap = Collections.unmodifiableMap(map);
    }

    @Override
    public String convert(final int numberToConvert) {
        if (numberToConvert < MIN_VALUE || numberToConvert > MAX_VALUE)
            throw new IllegalArgumentException(ERROR_MESSAGE);

        return convert.apply(numberToConvert);
    }

    private Function<Integer, String> convert = (numberToConvert) -> {
        StringBuilder resultSB = new StringBuilder();

        Iterator iterator = numeralToRomanMap.entrySet().iterator();

        int number = numberToConvert;
        while (number > 0) {
            Map.Entry mapEntry = (Map.Entry) iterator.next();

            int numberKey = (Integer) mapEntry.getKey();

            while (number >= numberKey) {
                number -= numberKey;
                resultSB.append(mapEntry.getValue());
            }
        }

        return resultSB.toString();
    };

}
