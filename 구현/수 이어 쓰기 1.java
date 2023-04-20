import java.io.*;
import java.util.*;
public class Main {
   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int count = 0;
      int N = Integer.parseInt(br.readLine());

      String num = String.valueOf(N);

      for (int i = 1; i <= num.length(); i++) {

         if (i == num.length()) {
            count += i * (N - (int)Math.pow(10, i - 1) + 1);
         } else {
            count += (9 * (int)Math.pow(10, i -1) * i);
         }

      }

      System.out.println(count);

   }
}
