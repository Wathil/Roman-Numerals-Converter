package wathil.rnc;

/**
 * Created by yannick.garcia on 03/02/2017.
 */
@FunctionalInterface
public interface RomanNumeralsConverter {
    int MIN_VALUE = 1;
    int MAX_VALUE = 3999;
    String ERROR_MESSAGE = "it must be between " + MIN_VALUE + " and " + MAX_VALUE;

    String convert(Integer i);
}
