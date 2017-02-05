package wathil.rnc;

import java.util.*;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
public enum RomanNumeralsConverterImpl implements RomanNumeralsConverter<Integer, String>  {

    INSTANCE;

    private final List<Pair<Integer, String>> numeralToRomanList;

    RomanNumeralsConverterImpl() {
        List<Pair<Integer, String>> list = new ArrayList<>(13);
        list.add(new Pair<>(1000, "M"));
        list.add(new Pair<>(900, "CM"));
        list.add(new Pair<>(500, "D"));
        list.add(new Pair<>(400, "CD"));
        list.add(new Pair<>(100, "C"));
        list.add(new Pair<>(90, "XC"));
        list.add(new Pair<>(50, "L"));
        list.add(new Pair<>(40, "XL"));
        list.add(new Pair<>(10, "X"));
        list.add(new Pair<>(9, "IX"));
        list.add(new Pair<>(5, "V"));
        list.add(new Pair<>(4, "IV"));
        list.add(new Pair<>(1, "I"));
        this.numeralToRomanList = Collections.unmodifiableList(list);
    }

    @Override
    public String convert(final Integer numberToConvertInteger) {
        int numberToConvert = numberToConvertInteger;

        if (numberToConvert < MIN_VALUE || numberToConvert > MAX_VALUE)
            throw new IllegalArgumentException(ERROR_MESSAGE);

        final StringBuilder resultSB = new StringBuilder(15);

        final Iterator<Pair<Integer, String>> iterator = numeralToRomanList.iterator();

        do {
            Pair<Integer, String> result = getPair(iterator.next(), numberToConvert);
            numberToConvert = getRemainderAndAppend(resultSB, result, numberToConvert);
        } while (numberToConvert > 0);

        return resultSB.toString();
    }

    private Pair<Integer, String> getPair(final Pair<Integer, String> couple, int mainRemainder) {
        final StringBuilder smallSB = new StringBuilder(3);

        int remainder = mainRemainder;
        while (remainder >= couple.uValue) {
            remainder = getRemainderAndAppend(smallSB, couple, remainder);
        }

        return new Pair<>(mainRemainder - remainder, smallSB.toString());
    }

    private int getRemainderAndAppend(final StringBuilder resultSB, final Pair<Integer, String> result, int remainder) {
        resultSB.append(result.vValue);
        return remainder - result.uValue;
    }

    public static void main(String[] args) {
        int max = 0;
        for (int i = 1 ; i < 4000 ; i++) {
            String result = INSTANCE.convert(i);
            int length = result.length();
            if (length > max) {
                max = length;
                System.out.println(i + ":" + result + "=" + max);
            }
        }
    }
}