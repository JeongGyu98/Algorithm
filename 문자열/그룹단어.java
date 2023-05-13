import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());

      int result = 0;
      for (int i = 0; i < N; i++) {
         if (check(br.readLine())) {
            result++;
         }
      }

      System.out.println(result);
   }

   public static boolean check(String input) {
      boolean[] check = new boolean[26];
      int prev = 0;

      for (int i = 0; i < input.length(); i++) {
         int now = input.charAt(i);

         if (prev != now) {
            if (!check[now - 'a']) {
               check[now - 'a'] = true;
               prev = now;
            } else {
               return false;
            }
         } else {
            continue;
         }
      }
      return true;
   }

}