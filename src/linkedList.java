import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class linkedList {
    static node head = null;
    // node a,b;

    static class node {
        String val;
        node next;

        public node(String val) {
            this.val = val;
        }
    }

    //no need to change the code here....
    node sortedMerge(node a, node b) {
        node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;


        int sumOftwoLetters = 0;
        int sumOftwoLetterscompare = 0;


        sumOftwoLetters = (int)(a.val.charAt(0)*Math.pow(26,1) + a.val.charAt(1)*(Math.pow(26,0)));
        sumOftwoLetterscompare = (int)(b.val.charAt(0)*Math.pow(26,1) + b.val.charAt(1)*(Math.pow(26,0))) ;

        /* Pick either a or b, and recur */
        if ((sumOftwoLetters) <= (sumOftwoLetterscompare)){
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else{
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;

    }

    node mergeSort(node h) {
        // Base case : if head is null
        if (h == null || h.next == null)
        {
            return h;
        }

        // get the middle of the list
        node middle = getMiddle(h);
        node nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        node left = mergeSort(h);

        // Apply mergeSort on right list
        node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // function to get the middle of the linked list
    node getMiddle(node h) {
        //Base case
        if (h == null)
            return h;
        node fastptr = h.next;
        node slowptr = h;

        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }

    //understand how it is linking.....
    void push(String new_data) {
        /* allocate node */
        node new_node = new node(new_data);

        /* link the old list off the new node */
        new_node.next = head;

        /* move the head to point to the new node */
        head = new_node;
    }

    //function to print the linked list
    static void printList(node headref) {
        System.out.print("[");
        while (headref != null)
        {
            System.out.print(headref.val + ", ");
            headref = headref.next;
        }
        System.out.println("]");
    }

    static void printListAlpha(node headref, String data){
        int count =0;
        int userData = data.charAt(0);
        char compareChecker;
        while(headref!=null){
            compareChecker = headref.val.charAt(0);
            if(userData == (int)compareChecker){
                System.out.println(headref.val);
                headref = headref.next;
                count++;
            }else
                headref = headref.next;

        }
        System.out.println("Number of those letters are: "+ count);
    }

    static void deleteList(linkedList.node spot) {
        if(spot == head){
            deleteAtFront();
            printList(head);
        }
        linkedList.node current = spot;
        linkedList.node previous = head;
        while (previous.next != current) {
            previous = previous.next;
        }
        previous.next = current.next;
        printList(head);

    }

    static void deleteAtFront(){

        head = head.next;
        printList(head);
    }

    static node findNode(String num){
        linkedList.node current, ret;
        current = head;
        while(!current.val.equals(num)){
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

    public static void main(String[] args) {
        linkedList li = new linkedList();

        Scanner input = new Scanner(System.in);

        String fileName = "/Users/utsav/Documents/DataStructure/ScaryLinkedList/src/names.txt";

        System.out.println("Enter a file name ");
        String fileNameUser = input.next();

        System.out.println("File doesnot exist in the path! "+ fileNameUser);
        System.out.println();

        System.out.println("Reading file names.txt insted ...");
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
                li.push(line);
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

        System.out.println("\n");
        System.out.println("------------------------------|");
        System.out.println("Displaying the unsorted list: |");
        System.out.println("------------------------------|");
        li.printList(li.head);

        System.out.println("\n");
        System.out.println("------------------------------|");
        System.out.println("Displaying the sorted list: |");
        System.out.println("------------------------------|");
        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        li.printList(li.head);

        System.out.println();
        System.out.println("--------------------------------- |");
        System.out.println("Enter the node you want to delete!|");
        System.out.println("----------------------------------|");


        String userInputDelete = input.next();
        linkedList.node current = findNode(userInputDelete);
        if(current.equals(null)){
            System.out.println("Invalid name entered! ");
        }else {
            deleteList(current);
        }

        System.out.println("");
        System.out.println("");
        System.out.println("Enter the Alphabet to get all the related values.");
        String userInput = input.next();
        printListAlpha(li.head, userInput);

    }
}


