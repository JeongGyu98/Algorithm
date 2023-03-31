import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        long fx[] = new long[1000001];
        long dp[] = new long[1000001];

        Arrays.fill(fx, 1);

        for (int i = 2; i < fx.length; i++) {
            for (int j = 1; i * j < fx.length; j++) {
                fx[i * j] += i;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i] += dp[i - 1] + fx[i];
        }

        while (t-- > 0) {
            int input = Integer.parseInt(br.readLine());
            sb.append(dp[input]).append("\n");
        }
        System.out.println(sb);

    }
}
