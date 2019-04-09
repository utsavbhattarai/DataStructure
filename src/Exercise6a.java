import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Exercise6a {
    public static void main(String[] args) {
        String passStringToExercise6;
        Exercise6B exercise6B = new Exercise6B();
        Exercise6C exercise6C = new Exercise6C();
        // The name of the file to open.
        String fileName = "/Users/utsav/Documents/DataStructure/src/exercise6c.txt";

        // This will reference one line at a time
        String line = null;
        int count = 1;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
                if(count == 3 || count == 6 || count ==7){

                }else {
                    String check = line;
                    passStringToExercise6 = exercise6B.infixToPostfix(check);
                    System.out.println(exercise6C.evaluatePostfix(passStringToExercise6));
                }
                count++;
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

        ; // system input

    }

    public static boolean matchingPeer(char open , char close){
        if ( open == '(' && close == ')'){
            return true;
        }
        if ( open == '[' && close == ']'){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean is_parentheses_balanced(String equation){ // to check if Parentheses valid.

        char[] c = equation.toCharArray();
        Stack<Character> myStack= new Stack <Character> ();

        for (int i = 0; i < c.length; i++){
            if(c[i]=='(' || c[i] == '[' ){
                myStack.push(c[i]);
            }
            else if (c[i]== ')' || c[i]==']'){
                if(matchingPeer(myStack.peek(),c[i]) == true){
                    myStack.pop();

                } else {
                    return false;
                }
            }
        }
        if(myStack.isEmpty()){
            return true;
        }
        else {
            return false;
        }
    }
}
