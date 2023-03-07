import java.util.*;
import java.io.*;

class Solution {
    static final int dx[] = {0, 0, 1, -1};
    static final int dy[] = {1, -1, 0, 0};
    static int[][] visited;
    public static String[][] room = new String[5][5];

    public ArrayList<Integer> solution(String[][] places) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0 ; i < 5; i++){
            answer.add(isOK(places[i]));
        }

        return answer;
    }

    static int isOK(String[] place){

        for(int i = 0; i < 5; i ++){
            for(int j =0; j < 5; j++){
                room[i][j] = place[i].charAt(j) + "";
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(room[i][j].equals("P")){
                    if(!bfs(i,j)){
                        return 0;
                    }
                }
            }
        }

        return 1;
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visited = new int[5][5];

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                visited[i][j] = -1;
            }
        }

        q.add(new int[] {x, y});
        visited[x][y] = 0;

        while(!q.isEmpty()){
            int[] xy = q.poll();
            x = xy[0];
            y = xy[1];

            for(int i = 0; i < 4; i ++){

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx < 5 && ny >= 0 && ny < 5){
                    if (!room[nx][ny].equals("X") && visited[nx][ny] == -1){
                        visited[nx][ny] = visited[x][y] + 1;

                        if(room[nx][ny].equals("P") && visited[nx][ny] <= 2){
                            return false;
                        }
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }

        for(int i = 0; i < 5; i ++){
            for(int j =0; j < 5; j++){
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
        System.out.println();


        return true;
    }
}