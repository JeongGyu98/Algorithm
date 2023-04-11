import java.util.*;
import java.io.*;

public class Main {

   static int N, M;
   static int[] arr;
   static boolean[] visit;
   static StringBuilder sb;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      sb = new StringBuilder();

      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      arr = new int[M + 1];
      visit = new boolean[N + 1];

      dfs(1,0);
      System.out.println(sb);
   }

   static void dfs(int at, int depth) {

      if (depth == M) {
         for (int i = 0; i < M; i++) {
            sb.append(arr[i]).append(" ");
         }
         sb.append("\n");
         return;
      }

      for (int i = at; i <= N; i++) {
         if (!visit[i]) {
            visit[i] = true;
            arr[depth] = i;

            dfs(i + 1,depth + 1);
            visit[i] = false;
         }
      }
   }
}