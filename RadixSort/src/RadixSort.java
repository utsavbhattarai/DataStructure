public class RadixSort {








    public static void main(String[] args) {
        String[] arr =  new String[] {"0010","0201", "0003", "0005","0000"};
        String[][] bucket = new String[10][10];

        int count =0;
        do{
            int p = 0;

            for(int i =0; i<arr.length; i++){
                //pass 1
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
                for(int j =0; j<10; j++){
                    if(bucket[i][j]!=null){
                        arr[p] = bucket[i][j];
                        bucket[i][j] = null;
                        p++;
                    }

                }
            }
            count++;
        }while(count<4);

        for(String i: arr)
            System.out.println(i);
    }
}
