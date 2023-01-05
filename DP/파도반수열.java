import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int T;
    static long[] P = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        int a = 0;

        P[1] = 1;
        P[2] = 1;
        P[3] = 1;

        for (int i = 0; i < T; i++) {
            a = Integer.parseInt(br.readLine());
            for(int j = 4; j <= a; j ++){
                P[j] = P[j - 2] + P[j - 3];
            }
            sb.append(P[a] + "\n");
        }

        System.out.println(sb);
    }

}
