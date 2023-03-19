import java.util.*;
import java.io.*;

public class Main {

    static int k;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][9];

        for (int i = 1; i <= 4; i++) {
            String str = br.readLine();
            for (int j = 1; j <= 8; j++) {
                arr[i][j] = Integer.parseInt(str.charAt(j - 1) + "");
            }
        }

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int numArr = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            process(numArr, d);
        }

//        for (int i = 1; i <= 4; i++) {
//            for (int j = 1; j <= 8; j++) {
//                System.out.print(arr[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println(getScore(arr));

    }

    static void process(int numArr, int d) {
        left(numArr - 1, -d);
        right(numArr + 1, -d);
        rotation(numArr, d);
    }

    static void left(int numArr, int d) {
        if (numArr < 1) {
            return;
        }
        if (arr[numArr][3] != arr[numArr + 1][7]) {
            left(numArr - 1, -d);
            rotation(numArr, d);
        }
    }

    static void right(int numArr, int d) {
        if (numArr > 4) {
            return;
        }
        if (arr[numArr][7] != arr[numArr - 1][3]) {
            right(numArr + 1, -d);
            rotation(numArr, d);
        }
    }


    static void rotation(int numArr, int d) {
        switch (d) {
            case 1:
                int temp = arr[numArr][8];
                for (int i = 8; i > 1; i--) {
                    arr[numArr][i] = arr[numArr][i - 1];
                }
                arr[numArr][1] = temp;
                break;
            case -1:
                int temp2 = arr[numArr][1];
                for (int i = 1; i < 8; i++) {
                    arr[numArr][i] = arr[numArr][i + 1];
                }
                arr[numArr][8] = temp2;
                break;
        }
    }

    static int getScore(int[][] arr) {
        int result = 0;

        for (int i = 0; i < 4; i++) {
            if (arr[i+1][1] == 1) {
                result = result + (int)Math.pow(2, i);
            }

        }

        return result;
    }

}