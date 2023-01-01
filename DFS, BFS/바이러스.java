import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {

    static int[][] connections;
    static boolean[] visited;
    static int count = 0;
    static int node, line;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        connections = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            connections[a][b] = connections[b][a] = 1;
        }

        dfs(1);
        for (int i = 0; i < visited.length; i++) {
            if (i != 1 && visited[i] == true) {
                count ++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start){
        visited[start] = true;

        for (int i = 1; i < node + 1; i++) {
            if(connections[start][i] == 1 && visited[i] == false){
                dfs(i);
            }
        }

    }
}