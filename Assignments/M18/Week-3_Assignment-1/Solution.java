/**
 * { importing scanner class }.
 */
import java.util.Scanner;
/**
 * { importing exception class }.
 */
import java.util.NoSuchElementException;
/**
 * Class for binary search symbol table.
 *
 * @param      <Key>    The key.
 * @param      <Value>  The value.
 */
class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> {
    /**
     * { this is a capacity variable }.
     */
    private static final int INIT_CAPACITY = 2;
    /**
     * { this is a variable for keys }.
     */
    private Key[] keys;
    /**
     * {this is variable for values }.
     */
    private Value[] values;
    /**
     * { this is a integer variable }.
     */
    private int n = 0;

    /**
     * Constructs the object.
     */
    BinarySearchSymbolTable() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    BinarySearchSymbolTable(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    /**
     * { function for resize }.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }
    /**
     * { size function }.
     *
     * @return     { returns the size }.
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**
     * { contains functions }.
     *
     * @param      key   The key
     *
     * @return     { boolean value }.
     */
     public boolean contains(final Key key) {
        if (key == null) {
        throw new IllegalArgumentException("argument to contains() is null");
            }
        return get(key) != null;
    }
    /**
     * { gets the value pair with key }.
     *
     * @param      key   The key
     *
     * @return     { key value pair is returned }.
     */
    public Value get(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to get() is null");
        }
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            return values[i];
        }
        return null;
    }
    /**
     * { rank function }.
     *
     * @param      key   The key
     *
     * @return     { rank is returned }.
     */
     public int rank(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to rank() is null");
        }

        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
            hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    /**
     * { function for put }.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val)  {
        if (key == null) {
            throw new IllegalArgumentException(
            "first argument to put() is null");
        }

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = val;
            return;
        }

        if (n == keys.length) {
            resize(2 * keys.length);
        }

        for (int j = n; j > i; j--)  {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = val;
        n++;
        assert check();
    }
    /**
     * { delete function }.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to delete() is null");
        }
        if (isEmpty()) {
            return;
        }

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < n - 1; j++)  {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }

        n--;
        keys[n] = null;  // to avoid loitering
        values[n] = null;

        // resize if 1/4 full
        if (n > 0 && n == keys.length / (2 + 2)) {
            resize(keys.length / 2);
        }
        assert check();
        }
    /**
    * { delete min function }.
    */
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(min());
    }
    /**
     * { delete max function }.
     */
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Symbol table underflow error");
        }
        delete(max());
    }
    /**
     * { min function }.
     *
     * @return     { min is returned }.
     */
    public Key min() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called min() with empty symbol table");
        }
        return keys[0];
    }
    /**
     * { max function }.
     *
     * @return     { max returned }.
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "called max() with empty symbol table");
        }
        return keys[n - 1];
    }
    /**
     * { select function }.
     *
     * @param      k     {int k }.
     *
     * @return     { smallest key in this symbol table }.
     */
    public Key select(final int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException(
                "called select() with invalid argument: " + k);
        }
        return keys[k];
    }
    /**
     * { floor function }.
     *
     * @param      key   The key
     *
     * @return     { largest key in this symbol table less than or equal to }.
     */
    public Key floor(final Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument to floor() is null");
        }
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
    /**
     * { size function }.
     *
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { size is returned }.
     */
    public int size(final Key lo, final Key hi) {
        if (lo == null) {
            throw new IllegalArgumentException(
                "first argument to size() is null");
        }
        if (hi == null) {
            throw new IllegalArgumentException(
                "second argument to size() is null");
        }
        if (lo.compareTo(hi) > 0) {
            return 0;
        }
        if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }
    /**
     * { check function }.
     *
     * @return     { boolean is returned }.
     */
    private boolean check() {
        return isSorted() && rankCheck();
    }
    /**
     * Determines if sorted.
     *
     * @return     True if sorted, False otherwise.
     */
    private boolean isSorted() {
        for (int i = 1; i < size(); i++) {
            if (keys[i].compareTo(keys[i - 1]) < 0)  {
                return false;
            }
        }
        return true;
    }
    /**
     * { check that rank }.
     *
     * @return     { boolean is returned }.
     */
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String s = "";
        int i = 0;
        for (i = 0; i < size() - 1; i++) {
            s += keys[i] + " " + values[i] + "\n";
        }
        s += keys[i] + " " + values[i];
        return s;
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
     * { Client program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchSymbolTable<String, Integer> bs = new
        BinarySearchSymbolTable<String, Integer>();
        String[] tokens = sc.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            bs.put(tokens[i], i);
        }
        while (sc.hasNext()) {
            String[] check = sc.nextLine().split(" ");
            switch (check[0]) {
                case "max":
                    System.out.println(bs.max());
                    break;
                case "floor":
                    System.out.println(bs.floor(check[1]));
                    break;
                case "rank":
                    System.out.println(bs.rank(check[1]));
                    break;
                case "deleteMin":
                    bs.deleteMin();
                    break;
                case "contains":
                    System.out.println(bs.contains(tokens[1]));
                    break;
                case "keys":
                    System.out.println(bs);
                    break;
                case "get":
                    System.out.println(bs.get(check[1]));
                    break;
                default:
                    break;
            }
        }
    }
}





