import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;

        String str;
        int[] count;

        while ((str = br.readLine()) != null) {
            count = new int[4];

            sb = new StringBuilder();

            for (int i = 0; i < str.length(); i++) {
                int code = str.charAt(i);

                if (code >= 97 && code <= 122) {
                    count[0]++;
                }
                if (code >= 65 && code <= 90) {
                    count[1]++;
                }
                if (code >= 48 && code <= 57) {
                    count[2]++;
                }
                if (code == 32) {
                    count[3]++;
                }
            }

            for (int i : count) {
                sb.append(i).append(" ");
            }

            System.out.println(sb);
        }
    }
}
