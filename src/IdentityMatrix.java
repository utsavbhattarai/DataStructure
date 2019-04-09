public class IdentityMatrix {
    public static void main(String[] args){

        int[][] arrayMatrix = new int[5][5];
        int increment = 0;
        for(int i =0; i<5; i++){
            for(int j = 0; j<5; j++){
              arrayMatrix[increment][increment] = 1;
            }
            increment++;
        }
    }
}
