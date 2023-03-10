import java.io.*;
import java.util.*;
class Main {

    static int N, M, x, y, K;
    static int map[][];
    static int[] dice;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dice = new int[7];

        for (int i = 0; i < 7; i++) {
            dice[i] = 0;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int direction = Integer.parseInt(st.nextToken());
            move(direction);
        }
    }

    static void move(int direction){
//        System.out.println("direction: " + direction);
//        System.out.println(x + " " + y);
        int nx = x + dx[direction - 1];
        int ny = y + dy[direction - 1];

        if (nx < 0 || ny < 0 || nx > M - 1 || ny > N - 1) {
            return;
        } else {
            rollDice(direction, nx, ny);
            x = nx;
            y = ny;
        }
    }

    static void rollDice(int direction, int x, int y) {
        int temp = dice[1];
        switch (direction) {
            case 1:
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
                break;
            case 2:
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
                break;
            case 3:
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
                break;
            case 4:
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
                break;
        }
        if (map[y][x] == 0) {
            map[y][x] = dice[6];
        } else {
            dice[6] = map[y][x];
            map[y][x] = 0;
        }
        System.out.println(dice[1]);
    }
}