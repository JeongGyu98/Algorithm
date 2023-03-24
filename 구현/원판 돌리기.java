import java.util.*;
import java.io.*;

public class Main {

    static int[][] circle;
    static int n, m, t;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        circle = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotation(x, d, k);
            erase();
        }
//        print();

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (circle[i][j] != -1) {
                    ans += circle[i][j];
                }
            }
        }
        System.out.println(ans);

    }

    static void rotation(int x, int d, int k) {

        for (int num = x; num <= n; num++) {
            if (num % x == 0) {
                if (d == 0) { // d가 0이면 시계방향
                    clock(num, k);
                } else { // d == 1 이면 반시계반향
                    rClock(num, k);
                }
            }
        }
    }

    private static void clock(int num, int k) {
        for (int i = 0; i < k; i++) {
            int temp = circle[num][m];
            for (int j = m; j > 1; j--) {
                circle[num][j] = circle[num][j - 1];
            }
            circle[num][1] = temp;
        }
    }

    private static void rClock(int num, int k) {
        for (int i = 0; i < k; i++) {
            int temp = circle[num][1];
            for (int j = 1; j < m; j++) {
                circle[num][j] = circle[num][j + 1];
            }
            circle[num][m] = temp;
        }
    }

    private static void erase() {
        boolean check[][] = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(circle[i][j] == -1) continue;

                int left = (j - 1) > 0 ? j - 1 : m;
                if (circle[i][j] == circle[i][left]) {
                    check[i][j] = true;
                    check[i][left] = true;
                }

                int right = (j + m + 1) % m;
                if(circle[i][j] == circle[i][right]) {
                    check[i][j] = true;
                    check[i][right] = true;
                }

                int up = i + 1;
                if (up <= n) {
                    if (circle[i][j] == circle[up][j]) {
                        check[i][j] = true;
                        check[up][j] = true;
                    }
                }
                int down = i - 1;
                if (down > 0) {
                    if (circle[i][j] == circle[down][j]) {
                        check[i][j] = true;
                        check[down][j] = true;
                    }
                }

            }
        }

        boolean eraseFlag = false;
        int sum = 0;
        int cnt = 0;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                if (check[i][j]) {
                    eraseFlag = true;
                    circle[i][j] = -1;
                } else {
                    if (circle[i][j] != -1) {
                        sum += circle[i][j];
                        cnt++;
                    }
                }
            }
        }
        if(eraseFlag) return;
        /* 삭제한 수가 없으면 */

        double avg = (double) sum / (double) cnt;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (circle[i][j] == -1) continue;

                if (circle[i][j] > avg) {
                    circle[i][j] -= 1;
                } else if (circle[i][j] < avg) {
                    circle[i][j] += 1;
                }
            }
        }
    }

    private static void print() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(circle[i][j]);
            }
            System.out.println();
        }
    }


}
