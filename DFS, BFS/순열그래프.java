import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int result = 0;
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            boolean[] visited = new boolean[n + 1];
            int[] arr = new int[n + 1];

            for (int j = 1; j <= n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int k = 1; k <= n; k ++){
                if(!visited[k]){
                    visited[k] = true;
                    int end = arr[k];
                    while(true){
                        if(visited[end]){
                            result ++;
                            break;
                        }
                        visited[end] = true;
                        end = arr[end];
                    }
                }
            }
            System.out.println(result);

        }

    }


}