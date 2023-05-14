import java.io.*;
import java.util.*;

class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      String[] words = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

      String input = br.readLine();
      int result = 0;
      for (int i = 0; i < words.length; i++) {
         if (input.contains(words[i])) {
            input = input.replace(words[i], "0");
         }
      }

      System.out.println(input.length());

   }
}