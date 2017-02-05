package wathil.rnc;

/**
 * Created by yannickgarcia on 05/02/2017.
 */
final class PairIntString {
    final int intValue;
    final String stringValue;

    private PairIntString(final int intValue, final String stringValue) {
        this.intValue = intValue;
        this.stringValue = stringValue;
    }

    static PairIntString of(final int intValue, final String stringValue) {
        return new PairIntString(intValue, stringValue);
    }
}
