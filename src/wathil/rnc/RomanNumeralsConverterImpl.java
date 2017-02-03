package wathil.rnc;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
public class RomanNumeralsConverterImpl implements RomanNumeralsConverter  {

    private Map numeralToRoman;

    public RomanNumeralsConverterImpl() {
        numeralToRoman = new LinkedHashMap<Integer, Character>();
        numeralToRoman.put(1000, 'M');
        numeralToRoman.put(500, 'D');
        numeralToRoman.put(100, 'C');
        numeralToRoman.put(50, 'L');
        numeralToRoman.put(10, 'X');
        numeralToRoman.put(5, 'V');
        numeralToRoman.put(1, 'I');
    }

    @Override
    public String convert(Integer i) {
        StringBuilder sb = new StringBuilder();

        Set<Integer> set = this.numeralToRoman.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {

            Map.Entry me = (Map.Entry) iterator.next();

            int n = (Integer) me.getKey();

            while (i >= n) {
                i = i - n;
                sb.append(me.getValue());
            }

            if (i == 0) {
                break;
            }

        }

        return sb.toString();
    }
}
