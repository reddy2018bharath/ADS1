/**
 * Class for cube sum.
 */
public class CubeSum implements Comparable<CubeSum> {
    /**
     * sum variable.
     */
    private int sum;
    /**
     * first number.
     */
    private int i;
    /**
     * second number.
     */
    private int j;
    /**
     * Constructs the object.
     * @param      i1    I 1
     * @param      j1    The j 1
     */
    public CubeSum(final int i1, final int j1) {
        sum = i1 * i1 * i1 + j1 * j1 * j1;
        i = i1;
        j = j1;
    }
    /**
     * Gets the sum.
     * @return     The sum.
     */
    int getSum() {
        return sum;
    }
    /**
     * Gets the number one.
     * @return     The number one.
     */
    int getNumberOne() {
        return i;
    }
    /**
     * Gets the number two.
     * @return     The number two.
     */
    int getNumberTwo() {
        return j;
    }
    /**
     * compareTo method.
     * @param      that  The that
     * @return     integer.
     */
    public int compareTo(final CubeSum that) {
        if (sum < that.sum) {
            return -1;
        }
        if (sum > that.sum) {
            return +1;
        }
        return 0;
    }
}