import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] tall = new int[10];
        int total = 0;

        for (int i = 1; i <= 9; i++) {
            tall[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(tall);

        for (int i = 1; i <= 9; i++) {
            total += tall[i];
        }

        loop1:
        for (int i = 1; i <= 9; i++) {
            loop2:
            for (int j = 1; j <= 9; j++) {
                if (i == j) {
                    continue;
                }

                if (tall[i] + tall[j] == total - 100) {
                    tall[i] = 0;
                    tall[j] = 0;
                    break loop1;
                }
            }
        }

        for (int i = 1; i <= 9; i++) {
            if (tall[i] != 0) {
                sb.append(tall[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}