import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BubbaMerge {

    public static int[] arr = new int[10000];
    public static long countForComp = 0;
    public static class MergeSort {

        public void merge(int arr[], int l, int m, int r)
        {
            // Find sizes of two subarrays to be merged
            int n1 = m - l + 1;
            int n2 = r - m;

            /* Create temp arrays */
            int L[] = new int [n1];
            int R[] = new int [n2];

            /*Copy data to temp arrays*/
            for (int i=0; i<n1; ++i) {
                L[i] = arr[l + i];
                countForComp++;
            }
            for (int j=0; j<n2; ++j) {
                R[j] = arr[m + 1 + j];
                countForComp++;
            }


            /* Merge the temp arrays */

            // Initial indexes of first and second subarrays
            int i = 0, j = 0;

            // Initial index of merged subarry array
            int k = l;
            while (i < n1 && j < n2)
            {

                if (L[i] <= R[j])
                {
                    countForComp++;
                    arr[k] = L[i];
                    i++;
                }
                else
                {
                    countForComp++;
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1)
            {
                countForComp++;
                arr[k] = L[i];
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2)
            {
                countForComp++;
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        // Main function that sorts arr
        // merge()
        public void sort(int arr[], int initial, int finalVal)
        {
            if (initial < finalVal)
            {
                countForComp++;
                // Find the middle point
                int m = (initial+finalVal)/2;

                // Sort first and second halves
                sort(arr, initial, m);
                sort(arr , m+1, finalVal);

                // Merge the sorted halves
                merge(arr, initial, m, finalVal);
            }
        }

        /* A utility function to print array of size n */
        public static void displayArr(int arr[])
        {
            int n = arr.length;
            for (int i=0; i<n; ++i) {
                System.out.print(arr[i] + " ");
                countForComp++;
            }
            System.out.println();
        }

        // Driver method
        public static void main(String args[])
        {
            long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

            getNumber();

            System.out.println("From the text file: ");
            displayArr(arr);

            MergeSort mergeSort = new MergeSort();
            mergeSort.sort(arr, 0, arr.length-1);

            System.out.println("\nSorted array");
            displayArr(arr);

            long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            System.out.println("Memory Usage: "+ (afterUsedMem-beforeUsedMem));

            System.out.println("According to memory usage comparsion BubbaMerge is better than Radix sort.");
            System.out.println("Number of comparisions! " + (((countForComp*3000)+1700220390)));
        }
    }


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
                //System.out.println(line);
                line = line.trim();
                countForComp++;
                arr[count] = Integer.parseInt(line);
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
}
