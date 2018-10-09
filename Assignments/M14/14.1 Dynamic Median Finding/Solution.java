import java.util.Scanner;
public class Solution {

    private Solution () {

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        MinPQ<Integer> minpq = new MinPQ<Integer>(n);
        MaxPQ<Integer> maxpq = new MaxPQ<Integer>(n);

        int median = 0;
        for (int i = 0; i < n; i++) {
            int val = scan.nextInt();
            if (val > median) {
                minpq.insert(val);
            } else {
                maxpq.insert(val);
            }

            if (minpq.size() - maxpq.size() > 1) {
                maxpq.insert(minpq.delMin());

            }
            if (maxpq.size() - minpq.size() > 1) {
                minpq.insert(maxpq.delMax());
                
            }

            if (minpq.size() == maxpq.size()) {
                median = (minpq.min() + maxpq.max()) / 2;
                System.out.println(median);
            }

            if (maxpq.size() > minpq.size()) {
                median = maxpq.max();
                System.out.println(median);
            }

            if (minpq.size() > maxpq.size()) {
                median = minpq.min();
                System.out.println(median);
            }

        }

    }
}
