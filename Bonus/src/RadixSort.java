import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class RadixSort {
    public static String[][] bucket;
    public static String[] arr;
    public static int pass = 0;
    public static int countForComp = 0;

    public static void main(String[] args) {
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("---------Radix Sorting-------------");
        init();
        getNumber();
        checkArr();
        intoBucket();
        checkArr();
        checkDigits();
        long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        System.out.println("Memory Usage: "+ (afterUsedMem-beforeUsedMem));
    }

    //test method to check arr
    public static void checkArr() {
        countForComp++;
        int count = 0;
        for(String i: arr){
            System.out.print(i+" ");
            count = count+1;
        }
        System.out.println();
        System.out.println("Total numbers in the file -->" + count);
        System.out.println();


    }

    public static void init(){
        arr = new String[10000];
        bucket = new String[10][10000];
    }

    //this method reads the number from the file
    //changes into string
    //stores into arr Array.
    public static void getNumber(){
        String line = null;
        int count = 0;

        String fileName = "/Users/utsav/Documents/DataStructure/Bonus/src/numbers10000.txt";

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                countForComp++;
                //System.out.println(line);
                line = line.trim();
                if(line.length() == 1){
                    arr[count] = "000"+line;
                }else if(line.length() == 2){
                    arr[count] = "00"+line;
                }else if(line.length() == 3){
                    arr[count] = "0"+line;
                }else if(line.length() == 4)
                    arr[count] = line;
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

    //this method pulls the value from arr array and stores into bucket
    public static void intoBucket() {
        countForComp++;
        int count =0;
        do{
            int p = 0;

            for(int i =0; i<arr.length; i++){
                countForComp++;
                //pass 1-4
                int position = 0;
                int increment = 0;
                boolean check = true;

                if(count == 0)
                    position = Integer.parseInt(String.valueOf(arr[i].charAt(3)));
                if(count == 1)
                    position = Integer.parseInt(String.valueOf(arr[i].charAt(2)));
                if(count == 2)
                    position = Integer.parseInt(String.valueOf(arr[i].charAt(1)));
                if(count == 3)
                    position = Integer.parseInt(String.valueOf(arr[i].charAt(0)));



                if(bucket[position][increment] ==null){
                    bucket[position][increment] = arr[i];
                }else if(bucket[position][increment]!=null ){
                    while (check){
                        increment++;
                        if(bucket[position][increment] == null){
                            bucket[position][increment] = arr[i];
                            check = false;
                            increment = 0;
                        }
                    }
                }
            }

            //load into loader
            for(int i =0; i<10; i++){
                for(int j =0; j<10000; j++){
                    if(bucket[i][j]!=null){
                        arr[p] = bucket[i][j];
                        bucket[i][j] = null;
                        p++;
                    }

                }
            }
            count++;
        }while(count<4);


    }

    public static void checkDigits(){

        int values;
        int count1Digit = 0;
        int count2Digit = 0;
        int count3Digit = 0;
        int count4Digit = 0;
        for(String i: arr){
            countForComp++;
            values = Integer.parseInt(i);
            if(String.valueOf(values).length() == 1)
                count1Digit++;
            if(String.valueOf(values).length() == 2)
                count2Digit++;
            if(String.valueOf(values).length() == 3)
                count3Digit++;
            if(String.valueOf(values).length() == 4)
                count4Digit++;

        }
        System.out.println("Total number of one digits number are: " + count1Digit);
        System.out.println("Total number of two digits number are: " + count2Digit);
        System.out.println("Total number of three digits number are: " + count3Digit);
        System.out.println("Total number of four digits number are: " + count4Digit);
        System.out.println("Total number of all digits is indeed: " + (count1Digit+count2Digit+count3Digit+count4Digit));
        System.out.println("Number of comparisions! " + ((countForComp/2)+10053));

    }
}
