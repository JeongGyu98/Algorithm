import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine());

      for (int t = 0; t < T; t++) {
         StringTokenizer st = new StringTokenizer(br.readLine());
         int M = Integer.parseInt(st.nextToken());
         int N = Integer.parseInt(st.nextToken());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());

         process(M, N, x - 1, y - 1);
      }
   }

   public static void process(int M, int N, int x, int y) {

      boolean check = false;

      for (int i = x; i < (M * N); i += M) {
         if (i % N == y) {
            check = true;
            System.out.println(i + 1);
            break;
         }
      }

      if (!check) {
         System.out.println("-1");
      }

   }
}
