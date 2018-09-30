import java.util.Scanner;
/**
 * Class for deque.
 * @param      <E>   E of type generic.
 */
class Deque<E> {
    /**
     * LinkedList class.
     */
    private LinkedList<E> l;
    /**
     * Constructs the object.
     */
    Deque() {
        l = new LinkedList<E>();
    }
    /**
     * Determines if empty.
     * @return     True if empty, False otherwise.
     */
    boolean isEmpty() {
        return l.isEmpty();
    }
    /**
     * returns the size.
     * @return     size.
     */
    int size() {
        return l.getsize();
    }
    /**
     * Pushes at left.
     * @param      data  The data
     */
    void pushLeft(final E data) {
        l.insertAtStart(data);
    }
    /**
     * Pushes at right.
     * @param      data  The data
     */
    void pushRight(final E data) {
        l.insertAtEnd(data);
    }
    /**
     * pops the element to the left.
     */
    void popLeft() {
        l.deleteAtPos(1);
    }
    /**
     * pops the element to the right.
     */
    void popRight() {
        l.deleteAtPos(l.getsize());
    }
    /**
     * displays the queue.
     */
    void display() {
        l.display();
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method which drives the program.
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> d = new Deque<Integer>();
        int n = Integer.parseInt(sc.nextLine());
        while (n != 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
            case "isEmpty":
                System.out.println(d.isEmpty());
                break;
            case "size":
                System.out.println(d.size());
                break;
            case "pushLeft":
                d.pushLeft(Integer.parseInt(tokens[1]));
                d.display();
                break;
            case "pushRight":
                d.pushRight(Integer.parseInt(tokens[1]));
                d.display();
                break;
            case "popLeft":
                if (d.size() == 0) {
                    System.out.println("Deck is empty");
                } else {
                    d.popLeft();
                    d.display();
                }
                break;
            case "popRight":
                if (d.size() == 0) {
                    System.out.println("Deck is empty");
                } else {
                    d.popRight();
                    d.display();
                }
                break;
            default:
                break;
            }
            n--;
        }
    }
}