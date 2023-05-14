import java.io.*;
import java.util.*;

class Main {
   static int max = Integer.MIN_VALUE;
   static int N, M;
   static int[] dy = {1, 0, -1, 0};
   static int[] dx = {0, 1, 0, -1};
   static int[][] map;

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      map = new int[N][M];
      for (int i = 0; i < N; i++) {
         st = new StringTokenizer(br.readLine());
         for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      dfs(0);
      System.out.println(max);
   }

   public static int bfs() {
      int cnt = 0;
      int[][] mapClone = new int[N][M];
      for (int i = 0; i < N; i++) {
         mapClone[i] = map[i].clone();
      }

      Queue<Node> q = new LinkedList<>();

      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (mapClone[i][j] == 2) {
               q.offer(new Node(i, j));
            }
         }
      }

      while (!q.isEmpty()) {
         Node node = q.poll();
         int y = node.y;
         int x = node.x;

         for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || nx < 0 || ny >= N || nx >= M || mapClone[ny][nx] == 1) {
               continue;
            }

            if (mapClone[ny][nx] == 0) {
               q.offer(new Node(ny, nx));
               mapClone[ny][nx] = 2;
            }
         }
      }

      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (mapClone[i][j] == 0) {
               cnt++;
            }
         }
      }

      return cnt;
   }

   public static void dfs(int depth) {
      if (depth == 3) {
         max = Math.max(max, bfs());
         return;
      }

      for (int i = 0; i < N; i++) {
         for (int j = 0; j < M; j++) {
            if (map[i][j] == 2 || map[i][j] == 1) {
               continue;
            }
            map[i][j] = 1;
            dfs(depth + 1);
            map[i][j] = 0;
         }
      }
   }

//   public static void print(int[][] MAP) {
//      for (int i = 0; i < N; i++) {
//         for (int j = 0; j < M; j++) {
//            System.out.print(MAP[i][j]);
//         }
//         System.out.println();
//      }
//      System.out.println();
//   }
}

class Node {
   int y;
   int x;

   public Node(int y, int x) {
      this.y = y;
      this.x = x;
   }
}