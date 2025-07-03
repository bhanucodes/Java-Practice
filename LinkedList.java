public class LinkedList {

    // this is how we create node
    public static class Node {
        int data;
        Node next;

        public Node(int value) {
            this.data = value;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static int size=0;

    // adding node at first - creating new Head Node

    public void addFirst(int data) {
        Node newHead = new Node(data);
        if (head == null) {
            head = tail = newHead;  
            size++;
            return;
        }
        newHead.next = head;
        head = newHead;
        size++;
    }

    // adding node at last - creating new Tail node

    public void addLast (int data){
        Node newTail = new Node(data);
        size++;
        if (head == null) {
            head = tail = newTail;
            return;            
        }
        tail.next = newTail;
        tail = newTail;
        return;
    }

    // adding node in middle (anywhere in the middle of the LinkedList)

    public void add (int index, int data){
        Node newNode = new Node(data);
        size++;
        Node temp = head;

        int i=0;
        while (i < index-1){
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        
    }

    // printing linkedlist

    public void printLinkedlist (){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.data+ "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // removing first node from linkedlist

    public int removeFirst(){
        if (size ==0) {
            System.out.println("Linkedlist is empty");
            return Integer.MIN_VALUE;
        }
        else if (size ==1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        return val;
        
    }


    //remove last node

    public int removeLast(){
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }

        Node prev = head;
        for(int i =0; i<size-2; i++){
            prev = prev.next;
        }

        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.head = new Node(1);
        ll.head.next = new Node(2);

        ll.printLinkedlist();
    }
}
