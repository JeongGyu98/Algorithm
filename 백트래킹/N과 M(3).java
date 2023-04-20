import java.io.*;
import java.util.*;
public class Main {

   static int N, M;
   static int[] arr;
   static StringBuilder sb = new StringBuilder();
   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      arr = new int[M];

      dfs(0);
      System.out.println(sb);
   }

   public static void dfs(int depth) {

      if (M == depth) {
         for (int i = 0; i < M; i++) {
            sb.append(arr[i] + " ");
         }
         sb.append("\n");
         return;
      }

      for (int i = 1; i <= N; i++) {
         arr[depth] = i;
         dfs(depth + 1);
      }


   }
}
