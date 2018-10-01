import java.util.Scanner;
/**
 * Class for node.
 */
class Node {
    /**
     * { var_description }.
     */
    private String data;
    /**
     * { var_description }.
     */
    private Node next;
    /**
     * Constructs the object.
     * @param      item  The item
     */
    Node(final String item) {
        this.data = item;
    }
    /**
     * gets the data.
     * @return     { description_of_the_return_value }
     */
    String getdata() {
        return data;
    }
    /**
     * gets the next.
     * @return     { description_of_the_return_value }
     */
    Node getnext() {
        return next;
    }
    /**
     * sets the next.
     *
     * @param      s     { parameter_description }
     */
    void setnext(final Node s) {
        next = s;
    }
}
/**
 * Class for steque.
 */
class Steque {
    /**
     * { item_description }.
     */
    private Node start;
    /**
     * { var_description }.
     */
    private Node end;
    /**
     * { var_description }.
     */
    private int size = 0;
    /**
     * Constructs the object.
     */
    Steque() {
        start = null;
        end = null;
    }
    /**
     * gets the start.
     * @return     { description_of_the_return_value }
     */
    Node getstart() {
        return start;
    }
    /**
     * gets the end.
     * @return     { description_of_the_return_value }
     */
    Node getend() {
        return end;
    }
    /**
     * gets the size.
     * @return     { description_of_the_return_value }
     */
    int getsize() {
        return size;
    }
    /**
     * { function_description }.
     * @param      item  The item
     */
    //The time complexcity of this method is 0(1)
    void push(final String item) {
        Node obj = new Node(item);
        if (size == 0) {
            start = obj;
            end = start;
            size++;
            return;
        }
        obj.setnext(start);
        start = obj;
        size++;

    }
    /**
     * { function_description }.
     * @param      item  The item
     */
    // The time complexcity of this method is 0(N)
    void enqueue(final String item) {
        Node obj = new Node(item);
        if (size == 0) {
            start = obj;
            end = start;
            size++;
            return;
        }
        end.setnext(obj);
        end = obj;
        size++;
    }
    /**
     * { function_description }.
     * @return     { description_of_the_return_value }
     * @throws     Exception  { exception_description }
     */
    //The time complexcity of this method is 0(1)
    String pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Steque is empty.");
        }
        String data = start.getdata();
        start = start.getnext();
        size--;
        return data;
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return size == 0;
    }
    /**
     * Returns a string representation of the object.
     * @return     String representation of the object.
     */
    //The time complexcity of this method is 0(N)s
    public String toString() {
        // if(isEmpty()){

        // }
        Node temp = start;
        String res = "";
        while (temp != null) {
            res += temp.getdata() + ", ";
            temp = temp.getnext();
        }
        return res.substring(0, res.length() - 2);
    }
}
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
     * main method.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        Steque st = new Steque();
        while (sc.hasNextLine()) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
            case "push":
                st.push(input[1]);
                System.out.println(st);
                break;
            case "pop":
                try {
                    st.pop();
                    if (st.isEmpty()) {
                        System.out.println("Steque is empty.");
                    } else {
                        System.out.println(st);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "enqueue":
                st.enqueue(input[1]);
                System.out.println(st);
                break;
            default:
                st = new Steque();
                System.out.println();
                break;
            }
        }
    }
}