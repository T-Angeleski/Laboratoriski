package Labs5.ModifiedXML;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Stack;

public class CheckXML {


    private static int checkValidity(String[] redovi, int n) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            if (redovi[i].charAt(0) == '[') {

                if (redovi[i].charAt(1) == '/') {

                    if (!stack.peek().equals(redovi[i].substring(2, redovi[i].length() - 1))) {
                        return 0;
                    } else stack.pop();

                } else {
                    stack.push(redovi[i].substring(1, redovi[i].length() - 1));
                }

            }
        }
        return 1;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        String[] redovi = new String[n];

        for (int i = 0; i < n; i++)
            redovi[i] = br.readLine();

        int valid = checkValidity(redovi, n);


        System.out.println(valid);

        br.close();
    }

}