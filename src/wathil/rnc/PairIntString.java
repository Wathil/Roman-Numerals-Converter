package wathil.rnc;

/**
 * Created by yannickgarcia on 05/02/2017.
 */
final class Pair<U, V> {
    final U uValue;
    final V vValue;

    Pair(final U uValue, final V vValue) {
        this.uValue = uValue;
        this.vValue = vValue;
    }
}
