package Kol1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ExpressionEvaluator {

    public static int evaluateExpression(String expression){
        Stack<Integer> stack = new Stack<Integer>();

        String buffer = "";
        char operator = '+';

        expression += '+';
        //Забелешка: Операцијата множење има предност пред операцијата собирање.

        for(int i = 0 ; i < expression.length() ; i++) {
            if(Character.isDigit(expression.charAt(i))) {
                buffer += expression.charAt(i);
            } else {
                if(operator == '*') {
                    stack.push(Integer.parseInt(buffer) * stack.pop());
                } else if(operator == '+') {
                    stack.push(Integer.parseInt(buffer));
                }

                buffer = "";
                operator = expression.charAt(i);
            }
        }

        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println(evaluateExpression(input.readLine()));
    }

}