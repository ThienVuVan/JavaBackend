package org.example.SinglyLinkedList;

public class MyLinkList {
    MySinglyLinkNode head;
    MySinglyLinkNode tail;

    public MyLinkList(MySinglyLinkNode mySinglyLinkNode) {
        this.head = mySinglyLinkNode;
        this.tail = mySinglyLinkNode;
    }

    public void pushBack(MySinglyLinkNode mySinglyLinkNode){
        tail.next = mySinglyLinkNode;
        tail = mySinglyLinkNode;
    }

    public void pushFront(MySinglyLinkNode mySinglyLinkNode){
        MySinglyLinkNode temp = head;
        head = mySinglyLinkNode;
        head.next = temp;
    }

    public void print(){
        MySinglyLinkNode temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
