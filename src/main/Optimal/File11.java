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

//        String input = "-7.961383,37.035769,0 -7.961591000000001,37.035916,0 -7.961796,37.03606,0 -7.961975,37.036204,0 -7.962102,37.03632,0 -7.962209000000001,37.036446,0][-7.962209000000001,37.036446,0 -7.962533,37.036935,0 -7.962748,37.037372,0 -7.96283,37.037557,0][-7.96283,37.037557,0 -7.962983999999999,37.037933,0 -7.963109,37.038229,0 -7.963209999999999,37.038407,0 -7.963385,37.038629,0 -7.963380000000001,37.038629,0][-7.963380000000001,37.038629,0 -7.963941,37.039172,0 -7.963978,37.039212,0][-7.963978,37.039212,0 -7.964157,37.039405,0 -7.964327,37.039599,0 -7.964365,37.039668,0 -7.964374,37.039723,0 -7.964373,37.039735,0][-7.964373,37.039735,0 -7.964347999999999,37.039935,0 -7.964335000000001,37.040062,0 -7.964346,37.040173,0 -7.964408,37.040334,0 -7.964537,37.040674,0][-7.964537,37.040674,0 -7.964748,37.04113,0 -7.964926000000001,37.041467,0 -7.964974000000001,37.041544,0][-7.964974000000001,37.041544,0 -7.965222,37.041913,0][-7.965222,37.041913,0 -7.965241,37.041971,0 -7.965314999999999,37.042096,0 -7.965385,37.042203,0 -7.965432,37.04228,0 -7.96547,37.042363,0 -7.965494,37.042434,0 -7.965519,37.042508,0][-7.965519,37.042508,0 -7.965538,37.042657,0 -7.965551,37.04283,0 -7.965526,37.043194,0]";
        String s = "[76.92427767791487,11.31629029498346,0 77.16309854372524,11.36552146227293,0 77.11632234058779,11.23953307205388,0]";


//        s= s.substring(1, s.length()-1);
        s=  s.substring(1, s.length()-1);
        String[] coordinatesArray= s.split(" ");
        String startCoordinate = coordinatesArray[0];
        String lastCoordinate= coordinatesArray[coordinatesArray.length-1];
        System.out.println(Arrays.toString(coordinatesArray));
        System.out.println(startCoordinate + lastCoordinate);






    }
}
