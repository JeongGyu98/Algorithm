import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] price = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N + 1; i++) {
            dp[i] = price[i];
        }

        for(int i = 1; i < N + 1; i++){
            for (int j = 1; j < i + 1; j++){
                if(i - j > 0) {
                    dp[i] = Math.min(dp[i - j] + price[j], dp[i]);
                }
            }
        }

        System.out.println(dp[N]);

    }
}