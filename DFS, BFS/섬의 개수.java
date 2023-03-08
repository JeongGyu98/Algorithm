import java.util.*;
import java.io.*;
public class Main {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Queue<Node> q = new LinkedList<>();

    static int[][] map;
    static boolean[][] visited;
    static int isLand = 0;
    static int w, h;

    static int dx[] = {0,0,-1,1,-1,-1,1,1};
    static int dy[] = {-1,1,0,0,-1,1,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String str = br.readLine();
            if (str.equals("0 0")) {
                break;
            }

            st = new StringTokenizer(str);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];
            isLand = 0;

            for (int i = 1; i <= h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= h; i++) {
                for (int j = 1; j <= w; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        visited[i][j] = true;
                        q.offer(new Node(i, j));
                        bfs();
                    }
                }
            }
            System.out.println(isLand);
            q.clear();

        }

    }

    static void bfs(){

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx< 1 || nx > h || ny < 1 || ny > w || map[nx][ny] ==0 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                q.offer(new Node(nx, ny));
            }
        }
        isLand++;

    }
}