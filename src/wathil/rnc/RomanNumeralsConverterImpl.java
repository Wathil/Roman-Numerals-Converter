package wathil.rnc;

import java.util.*;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
public enum RomanNumeralsConverterImpl implements RomanNumeralsConverter<String, Integer>  {

    INSTANCE;

    private final List<PairIntString> numeralToRomanList;

    RomanNumeralsConverterImpl() {
        List<PairIntString> list = new ArrayList<>(13);
        list.add(PairIntString.of(1000, "M"));
        list.add(PairIntString.of(900, "CM"));
        list.add(PairIntString.of(500, "D"));
        list.add(PairIntString.of(400, "CD"));
        list.add(PairIntString.of(100, "C"));
        list.add(PairIntString.of(90, "XC"));
        list.add(PairIntString.of(50, "L"));
        list.add(PairIntString.of(40, "XL"));
        list.add(PairIntString.of(10, "X"));
        list.add(PairIntString.of(9, "IX"));
        list.add(PairIntString.of(5, "V"));
        list.add(PairIntString.of(4, "IV"));
        list.add(PairIntString.of(1, "I"));
        this.numeralToRomanList = Collections.unmodifiableList(list);
    }

    @Override
    public String convert(final Integer numberToConvertInteger) {
        int numberToConvert = numberToConvertInteger;

        if (numberToConvert < MIN_VALUE || numberToConvert > MAX_VALUE)
            throw new IllegalArgumentException(ERROR_MESSAGE);

        final StringBuilder resultSB = new StringBuilder(15);

        final Iterator<PairIntString> iterator = numeralToRomanList.iterator();

        do {
            PairIntString result = getPair(iterator.next(), numberToConvert);
            numberToConvert = getRemainderAndAppend(resultSB, result, numberToConvert);
        } while (numberToConvert > 0);

        return resultSB.toString();
    }

    private PairIntString getPair(final PairIntString couple, int mainRemainder) {
        final StringBuilder smallSB = new StringBuilder(3);

        int remainder = mainRemainder;
        while (remainder >= couple.intValue) {
            remainder = getRemainderAndAppend(smallSB, couple, remainder);
        }

        return PairIntString.of(mainRemainder - remainder, smallSB.toString());
    }

    private int getRemainderAndAppend(final StringBuilder resultSB, final PairIntString result, int remainder) {
        resultSB.append(result.stringValue);
        return remainder - result.intValue;
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