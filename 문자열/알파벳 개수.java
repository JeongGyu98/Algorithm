import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];

        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - '0' - 49;
            arr[index]++;
        }

        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);

    }
}
