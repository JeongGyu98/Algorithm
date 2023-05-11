import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();
      int i = 2;
      //n이 1이 될 때까지 반복
      while (n != 1) {
         // i가 n의 약수이면 나누고 출력
         if (n % i == 0) {
            n/= i;
            sb.append(i + "\n");
         } else {
            i++;
         }
      }
      System.out.print(sb);
   }

}