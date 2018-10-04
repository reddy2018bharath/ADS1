class LinkedList {
    Node head;
    int size;
    LinkedList() {
        head = null;
        size = 0;
    }
    public void insertAt(int pos, int ele) throws Exception{
        Node newNode = new Node(ele);
        if (pos < 0 || pos > size) {
            throw new Exception();
        }
        head = insertAt(pos, head, newNode, 0);
    }
    public Node insertAt(int pos, Node first, Node obj, int count) {
        if (pos == count) {
            obj.next = first;
            size++;
            return obj;
        }
        first.next = insertAt(pos, first.next, obj, count + 1);
        return first;
    }
    public void reverse() {
        reverse(null, head);
    }
    void reverse(Node previous, Node current) {
        if (current != null) {
            reverse(current, current.next);
            current.next = previous;
        } else {
            head = previous;
        }
    }
    void display() {
        Node temp = head;
        String str = "";
        while (temp != null) {
            str += temp.data+", ";
            temp = temp.next;
        }
        System.out.println(str.substring(0,str.length()-2));
    }
}