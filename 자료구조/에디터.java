import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) { //왼쪽 스택에 입력받은 문자열을 전부 넣는다.
            left.push(s.charAt(i) + "");
        }


        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            String c = st.nextToken();
            switch (c) {
                case "L":
                    if (!left.isEmpty())
                        right.push(left.pop());
                    break;
                case "D":
                    if (!right.isEmpty())
                        left.push(right.pop());
                    break;
                case "B":
                    if (!left.isEmpty())
                        left.pop();
                    break;
                case "P":
                    left.push(st.nextToken());
                    break;
            }
        }

        while (!left.isEmpty())
            right.push(left.pop());

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);
    }

}