import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int result = 0;
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= str.length(); i++) {
            if (str.charAt(i - 1) == '(') {
                stack.push(i);
            } else {
                if (i - stack.peek() == 1) {
                    stack.pop();
                    result = result + stack.size();
                } else {
                    stack.pop();
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
