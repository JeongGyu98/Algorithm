import java.io.*;
import java.util.*;

public class Main {
   static int start = 1;
   static int end = 3;
   static int N;
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());

      process("");

   }

   static void process(String str) {
      if (str.length() == N) {
         System.out.println(str);
         System.exit(0);
      }

      for (int i = start; i <= end; i++) {
         if (isGood(str + i)) {
            process(str + i);
         }
      }
   }

   static boolean isGood(String s) {

      for(int i = 1 ; i <= s.length() / 2; i++){
         String front = s.substring(s.length() - i * 2, s.length() - i);
         String back = s.substring(s.length() - i, s.length());
         if (front.equals(back)) {
            return false;
         }
      }
      return true;
   }
}