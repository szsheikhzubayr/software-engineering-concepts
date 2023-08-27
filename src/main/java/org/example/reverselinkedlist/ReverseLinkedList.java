package org.example.reverselinkedlist;

public class ReverseLinkedList {
    static Node head;
    Node reverse(Node node){
        Node prev = null;
        Node current = node;
        Node next = null;
        while(current != null){
            //store current's next in next node defined above
            next = current.next;

            //set current's previous as current's next node
            current.next = prev;

            //store current node in previous node variable
            prev = current;

            //set next node as current
            current = next;
        }

        //set previous to node
        node = prev;

        //return the reversed linked list
        return node;
    }

    void printList(Node node){
        while(node != null){
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);


        System.out.println("Given linked list");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(head);
    }

}

class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}
