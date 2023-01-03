import java.io.*;
import java.util.*;

public class Main {

    static int[] data;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        data = new int[T + 1];

        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int r = 1;

            for(int j = 1; j <= b; j++){
                r = (r * a) % 10;
            }

            if(r == 0) r = 10;
            data[i] = r;
        }

        for (int i = 1; i <= T; i++) {
            System.out.println(data[i]);
        }
    }
}