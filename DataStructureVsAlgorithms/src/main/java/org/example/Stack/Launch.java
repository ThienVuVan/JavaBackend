package org.example.Stack;

import org.example.SinglyLinkedList.MySinglyLinkNode;

public class Launch {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(3);
        myStack.push("thien");
        myStack.push(4.5);
        myStack.pop();
        myStack.print();

    }
}
