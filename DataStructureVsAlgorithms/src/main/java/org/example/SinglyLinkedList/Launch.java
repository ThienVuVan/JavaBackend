package org.example.SinglyLinkedList;

public class Launch {
    public static void main(String[] args) {

//        MySinglyLinkNode linkList = new MySinglyLinkNode(5);
//        linkList.pushBack(linkList, new MySinglyLinkNode(6));
//        linkList.pushBack(linkList, new MySinglyLinkNode(7));
//        linkList.pushFront(linkList, new MySinglyLinkNode(4));

//        while(linkList != null){
//            System.out.println(linkList.value);
//            linkList = linkList.next;
//        }
        MyLinkList list = new MyLinkList(new MySinglyLinkNode(5));
        list.pushBack(new MySinglyLinkNode(6.6));
        list.pushBack(new MySinglyLinkNode("string"));
        list.pushFront(new MySinglyLinkNode("vu van thien"));
        list.print();
    }
}
