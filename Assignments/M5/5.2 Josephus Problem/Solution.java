import java.util.Scanner;

/**
 * Circular LinkedList implementaing Stack.
 *
 * @param      <T>   generic mode.
 */
class CircularLinkedList<T> {
    /**
     * Constructs the object.
     */
    CircularLinkedList() {
        /**
         * for checkstyle.
         */
    }

    /**
     * Node is having head and tail.
     */
    private Node<T> head = null;
    /**
     * tail.
     */
    private Node<T> tail = null;
    /**
     * current.
     */
    private Node<T> current = null;

    /**
     * Class for node.
     *
     * @param      <T>   generic mode.
     */
    class Node<T> {
        /**
         * T data item.
         */
        private T data;

        /**
         * Node next.
         */
        private Node<T> next;

    }

    /**
     * check whether stack is empty or not.
     * @return true or false.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * push method is used to push the item.
     * @param item element to push.
     */
    public void add(final T item) {
        if (head == null) {
            head = new Node<T>();
            head.data = item;
            tail = head;
            head.next = tail;
        } else {
            Node<T> newnode = new Node<T>();
            tail.next = newnode;
            newnode.data = item;
            newnode.next = head;
            tail = newnode;
        }

    }
/**
 * Gets the next.
 *
 * @return     The next.
 */
    public T getNext() {
        if (current == null) {
            current = head;
        }
        Node<T> tmp = current;
        current = tmp.next;
        return tmp.data;
    }
/**
 * to remove element.
 *
 * @param      element  The element
 *
 * @return     { description_of_the_return_value }
 */
    public T remove(final T element) {
        //to remove one element.
        if (head.next.equals(head) && head.data.equals(element)) {
            T tmp = head.data;
            head = null;
            return tmp;
        }

        //delete 1st element.
        if (head.data.equals(element)) {
            head = head.next;
            tail.next = head;
            return element;
        }

        /**
         * to remove last element.
         */
        if (tail.data.equals(element)) {
            Node<T> tempp = head;
            while (!tempp.next.equals(tail)) {
                tempp = tempp.next;
            }
            tempp.next = head;
            tail = tempp;
            return element;
        }

        Node<T> currenttmp = head;
        while (!currenttmp.next.data.equals(element)) {
            currenttmp = currenttmp.next;
        }
        Node<T> tmp2 = currenttmp.next.next;
        currenttmp.next = tmp2;

        return element;

    }
}

/**
 * Solution class.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * for checkstyle.
         */
    }

    /**
     *All IO operations are done here
     * @param      args  The commandline arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputcount = scan.nextInt();
        for (int inp = 0; inp < inputcount; inp++) {
            int noOfPersons = scan.nextInt();
            int mthShift = scan.nextInt();
            CircularLinkedList<Integer> cl = new CircularLinkedList<Integer>();

            for (int i = 0; i < noOfPersons; i++) {
                cl.add(i);
            }

            String str = "";
            while (!cl.isEmpty()) {
                int t2 = 0;
                for (int i = 0; i < mthShift; i++) {
                    t2 = cl.getNext();
                }
                str += cl.remove(t2) + " ";
            }
            System.out.println(str.trim());
        }
    }

}