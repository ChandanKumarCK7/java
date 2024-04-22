import DesignPatterns.Singleton;









import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.*;

// Implement a stack data structure in Java using arrays or linked lists.

class Node{
    int v;
    Node next;

    public Node(int v){
        this.v = v;
        this.next = null;
    }
    public Node(){

    }
}

class Stack{
    Node head;
    Node start;

    public Stack(Node head){
        this.head = head;
        this.start = head;
    }

    public void push(int v){
        Node n = new Node(v);
        head.next = n;
        head = head.next;
    }

    public void pop(){
        Node prev = start;
        Node temp = start;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
        head = prev;



    }

    public void display(){
        while(start != null){
            System.out.println(start.v);
            start = start.next;
        }
    }



}


public class File11 {
    public static void main(String[] args) {







    }
}
