import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int code = str.charAt(i);

            if (code >= 65 && code <= 90) {
                code += 13;

                if (code > 90) {
                    int shift = code - 91;
                    code = 65 + shift;
                }
            }

            if (code >= 97 && code <= 122) {
                code += 13;

                if (code > 122) {
                    int shift = code - 123;
                    code = 97 + shift;
                }
            }

            sb.append((char)code);
        }

        System.out.println(sb);

    }
}
