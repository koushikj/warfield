package com.warfield.chatgpt;

public class LinkedListReverseInChunk {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
    public LinkedListReverseInChunk(){}
    public static LinkedListReverseInChunk reverseInChunks(LinkedListReverseInChunk list, int k) {
        Node current = list.head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            list.head.next = reverseInChunks(new LinkedListReverseInChunk(next), k).head;
        }
        list.head = prev;
        return list;
    }

    public LinkedListReverseInChunk(Node head) {
        this.head = head;
    }

    public static void main(String[] args) {
        LinkedListReverseInChunk list = new LinkedListReverseInChunk();
        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node forth = new Node(4);
        Node fifth = new Node(5);
        list.head.next = second;
        second.next = third;
        third.next = forth;
        forth.next = fifth;
        list = reverseInChunks(list, 3);
        Node n = list.head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }
}

