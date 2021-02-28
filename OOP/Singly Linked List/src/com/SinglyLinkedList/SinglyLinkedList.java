package com.SinglyLinkedList;

public class SinglyLinkedList {
    public Node head;
    public SinglyLinkedList() {
        this.head = null;
    }
    // SLL methods go here. As a starter, we will show you how to add a node to the list.
    public void addTail(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while(runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void removeTail() {
        if (this.head == null)
            System.out.println("Linked list is empty");
        else if (this.head.next == null) {
            this.head = null;
        } else {
            Node current = this.head;
            while (current.next.next != null)
                current = current.next;
            current.next = null;
        }
    }

    public void printValues() {
        if (this.head == null)
            System.out.println("Linked list is empty");
        else {
            Node current = this.head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
        }
    }

    public Node find(int element) {
        if (this.head == null)
            return null;
        Node current = this.head;
        while (current != null) {
            if (current.value == element)
                return current;
            current = current.next;
        }
        return null;
    }

    public void removeHead() {
        if (this.head == null)
            System.out.println("Linked list is empty");
        else {
            Node newHead = this.head.next;
            this.head = newHead;
        }
    }

    public void removeAt(int index){
        if (this.head == null)
            System.out.println("Linked list is empty");
        else {
            int counter = 0;
            if (counter == index)
                this.removeHead();
            else {
                Node previous =this.head;
                Node current = this.head.next;
                while (current.next != null){
                    counter++;
                    if (counter == index)
                        previous.next = current.next;
                    previous = previous.next;
                    current = current.next;
                }
                counter++;
                if (counter == index)
                    this.removeTail();
                else
                    System.out.println("Index out of bound!");
            }
        }
    }
}
