import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder sb = new StringBuilder();

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            int base = 1;
            int cnt = 1;

            while ((base = base % n) != 0) {
                cnt ++;
                base = base * 10 + 1;
            }
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
