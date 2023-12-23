package org.example.Stack;

public class MyStack <T> {
    Node head = null;
    public void push(T value){
        Node<T> node = new Node<>(value);
        if(head == null){
            head = node;
        }
        else{
            Node temp = head;
            head = node;
            head.next = temp;
        }
    }
    public void pop(){
        head = head.next;
    }
    public void print(){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
