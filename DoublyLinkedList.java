package com.company;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private Node prev;
    private int size;

    public DoublyLinkedList(){
        this.size = 0;
    }

    public Node get(int index){  //It gets the node at the given index position
        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void insertLast(int val){
        Node node = new Node(val);
        if(tail == null){
            insertFirst(val);
            return;
        }

        node.prev = tail;
        node.next = null;
        tail.next = node;

        size++;
    }

    public void insertindex(int val, int index){
        if(index==0){             //if index == head
            insertFirst(val);
            return;
        }
        if(index==size-1){        //if index == tail
            insertLast(val);
            return;
        }

        Node before = get(index);
        Node temp = new Node(val, before.next);
        temp.prev = before;
        temp.next.prev = temp; // node(index+1).prev points to the new node
        before.next = temp;

        size++;
    }

    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.val + " <=> ");
            temp = temp.next;
        }
        System.out.print("Null");
    }

    public void reverse(){
        System.out.println("Reversing");
        System.out.print("End <=> ");
        Node temp = tail;

        while(temp != null){
            System.out.print(temp.val + " <=> ");
            temp = temp.prev;
        }
        System.out.print("Null");
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("List empty");
        }

        head = head.next;
        head.prev = null;

        size--;
    }

    public void deleteLast(){
        if(head == tail){
            deleteFirst();
            return;
        }

        tail = tail.prev;
        tail.next = null;

        size--;
    }

    public void deleteIndex(int index){
        if(index == 0){
            deleteFirst();
            return;
        }
        if(index == size-1){
            deleteLast();
            return;
        }

        Node before = get(index-1);
        Node indexNode = get(index);

        before.next = indexNode.next;
        before.next.prev = before;

        size--;
    }

    private class Node{
        private Node next;
        private Node prev;
        private int val;

        public Node(){
            this.val = 0;
        }

        public Node(int val){
            this.val = val;
        }

        public Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }
}
//----------------------------------------------------------------------------
//Main function
//----------------------------------------------------------------------------
package com.company;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        DoublyLinkedList list1 = new DoublyLinkedList();

        list1.insertFirst(1);
        list1.insertFirst(2);
        list1.insertFirst(3);
        list1.insertFirst(4);
        list1.insertFirst(5);
        list1.insertLast(0);

        list1.deleteIndex(2);
        list1.display();
    }
}
