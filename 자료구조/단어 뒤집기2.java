import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean tag = false;

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '<') {
                tag = true;

                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                sb.append(ch);
            } else if (ch == '>') {
                tag = false;
                sb.append(ch);
            } else if (!tag) {
                if (ch == ' ') {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch);
                } else {
                    stack.add(ch);
                }
            } else if (tag) {
                sb.append(ch);
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

}