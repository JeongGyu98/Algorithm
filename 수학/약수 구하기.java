import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n,k;
        int count = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] results = new int[n+1];

        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                results[count] = i;
                count++;
            }
        }
        System.out.println(results[k]);


    }
}