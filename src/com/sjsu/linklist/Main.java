package com.sjsu.linklist;

        import java.util.LinkedList;

public class Main {

    Node head;
    static class Node{
        int data;
        Node next;

        Node(int d){
            this.data = d;
            next = null;
        }
    }


    public static void main(String[] args) {

        Main linkedList = new Main();

        linkedList.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        linkedList.head.next = second;
        second.next = third;
        linkedList.linkedListTraversal();
        linkedList.insertAtHead(4);

        System.out.print("\n ***************************************************** \n");

        linkedList.linkedListTraversal();

        System.out.print("\n ***************************************************** \n");
        linkedList.insertAfteraGivenNode(5, third);

        linkedList.linkedListTraversal();

        System.out.print("\n ***************************************************** \n");
        linkedList.insertAtTheEnd(2);

        linkedList.linkedListTraversal();
        System.out.print("\n ***************************************************** \n");
        linkedList.deleteFromLinedList(5);

        linkedList.linkedListTraversal();

        System.out.print("\n ***************************************************** \n");



    }

    public void linkedListTraversal(){

        Node n = head;
        while (n != null){
            System.out.print(n.data + " ");
            n = n.next;
        }

    }

    public void insertAtHead(int newData){

        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    public void insertAfteraGivenNode(int newData, Node givenNode){

        if (givenNode == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(newData);
        newNode.next = givenNode.next;
        givenNode.next = newNode;

    }

    public void insertAtTheEnd(int newData){

        Node newNode = new Node(newData);
        if(head == null){
            head = new Node(newData);
            return;
        }

        newNode.next = null;

        Node last = head;
        while (last.next != null)
            last = last.next;
        last.next = newNode;
        return;

    }

    public void deleteFromLinedList(int position){

        //LinkedList is empty
        if(head == null){
            return;
        }
        Node temp = head;
        if(position == 0){

            head = temp.next;
            return;
        }

        // Find previous node of the node to be deleted
        for(int i=0; i < position - 1 && temp != null; i++){
            temp = temp.next;
        }
        //if position is more than the number of nodes
        if(temp == null || temp.next == null){
            return;
        }

        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        // Unlink the deleted node from list
        temp.next = next;
    }
}
