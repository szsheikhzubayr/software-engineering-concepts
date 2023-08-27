package org.example.linkedlist;

import java.util.LinkedList;

public class DetectLoopInLinkedList {
    static class Node{
        int data;
        Node next;
        Node(int data){
            data = this.data;
            next = null;
        }
    }

    static Node head;

    public void push(int new_data){
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;

    }

    boolean detectLoop(){
        int flag = 0;
        Node slowPtr = head;
        Node fastPtr = head;

        while(slowPtr != null && fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
       return false;
    }

    public static void main(String[] args) {
        DetectLoopInLinkedList ll = new DetectLoopInLinkedList();
        ll.push(20);
        ll.push(4);
        ll.push(15);
        ll.push(10);


        ll.head.next.next.next.next = ll.head;
        System.out.println(ll.detectLoop());

    }


}
