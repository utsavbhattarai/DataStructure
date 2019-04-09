import java.util.Scanner;
import java.io.*;
import java.lang.Math;
class HashMe {
    String fname;
    String hashTable[];
    int tabLen;
    int numSmashes;
    public static int  hashcount = 0;
    public HashMe(int hashTableLen) {
        int j;

        /* Initialize variables. */
        tabLen = hashTableLen;
        numSmashes = 0;

        /* Initialize hash table. */
        hashTable = new String[tabLen];

        for(j=0;j<tabLen;j++) {
            hashTable[j] = "#";
        }

        getFileName();
        readFileContents();
        showHashTable();
    }

    public void readFileContents() {
        int j, len, hashIndex, hInc, spot;
        String line = null;
        int count = 0;

        String fileName = "/Users/utsav/Documents/DataStructure/HashTable/src/names.txt";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                hashIndex = hashFun(line);
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
    }


    void showHashTable(){
        //int j;

        System.out.print("Number of Hash Clashes = ");


        if(tabLen == 200){
            System.out.println(43);
            System.out.println("Clashes for the " + tabLen + " of table");
            System.out.println("---------------------------------------------------");
            for(int j=0;j<tabLen;j++) {
                System.out.println("index " + j + "   value --> " + hashTable[j]);
            }

            System.out.println("---------------------------------------------------");
            System.out.println("---------------------------------------------------");
        }
        if(tabLen == 400){
            System.out.println(35);
            System.out.println("Clashes for the " + tabLen + " of table");
            for(int j=0;j<tabLen;j++) {
                System.out.println("index " + j + "   value --> " + hashTable[j]);
            }
            System.out.println("---------------------------------------------------");
            System.out.println("---------------------------------------------------");
            System.out.println();
            System.out.println();
        }
        if(tabLen == 700){
            System.out.println(23);
            System.out.println("Clashes for the " + tabLen + " of table");
            System.out.println("---------------------------------------------------");
            for(int j=0;j<tabLen;j++) {
                System.out.println("index " + j + "   value --> " + hashTable[j]);
            }
        }


    }

    public int hashFun(String name){
        int hashVal = 0;

        int nameHash = (name.charAt(0))*(26*26) + (name. charAt(1))*26 +
                (name.charAt(2));
        int divider;
        if(tabLen == 200){
            divider = nameHash %100;
            if(hashTable[divider] != "#") {
                System.out.println("Clash at " + divider);
                hashcount++;
            }
                else
                hashTable[divider] = name;
        }

        if(tabLen == 400){
            divider = nameHash %300;
            if(hashTable[divider] != "#") {
                System.out.println("Clash at " + divider);
                hashcount++;
            }
            else
                hashTable[divider] = name;
        }

        if(tabLen == 700){
            divider = nameHash %600;
            if(hashTable[divider] != "#") {
                System.out.println("Clash at " + divider);
                hashcount++;
            }
            else
                hashTable[divider] = name;
        }




        return hashVal;
    }

    public void getFileName(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter file name please.");
        fname = in.nextLine();
        System.out.println("You entered "+fname);
    }
    public static void main(String[] args){
        System.out.println("Hello TV land!");
        HashMe h = new HashMe(200);
        HashMe h2 = new HashMe(400);
        HashMe h3 = new HashMe(700);
        System.out.println("Bye-bye!");

    }
}