import java.util.*;
import java.io.*;

public class Main {

   static StringBuilder sb = new StringBuilder();
   static int N, M;
   static boolean[] visited;
   static int[] arr;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      visited = new boolean[N];
      arr = new int[M];

      dfs(0);

      System.out.println(sb);

   }

   private static void dfs(int d) {

      if (d == M) {
         for (int val : arr) {
            sb.append(val).append(" ");
         }
         sb.append("\n");
         return;
      }

      for (int i = 0; i < N; i++) {
         if (!visited[i]) {
            visited[i] = true;
            arr[d] = i + 1;
            dfs(d + 1);
            visited[i] = false;
         }
      }
   }

}