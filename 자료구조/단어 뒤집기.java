import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);

            sb = new StringBuilder();
            while (st.hasMoreTokens()) {
                String word = st.nextToken();

                for (int j = word.length() - 1; j >= 0 ; j--) {
                    sb.append(word.charAt(j));
                }
                sb.append(" ");
            }
            System.out.println(sb);
            
        }
    }
}