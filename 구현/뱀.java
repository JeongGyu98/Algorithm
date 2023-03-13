import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static class pair{
        int x;
        int y;

        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, K, L;
    static int[][] map;
    static List<pair> tDirs;
    static Queue<pair> snake;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        tDirs = new ArrayList<>();
        snake = new LinkedList<>();

        for(int i = 0 ; i < K ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());

            map[x-1][y-1] = 1;
        }

        L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(stringTokenizer.nextToken());
            String d = stringTokenizer.nextToken();
            int dir = d.equals("D") ? 1 : -1;

            tDirs.add(new pair(t, dir));
        }

        map[0][0] = -1; // 뱀
        int time = 0, turn = 0;
        int curdir = 0;
        pair head = new pair(0, 0);
        snake.add(head);

        while(true){
            time++;

            int nx = head.x + dx[curdir];
            int ny = head.y + dy[curdir];

            if(nx < 0 || N <= nx || ny < 0 || N <= ny || map[nx][ny] == -1) break;

            if(map[nx][ny] != 1){
                pair tail = snake.poll();
                map[tail.x][tail.y] = 0;
            }

            head = new pair(nx, ny);
            snake.add(head);
            map[nx][ny] = -1;

            if(turn < L && tDirs.get(turn).x == time){
                curdir = (curdir + tDirs.get(turn).y) % 4;
                curdir = curdir == -1 ? 3 : curdir;
                turn++;
            }
        }

        System.out.println(time);
    }
}