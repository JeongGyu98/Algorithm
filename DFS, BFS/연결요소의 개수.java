import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] connections;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st ;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        connections = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connections[a][b] = connections[b][a] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if(!visited[i]){
                dfs(i);
                count ++;
            }
        }

        System.out.println(count);

    }

    private static void dfs(int a) {
        visited[a] = true;

        for (int i = 1; i <= N; i++) {
            if (connections[a][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}