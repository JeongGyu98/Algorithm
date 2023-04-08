import java.io.*;
import java.util.*;
public class Main {

   static int N;
   static int[] t, p, dp;

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      t = new int[N + 1];
      p = new int[N + 1];
      dp = new int[N + 2];

      for (int i = 1; i <= N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());

         t[i] = Integer.parseInt(st.nextToken());
         p[i] = Integer.parseInt(st.nextToken());

      }

      for (int i = N; i > 0; i--) {
         int next = i + t[i];

         if (next > N + 1) {
            dp[i] = dp[i + 1];
         } else {
            dp[i] = Math.max(dp[i + 1], p[i] + dp[next]);
         }
      }

      System.out.println(dp[1]);


   }
}
