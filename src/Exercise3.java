public class Exercise3 {
    public static int front;
    public static int rear;
    public static char[] queue = new char[100];

    public static void main(String[] args) {
        String name1 = "Bob";
//        String name1= "eat too much";
//        String name1 = "I love greasy food”;
//        String name1 = "FORTRAN 77 RULES”;
        init();
        for(int i=0; i<name1.length(); i++){
            pushQ(name1.charAt(i));
        }

        for(int p = 0; p<name1.length(); p++){
            if(name1.charAt(p) == 0)
                break;
            System.out.print(popQ());

        }
    }

    public static void init(){
        front =0;
        rear = -1;
    }

    static void pushQ(char x){
        rear = rear+1;
        queue[rear] = x;
    }

    static char popQ(){
        char x;
        x = queue[front];
        front+=1;
        return x;
    }

    static boolean isQEmpty(){
        boolean empty;
        empty = false;
        if(front >= rear) {
            empty = true;
        }
        return empty;

    }
}
