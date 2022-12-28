import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] card = new int[n+1];
        int[] max = new int[n+1];

        for(int i = 1; i < n+1; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < n+1; i ++){
            for(int j = 1; j < i+1; j++){
                max[i] = Math.max(max[i], card[j] + max[i-j]);
            }
        }

        System.out.println(max[max.length - 1]);

    }
}