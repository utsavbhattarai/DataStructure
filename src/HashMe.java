public class HashMe {
    String fname;
    String hashTable[];
    int tabLen;
    int numSmashes;

    public HashMe(int hashTableLen){
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

    private void getFileName(){

    }

    private void readFileContents(){

    }

    private void showHashTable() {
    }



}
