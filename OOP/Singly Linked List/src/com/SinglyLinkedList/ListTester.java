package com.SinglyLinkedList;

public class ListTester {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addTail(3);
        sll.addTail(4);
        sll.addTail(10);
        sll.addTail(5);
        sll.addTail(15);
        sll.addTail(2);
        sll.removeTail();
        sll.removeTail();
        sll.printValues();
        System.out.println(sll.find(20));
        sll.removeAt(4);
        System.out.println("************************");
        sll.printValues();
    }
}
