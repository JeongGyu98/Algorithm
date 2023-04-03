import java.io.*;
import java.util.*;

public class Main {

    static int MAX_INT = 1000000;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        arr = new int[MAX_INT + 1];

        for (int i = 2; i <= MAX_INT; i++) {
            arr[i] = i;
        }

        for (int i = 2; i <= MAX_INT; i++) {
            if (arr[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= MAX_INT; j += i) {
                arr[j] = 0;
            }
        }

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            process(n);
        }
    }

    static void process(int n) {

        if (n == 1) {
            return;
        }

        for (int i = 3; i <= n; i += 2) {
            int b = n - i;

            if (isPrime(i) && isPrime(b)) {
                System.out.println(n + " = " + i + " + " + b);
                break;
            }
        }
    }

    static boolean isPrime(int n) {

        if (arr[n] == 0) {
            return false;
        }

        return true;
    }
}