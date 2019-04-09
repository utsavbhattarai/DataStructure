public class StackThingsExercise1 {
    public static int top;
    public static char[] arrayStack = new char[100];

    public static void main(String args[]){

        init();

//        String name1 = "Bob";
//        String name1 = "eat nomel";
//        String name1 = "snoino dna revil etah I";
        String name1 = "SELUR LOBOC";

        for(int i = 0; i<name1.length(); i++){
            if(i == 0){
                init();
            }
            pushToStack(name1.charAt(i), arrayStack);
        }

        popFromStack(arrayStack);
    }

    static void init(){
//        set the top of the stack to -1
        top = -1;
    }

    static void pushToStack(char x, char[] arrayStack){
//        increment the stack and add the characters into the stack
        top = top+1;
        arrayStack[top] = x;
    }



    static void popFromStack(char[] arrayStack){
//        pop the last item from the stack and decrement the stack point value
        for(int i = top; i<arrayStack.length; i--){
            System.out.print(arrayStack[i]);
            top-=1;
            if(top == -1)
                break;
        }
        top = -1;
    }
}
