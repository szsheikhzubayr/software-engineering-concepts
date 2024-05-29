package org.example.queue;

public class Queue {
    private static class Node{
        private int data;
        private Node next;
        private Node(int data){
            this.data = data;
        }
    }

    private Node head;//remove from head
    private Node tail;//add things here

    public Boolean isEmpty(){
        return head == null;
    }
    public int peek(){
        return head.data;
    }
    public void add(int data){
        Node node = new Node(data);

        //since queue is fifo hence and always added to the end, hence we start by checking if tail is null
        if(tail !=null){
            tail.next = node;
        }
        //if tail is null, we add the new node to the tail
        tail = node;

        //if head is null, we add the new node to the head
        if(head == null){
            head = node;
        }
    }

    public int remove(){
        //since elements are removed from the front of the queue, hence we select the data from the head
        int data = head.data;
        //and then we assign the next node of the head as the head
        head = head.next;
        //if head is null, we assign tail also as null
        if(head == null){
            tail = null;
        }
        //finally return the data that has been removed
        return data;
    }


}
