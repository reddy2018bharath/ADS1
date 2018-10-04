import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        while (sc.hasNext()) {
            String data = sc.nextLine();
            String[] tokens = data.split(" ");
            switch (tokens[0]) {
                case "insertAt":
                try {
                    l.insertAt(Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2]));
                    l.display();
                } catch (Exception e) {
                    System.out.println("Can't insert at this position.");
                }
                break;
                case "reverse":
                try {
                    l.reverse();
                    l.display();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
                default:
                break;
            }
        }
    }
}