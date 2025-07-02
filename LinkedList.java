public class LinkedList {

    // this is how we create node
    public static class Node{
        int data;
        Node next;
        
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    // adding note at first - creating new Head Node

    public void addFirst(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        ll.head.next = new Node(2);

    }
}
