import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      String[] arr = new String[N];

      for (int i = 0; i < N; i++) {
         String s = br.readLine();
         arr[i] = s;
      }

      Arrays.sort(arr, new Comparator<String>() {
         @Override
         public int compare(String o1, String o2) {
            if (o2.length() == o1.length()) {
               return o1.compareTo(o2);
            } else {
               return o1.length() - o2.length();
            }
         }
      });

      StringBuilder sb = new StringBuilder();
      sb.append(arr[0]).append("\n");

      for (int i = 1; i < N; i++) {
         if (arr[i - 1].equals(arr[i])) {
            continue;
         }
         sb.append(arr[i]).append("\n");
      }

      System.out.println(sb);

   }
}