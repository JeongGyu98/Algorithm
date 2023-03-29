import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Double> stack = new Stack<>();

        double result = 0.0;
        int n = Integer.parseInt(br.readLine());
        double[] number = new double[n];

        String input = br.readLine();

        for (int i = 0; i < n; i++) {
            number[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if ('A' <= now && 'X' >= now) {
                stack.push(number[now - 'A']);
            } else {
                if (!stack.isEmpty()) {
                    double op1 = stack.pop();
                    double op2 = stack.pop();
                    switch (now) {
                        case '*':
                            result = op1 * op2;
                            stack.push(result);
                            continue;
                        case '/':
                            result = op1 / op2;
                            stack.push(result);
                            continue;
                        case '+':
                            result = op1 + op2;
                            stack.push(result);
                            continue;
                        case '-':
                            result = op1 - op2;
                            stack.push(result);
                            continue;
                    }
                }
            }
        }

        System.out.printf("%.2f", stack.pop());

    }


}
