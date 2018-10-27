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
        SeparateChainingHashST<Integer, String> hash1 =
        new SeparateChainingHashST();
        SeparateChainingHashST<Integer, Double> hash2 =
        new SeparateChainingHashST();
        int input = Integer.parseInt(sc.nextLine());
        while (input-- != 0) {
            String[] inp = sc.nextLine().split(",");
            hash1.put(Integer.parseInt(inp[0]), inp[1]);
            hash2.put(Integer.parseInt(inp[0]), Double.parseDouble(inp[2]));
        }
        int m = Integer.parseInt(sc.nextLine());
        while (m-- != 0) {
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[0].equals("get") && tokens[2].equals("1")) {
                if (hash1.get(Integer.parseInt(tokens[1])) == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(hash1.get(Integer.parseInt(tokens[1])));
                }
            } else if (tokens[0].equals("get") && tokens[2].equals("2")) {
                if (hash2.get(Integer.parseInt(tokens[1])) == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(hash2.get(Integer.parseInt(tokens[1])));
                }
            }
        }
    }
}
