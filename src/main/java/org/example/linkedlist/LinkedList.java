package org.example.linkedlist;

// Your are given a linkendlist (1->2->3->4->5),
// reverse the linkedlist without using collection methods. (5->4->3->2->1)

// singly linked list

class Node{

    int data;
    Node next;
    Node(int data, Node node){
        this.data = data;
        this.next = node;
    }
}

class LinkedList{

   static Node root;

    static Node reverse(Node node){
        Node prev = null;
        Node next = null;
        int data = 0;
        Node current = node; // 1st - current = 1, current.next = 2
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current=next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {

        root = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, null)))));
//        System.out.println("actual linkedlist");
//        while(root != null){
//
//            System.out.print(root.data + "->");
//            root= root.next;
//        }
        root = LinkedList.reverse(root);

        while(root != null){
            System.out.println(root.data);
            root = root.next;
        }

    }

}
