import java.util.Scanner;

public class Node {
    int data;
    Node next;

}

class LinkedList{
    static Node front;


    static void init(){
        front = null;
    }

    static Node makeNode(int num){
        Node n = new Node();
        n.data = num;
        n.next = null;
        return n;
    }

    static Node makeNodeN(int num){
        Node n = new Node();
        n.data = num;
        return n;
    }

    static Node findTail(){
        Node current;
        current = front;
        while(current.next!=null)
            current = current.next;
        return current;
    }

    static void basicMe(int numNode){
        Node tail;
        init();
        for(int i = 0; i<numNode; i++){
            if(i == 0){
                front = makeNode(i);
            }else {
                tail = findTail();
                tail.next = makeNode(i);
            }
        }
    }

    static void showList(){
        Node current;
        current = front;
        System.out.print("[");
        while(current!=null){
            System.out.print(current.data+ ",");
            current = current.next;
        }
        System.out.println("]");
    }

    static Node findNode(int num){
        Node current;
        current = front;
        while(current.data != num){
            current = current.next;
        }
        return current;
    }

    static void deleteList(Node spot){
        Node current = spot;
        Node previous = front;
        while (previous.next!=current){
            previous = previous.next;
        }
        previous.next = current.next;
        showList();

    }


    static void insertAfter(Node current){
        Node newNode;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter value");
        int num = input.nextInt();
//        new node with the value num will be created
        newNode = makeNode(num);

        newNode.next = current.next;
        current.next = newNode;
    }

    static void deleteAtFront(){

        front = front.next;
        showList();
    }

    static void insertAtFirst(){
        Node nwNode = makeNodeN(5);
        Node current = front;
        nwNode.next = front;
        front = nwNode;
        showList();
    }



    public static void main(String[] args) {
        int number;
        Node current;
        int delNumber;
        int insertAfter;
        Scanner input = new Scanner(System.in);
        System.out.println("How many node you want in the list?");
        number = input.nextInt();
        basicMe(number);
        showList();
        System.out.println(" ");
        System.out.println("Which node do you want to place your new node after? ");
        insertAfter = input.nextInt();
        current = findNode(insertAfter);
        insertAfter(current);
        showList();
        System.out.println(" ");
        System.out.println("Enter the value of the node you wanna delete");
        delNumber = input.nextInt();
        current = findNode(delNumber);
        deleteList(current);
        insertAtFirst();
        deleteAtFront();

    }
}