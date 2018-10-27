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
        SeparateChainingHashST<Integer, String> s1 =
        new SeparateChainingHashST();
        SeparateChainingHashST<Integer, Double> s2 =
        new SeparateChainingHashST();
        int num = Integer.parseInt(sc.nextLine());
        while (num-- != 0) {
            String[] inp = sc.nextLine().split(",");
            s1.put(Integer.parseInt(inp[0]), inp[1]);
            s2.put(Integer.parseInt(inp[0]), Double.parseDouble(inp[2]));
        }
        int m = Integer.parseInt(sc.nextLine());
        while (m-- != 0) {
            String[] tokens = sc.nextLine().split(" ");
            if (tokens[0].equals("get") && tokens[2].equals("1")) {
                if (s1.get(Integer.parseInt(tokens[1])) == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(s1.get(Integer.parseInt(tokens[1])));
                }
            } else if (tokens[0].equals("get") && tokens[2].equals("2")) {
                if (s2.get(Integer.parseInt(tokens[1])) == null) {
                    System.out.println("Student doesn't exists...");
                } else {
                    System.out.println(s2.get(Integer.parseInt(tokens[1])));
                }
            }
        }
    }
}
