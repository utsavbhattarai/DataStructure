import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Node {
    String data;
    Node next;
    int nameCode;
    int size;
}

class ScaryLinkedList {
    static Node front;

    static  int checkTrue;

    static Scanner inputShow = new Scanner(System.in);

    static int lengthofTheList;

    static String[] arraySorting;

    static int countLoop = 0;

    static void init() {
        front = null;

    }

    static Node findNode(String num){
        Node current, ret;
        current = front;
        while(!current.data.equals(num)){
            if(current.next == null)
                break;
            current = current.next;
        }
        if(current.equals(null)){
            ret = null;
        }else
            ret = current;
        return ret;
    }

    static void basicMe(String stringNode) {
        Node tail;
        if (countLoop == 0) {
            init();
        }
        //letter haru sort gardai add gardai janeh.....
        if (front == null) {
            Node newNode = makeNode(stringNode);
            newNode.next = front;
            front = newNode;
        } else {
            tail = findTail();
            tail.next = makeNode(stringNode);
        }
        countLoop++;

    }

    static int countObjects() {
        Node current, currarr;
        currarr = front;
        current = front;
        int arraCount = 1;
        while (current.next != null) {
            current = current.next;
            arraCount++;
        }
        return arraCount;
    }

    static Node findTail() {
        Node current;
        current = front;
        while (current.next != null)
            current = current.next;
        return current;
    }

    static Node makeNode(String name) {
        Node newNode = new Node();
        newNode.data = name;
        newNode.next = null;
        return newNode;
    }

    static void sortList() {
        int count = 0;
        Node current = front;
        int arraCount = countObjects();
        arraySorting = new String[arraCount];
        while (current != null) {
            arraySorting[count] = current.data;
            current = current.next;
            count++;
        }
        Arrays.sort(arraySorting);
        System.out.println(Arrays.toString(arraySorting));


    }

    static void showList() {
        Node current;
        current = front;
        System.out.println();
        //System.out.println("Enter the lenght of the list");
        //lengthofTheList = inputShow.nextInt();
            System.out.print("[");
            while (current != null) {
                System.out.print(current.data + ", ");
                current = current.next;


        }
        System.out.print("]");
    }

    static void deleteList(Node spot) {
        if(spot == front){
            deleteAtFront();
            sortList();
        }
        Node current = spot;
        Node previous = front;
        while (previous.next != current) {
            previous = previous.next;
        }
        previous.next = current.next;
        sortList();

    }

    static void deleteAtFront(){

        front = front.next;
        showList();
    }

    static void indexList(char fromUser){
        int count = 0;
        for(int i=0; i<arraySorting.length; i++){
            if((arraySorting[i].charAt(0)) == fromUser){
                System.out.println(arraySorting[i]);
                count++;
            }
        }
        System.out.println("The length of the section of the list is " + count);

    }

    public static void main(String[] args) {
        char searchIndex;
        String fileNameUser;

        Scanner input = new Scanner(System.in);

        String fileName = "/Users/utsav/Documents/DataStructure/ScaryLinkedList/src/names.txt";

        System.out.println("Enter a file name ");
        fileNameUser = input.next();

        System.out.println("File doesnot exist in the path! "+ fileNameUser);
        System.out.println();

        System.out.println("Reading file names.txt insted ...");

        System.out.println("Enter the lenght of the list");


        // This will reference one line at a time
        String line = null;
        int count = 0;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                basicMe(line);
                count++;
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        System.out.println("------------------------------|");
        System.out.println("Displaying the unsorted list: |");
        System.out.println("------------------------------|");
        showList();

        System.out.println();
        System.out.println("------------------------------|");
        System.out.println("Displaying the sorted list    |");
        System.out.println("------------------------------|");
        sortList();

        System.out.println();
        System.out.println("--------------------------------- |");
        System.out.println("Enter the node you want to delete!|");
        System.out.println("----------------------------------|");


        String userInputDelete = input.next();
        Node current = findNode(userInputDelete);
        if(current.equals(null)){
            System.out.println("Invalid name entered! ");
        }else {
            deleteList(current);
        }

        //change the showlist in the  delete first into sorted list.....
        System.out.println();
        System.out.println();
        System.out.println("-----------------------------------------------------------");
        System.out.println("Enter an alphabet to search according to the alphabet. ");
        searchIndex = input.next().charAt(0);
        System.out.println("-----------------------------------------------------------");
        indexList(searchIndex);
    }
}
