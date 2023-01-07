import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st, st2;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int sumHeight;
        tree = new int[n];

        st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(tree); // 배열 오름차순 정렬
        long end = tree[n - 1]; // 가장 긴 나무 높이
        long start = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if(tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }
            if (sum >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
