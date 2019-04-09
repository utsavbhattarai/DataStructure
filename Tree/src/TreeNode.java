import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TreeNode {
    public int data;
    public TreeNode left, right;
}

class TreeWork{
    static TreeNode root;
    static int countForBuildingBinaryTree = 0;
    static int countNumberForArray = 0;
    static int[] arraySortedStorage = new int[1000];
    static int[] fileToArray  = new int[1000];

    //initializing tree.
    static void init(){
         root = null;
    }

    //make the treenode with data and right and left pointing to null
    static TreeNode makeTreeNode(int data){
        TreeNode treeNode;
        treeNode = new TreeNode();
        treeNode.data = data;
        treeNode.left = null;
        treeNode.right = null;

        return treeNode;
    }

    //sets the child node to point towards left.
    static void setLeft(TreeNode t, int num){
        if(t.left != null){
            System.out.println("Error: left node already exists.");
        }else{
            t.left = makeTreeNode(num);
        }

    }

    //this method sets the node to point ot the right
    static void setRight(TreeNode t, int num){
        if(t.right != null){
            System.out.println("Error: left node already exists.");
        }else{
            t.right = makeTreeNode(num);
        }
    }

    //this method builds the binaryTree
    static void buildingBinaryTree(int data){
        if(countForBuildingBinaryTree == 0) {
            init();
            countForBuildingBinaryTree++;
        }
        //create root of the tree
        //once the list has been initialized. read the data accordingly...
        if(root == null){
            root = makeTreeNode(data);
        }else{
            //find position number in a tree
            TreeNode curr = root;
            boolean searching = true;
            while (searching){
                if(data < curr.data){
                    if(curr.left!=null){
                        curr = curr.left;
                    }else{searching = false;}
                }else {
                    if(curr.right!=null){
                        curr = curr.right;
                    }else {searching = false;}
                }
            }
            //add number in the tree
            if(data < curr.data)
                setLeft(curr,data);
            else
                setRight(curr,data);
        }
    }

    //prints the node in the correct form
    static void inOrder(TreeNode t){
        //go left
        if(t.left!=null){
            inOrder(t.left);
        }
        arraySortedStorage[countNumberForArray] = t.data;
        System.out.print(t.data + " ");
        countNumberForArray++;
        if(t.right!=null){
            inOrder(t.right);
        }

        //if the above doesnot work---- uncomment the code below
//        if (t == null)
//            return;
//
//        /* first recur on left child */
//        inOrder(t.left);
//
//        /* then print the data of node */
//        System.out.print(t.data + " ");
//
//        /* now recur on right child */
//        inOrder(t.right);
    }

    //this method reads from the file and adds into array
    static void readIntoArray(int index, int num){
        fileToArray[index] = num;

    }

    //this method sorts the array using bubblesort
    static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]){
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    //prints the content of the array
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        String fileName = "/Users/utsav/Documents/DataStructure/Tree/src/numbers.txt";
        // This will reference one line at a time
        String line = null;
        int count = 0;

        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                buildingBinaryTree(Integer.parseInt(line));
                readIntoArray(count,Integer.parseInt(line));
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

        System.out.println("There are 10 compares made to built the ordered tree.");
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        inOrder(root);

        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("");
        long beforeUsedMemArr=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        bubbleSort(fileToArray);
        System.out.println("");
        System.out.println("Sorted output from Array. With one comparision.");
        printArray(fileToArray);
        long afterUsedMemArr=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("");
        System.out.println("Interms of compares made, bubble sort has less number of comparison.");
        System.out.println("---------------------------------------------------------------------");

        System.out.println("Interms of memory Usage:");
        System.out.println("--------------------------");
        System.out.println("Tree used " + (afterUsedMem-beforeUsedMem) + " bytes of memory.");
        System.out.println("Array used " + (afterUsedMemArr-beforeUsedMemArr) + " bytes of memory.");
        if((afterUsedMem-beforeUsedMem) > (afterUsedMemArr-beforeUsedMemArr)){
            System.out.println("");
            System.out.println("1. Array is more efficient in terms of memory.");
        }else{
            System.out.println("Tree is more efficient.");
        }


        System.out.println("2. Tree was more fun to write.");




    }
}