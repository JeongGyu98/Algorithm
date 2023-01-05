import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] tree;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 1;
            while (st.hasMoreTokens()) {
                tree[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        for (int i = 1; i <= N; i++) {
            dp[N][i] = tree[N][i];
        }

        for (int i = N; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                if(j+1 <= N && i+1 <= N){
                    dp[i][j] = Math.max(tree[i][j] + dp[i+1][j], tree[i][j] + dp[i+1][j+1]);
                }
            }
        }
        System.out.println(dp[1][1]);


    }
}
