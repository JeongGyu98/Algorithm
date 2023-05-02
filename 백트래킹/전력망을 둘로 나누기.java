import java.util.*;
class Solution {
   static boolean[][] map;
   public int solution(int n, int[][] wires) {
      int min = Integer.MAX_VALUE;
      map = new boolean[n + 1][n + 1];


      for(int i = 0; i < wires.length; i++){
         int v1 = wires[i][0];
         int v2 = wires[i][1];

         map[v1][v2] = map[v2][v1] = true;
      }

      for(int i = 0; i < wires.length; i++){
         int v1 = wires[i][0];
         int v2 = wires[i][1];

         map[v1][v2] = map[v2][v1] = false;

         min = Math.min(min, Math.abs(bfs(v1, n) - bfs(v2, n)));

         map[v1][v2] = map[v2][v1] = true;
      }


      return min;
   }

   public int bfs(int num, int n){
      boolean[] visited = new boolean[n + 1];
      int count = 1;

      Queue<Integer> q = new LinkedList<>();
      q.offer(num);

      while(!q.isEmpty()){

         int node = q.poll();
         visited[node] = true;
         count++;

         for(int i = 1; i <= n; i++){
            if(visited[i]) continue;
            if(map[node][i]){
               q.offer(i);
            }
         }
      }

      return count;
   }
}