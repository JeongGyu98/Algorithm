import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;

    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        // 행
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < N; j++) {
                //swap
                if (map[i][j] != map[i][j + 1]) {
                    char temp = map[i][j];
                    map[i][j] = map[i][j + 1];
                    map[i][j + 1] = temp;

                    check();

                    temp = map[i][j];
                    map[i][j] = map[i][j + 1];
                    map[i][j + 1] = temp;
                }
            }
        }

        // 열
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < N; j++) {
                //swap
                if (map[j][i] != map[j + 1][i]) {
                    char temp = map[j][i];
                    map[j][i] = map[j + 1][i];
                    map[j + 1][i] = temp;

                    check();

                    temp = map[j][i];
                    map[j][i] = map[j + 1][i];
                    map[j + 1][i] = temp;
                }
            }
        }
        System.out.println(max);

    }

    static int check() {
        //가로
        for (int i = 1; i <= N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }
        // 세로
        for (int i = 1; i <= N; i++) {
            int cnt = 1;
            for (int j = 1; j < N; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                max = Math.max(max, cnt);
            }
        }

        return max;
    }



}