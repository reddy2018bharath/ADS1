import java.util.Scanner;
/**
 * LinkedList class.
 */
class LinkedList {
    /**
     * Node start.
     */
    private Node start = null;
    /**
     * class node.
     */
    class Node {
        /**
         * String item.
         */
        private String item;
        /**
         * Node next.
         */
        private Node next;
        /**
         * returns item.
         * @return node.
         */
        public String getItem() {
            return this.item;
        }
    }
    /**
     * stack is empty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return start == null;
    }
    /**
     * push method.
     * @param item element to push.
     */
    public void push(final String item) {
        Node prev = start;
        start = new Node();
        start.item = item;
        start.next = prev;
    }
    /**
     * pop method.
     * @return the poped element.
     */
    public String pop() {
        String item = start.item;
        start = start.next;
        return item;
    }
    /**
     * top node.
     * @return first or top Node.
     */
    public Node getStart() {
        return start;
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * constructor.
     */
    private Solution() {
    }
    /**
     * main method.
     *
     * @param args command args.
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            int x = 0;
            LinkedList list = new LinkedList();
            String[] s = sc.nextLine().split("");
            for (int i = 0; i < s.length; i++) {
                if (s[i].equals("[") || s[i].equals(
                    "{") || s[i].equals("(")) {
                    list.push(s[i]);
                } else if (s[i].equals("]")) {
                    if (list.isEmpty()) {
                        x = 1;
                        break;
                    }
                    if (list.getStart().getItem().equals("[")) {
                        list.pop();
                    }
                } else if (s[i].equals("}")) {
                    if (list.isEmpty()) {
                        x = 1;
                        break;
                    }
                    if (list.getStart().getItem().equals("{")) {
                        list.pop();
                    }
                } else if (s[i].equals(")")) {
                    if (list.isEmpty()) {
                        x = 1;
                        break;
                    }
                    if (list.getStart().getItem().equals("(")) {
                        list.pop();
                    }
                }
            }
            if (x == 1) {
                System.out.println("NO");
            } else {
                if (list.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}