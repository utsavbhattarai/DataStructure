import java.io.*;
import java.util.Scanner;

public class Exercise6CFile {
    public static void main(String[] args) throws IOException {
        Exercise6a ex6 = new Exercise6a();
//        read the file from the text and send to the following method.
        String fileName = "exercise6c.txt";
        BufferedReader br = new BufferedReader(new FileReader("exercise6c.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
        } finally {
            br.close();


            if (ex6.is_parentheses_balanced("")) {

            } else {
                System.out.println("The equation is invalid!");
            }


        }


    }
}