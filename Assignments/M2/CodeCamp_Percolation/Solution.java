import java.util.Scanner;
/**
 * Class for percolation.
 */
 class Percolation {
 /**
  * { integer variable }.
  */
    private int n;
 /**
  * { integer variable }.
  */
    private int size;
 /**
  * { integer variable }.
  */
    private int first;
 /**
  * { integer variable }.
  */
    private int last;
 /**
  * { object creation }.
  */
    private WeightedQuickUnionUF wqf;
   /**
    * { boolean value }.
    */
    private boolean[] connected;
/**
 * { integer variable }.
 */
    private int count;
/**
 * Constructs the object.
 *
 * @param      n1     { parameter_description }
 */
    Percolation(final int n1) {
        this.n = n1;
        this.size = n * n;
        this.first = size;
        this.last = size + 1;
        this.count = 0;
        connected = new boolean[size];
        wqf = new WeightedQuickUnionUF(size + 2);
        for (int i = 0; i < n; i++) {
            wqf.union(first, i);
            wqf.union(last, size - i - 1);
        }
    }
/**
 * Searches for the first match.
 *
 * @param      i     { parameter_description }
 * @param      j     { parameter_description }
 *
 * @return     { description_of_the_return_value }
 */
    public int indexOf(final int i, final int j) {
        return n * (i - 1) + (j - 1);
    }
    /**
     * Links open sites.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void linkOpenSites(final int i, final int j) {
        if (connected[j] && !wqf.connected(i, j)) {
            wqf.union(i, j);
        }
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int numberOfOpenSites() {
        return count;
    }
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void open(final int i, final int j) {
        int index = indexOf(i, j);
        connected[index] = true;
        count++;
        int bottom = index + n;
        int top = index - n;
        if (n == 1) {
        wqf.union(first, index);
        wqf.union(last, index);

    }
        if (bottom < size) {
            linkOpenSites(index, bottom);
        }
        if (top >= 0) {
            linkOpenSites(index, top);
        }
        if (j == 1) {
            if (j != n) {
            linkOpenSites(index, index + 1);
        }
        return;
        }
        if (j == n) {
            linkOpenSites(index, index - 1);
            return;
        }
        linkOpenSites(index, index + 1);
        linkOpenSites(index, index - 1);
    }
    /**
     * Determines if open.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int i, final int j) {
        return connected[indexOf(i, j)];
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public boolean percolates() {
        return wqf.connected(first, last);
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Percolation pe = new Percolation(n);
        while (sc.hasNext()) {
        String[] tokens = sc.nextLine().split(" ");
        pe.open(Integer.parseInt(tokens[0]),
            Integer.parseInt(tokens[1]));
        }
        System.out.println(pe.percolates()
            && pe.numberOfOpenSites() != 0);
    }
}