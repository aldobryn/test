package com.dobrynland.crackcode;

public class MyList
{
    Node head;

    public MyList(){
        head = null;
    }
    public void addNode(Integer i)
    {
        if(head == null){
            head = new Node(i);
        }
        else {
            Node n = new Node(i);
            Node iter = head;
            while (iter.next != null)
                iter = iter.next;

            iter.next = n;
        }
    }
    public void deleteNode(Integer i)
    {
        if(head.data.equals(i)){
            head = head.next;
            return;
        }
        Node n = head;
        while(n.next != null){
            if(n.next.data.equals(i)){
                n.next = n.next.next;
                return;
            }
            n = n.next;
        }
    }
    public void printList(){
        Node n = head;
        while(n.next != null){
            System.out.println(n.data);
            n = n.next;
        }
        System.out.println(n.data);
    }
    public static void main(String[] args){
        MyList list = new MyList();
        list.addNode(2);
        list.addNode(5);
        list.addNode(8);
        list.addNode(9);
        list.addNode(10);
        list.printList();
        System.out.println();
        list.deleteNode(5);
        list.printList();

    }
}
