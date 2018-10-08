import java.util.Scanner;
/**
 * Class for minimum heap.
 *
 * @param      <E>   { parameter_description }
 */
class MinHeap<E extends Comparable<E>> {
    /**
     * { array }.
     */
    private E[] array;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr
     */
    MinHeap(final E[] arr) {
        this.array = arr;
    }
    /**
     * Determines if minimum heap.
     *
     * @param      arr1  The arr 1.
     *
     * @return     True if minimum heap, False otherwise.
     */
    public boolean isMinHeap(final E[] arr1) {
        for (int i = 0; i < arr1.length - 1; i++) {
            if (!less(arr1[i], arr1[i + 1])) {
                return true;
            }
        }
        return false;
    }
    /**
     * { function_description }.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final E i, final E j) {
        return i.compareTo(j) <= 0;
    }

}
/**
 * Client program.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {
        //for check style purpose.
    }
    /**
     * { main function }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        switch (line) {
            case "String":
            int testcases = Integer.parseInt(s.nextLine());
            for (int i = 0; i < testcases; i++) {
                String[] tokens = s.nextLine().split(",");
                MinHeap<String> m = new MinHeap<String>(tokens);
                System.out.println(m.isMinHeap(tokens));

            }
            break;
            case "Integer":
            int tests = Integer.parseInt(s.nextLine());
            for (int i = 0; i < tests; i++) {
                String str = s.nextLine();
                String[] tokens = str.split(",");
                Integer[] intarr = new Integer[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    intarr[j] = Integer.parseInt(tokens[j]);
                }
            MinHeap<Integer> m = new MinHeap<Integer>(intarr);
                //int len = intarr.length;
                System.out.println(m.isMinHeap(intarr));
            }
            break;
            case "Float":
            int n = Integer.parseInt(s.nextLine());
            for (int i = 0; i < n; i++) {
                String string = s.nextLine();
                if (string.equals("")) {
                    System.out.println("false");
                } else {
                String[] tokens = string.split(",");
                Float[]  floarr = new Float[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    floarr[j] = Float.parseFloat(tokens[j]);
                }
                MinHeap<Float> m = new MinHeap<Float>(floarr);
                //int len = floarr.length;
                System.out.println(m.isMinHeap(floarr));
            }
            }
            break;
            case "Double":
            int cases = Integer.parseInt(s.nextLine());
            for (int i = 0; i < cases; i++) {
                String st = s.nextLine();
                String[] tokens = st.split(",");
                Double[]  douarr = new Double[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    douarr[j] = Double.parseDouble(tokens[j]);
                }
                MinHeap<Double> m = new MinHeap<Double>(douarr);
                //int len = douarr.length;
                System.out.println(m.isMinHeap(douarr));
            }
            break;
            default:
            break;
        }
    }
}
