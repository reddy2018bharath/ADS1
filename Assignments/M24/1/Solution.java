import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * unused constructor.
     */
    private Solution() {
    }
    /**
     * solution for main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        SeparateChainingHashST<Integer, String> h1 =
        new SeparateChainingHashST();
        SeparateChainingHashST<Integer, Double> h2 =
        new SeparateChainingHashST();
        int n = Integer.parseInt(sc.nextLine());
        while (n-- != 0) {
            String[] inp = sc.nextLine().split(",");
            h1.put(Integer.parseInt(inp[0]), inp[1]);
            h2.put(Integer.parseInt(inp[0]), Double.parseDouble(inp[2]));
        }
        int testcases = Integer.parseInt(sc.nextLine());
        while (testcases-- != 0) {
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[0].equals("get") && tokens[2].equals("1")) {
                    System.out.println(h1.get(Integer.parseInt(tokens[1])));
            } else if (tokens[0].equals("get") && tokens[2].equals("2")) {
                    System.out.println(h2.get(Integer.parseInt(tokens[1])));
            }
        }
    }
}