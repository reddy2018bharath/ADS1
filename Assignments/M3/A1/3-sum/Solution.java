import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
class Solution {
    /**
     * { var_description.
     */
    private int[] arr;
    /**
     * { var_description}.
     */
    private int n;
    /**
     * Constructs the object.
     */
    Solution() {
        arr = new int[n];
    }
    /**
     * { function_description.
     *
     * @return size { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * { function_description.
     *
     * @return  array   { description_of_the_return_value }
     */
    public int[] array() {
        return arr;
    }
    /**
     * three sum.
     *
     * @param      array  The array
     */
    public static void threeSum(final int[] array) {
        Arrays.sort(array);
        // System.out.println(Arrays.toString(array));
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int last = array.length - 1;
            while (j < last) {
                if (array[i] + array[j] + array[last] == 0) {
                    count++;
                    j++;
                    last = array.length - 1;
                } else if ((array[i] + array[j] + array[last]) > 0) {
                    last--;
                } else {
                    j++;
                }
            }
        }
        System.out.println(count);
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int inp = sc.nextInt();
        int[] arr = new int[inp];
        for (int i = 0; i < inp; i++) {
            arr[i] = sc.nextInt();
        }
        threeSum(arr);
    }
}
