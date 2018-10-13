import java.util.Scanner;
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main method to drive the program.
     * @param      args  The arguments
     * The time complexity for this method is O(2N)
     */
    public static void main(final String[] args) {
        final int sixhun = 600;
        int range = sixhun;
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int noofways = sc.nextInt();
        int count = 0;
        int temp = -1;
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= range; i++) {
            pq.insert(new CubeSum(i, i));
        }
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (temp == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == noofways - 1) {
                number--;
                if (number == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            temp = s.getSum();
            if (s.getNumberTwo() < range) {
                pq.insert(new CubeSum(s.getNumberOne(), s.getNumberTwo() + 1));
            }
        }
    }
}