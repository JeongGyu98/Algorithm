import java.io.*;
import java.util.*;

public class Main {

   static int[] dy = {1, 0, -1, 0};
   static int[] dx = {0, -1, 0, 1};
   static int N, M;
   static int result = Integer.MIN_VALUE;
   static int[][] map;
   static boolean[][] visited;
   public static void main(String[] args) throws Exception {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String[] str = br.readLine().split(" ");
      N = Integer.parseInt(str[0]);
      M = Integer.parseInt(str[1]);

      map = new int[N][M];
      visited = new boolean[N][M];

      for (int i = 0; i < N; i++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            visited[i][j] = true;
            dfs(i, j, 1, map[i][j]);
            visited[i][j] = false;

         }
      }

      System.out.println(result);
   }

   static void dfs(int y, int x, int depth, int sum) {

      // 테트로미노 완성 조건
      // depth == 4
      if (depth == 4) {
//         System.out.println("Sum: " + sum);
//         print();
         result = Math.max(result, sum);
         return;
      }

      for (int i = 0; i < 4; i++) {
         int ny = y + dy[i];
         int nx = x + dx[i];

         if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx] == true) {
            continue;
         }

         if (depth == 2) {
            visited[ny][nx] = true;
            dfs(y, x, depth + 1, sum + map[ny][nx]);
            visited[ny][nx] = false;
         }

         visited[ny][nx] = true;
         dfs(ny, nx,depth + 1, sum + map[ny][nx]);
         visited[ny][nx] = false;
      }
   }

   static private void print() {
      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (visited[i][j]) {
               System.out.print("* ");
            } else {
               System.out.print("- ");
            }
//            System.out.print(visited[i][j] + " ");
         }
         System.out.println();
      }
      System.out.println();
   }
}
