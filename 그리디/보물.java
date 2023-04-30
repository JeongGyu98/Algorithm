import java.io.*;
import java.util.*;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      int[] a = new int[N];
      Integer[] b = new Integer[N];

      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         a[i] = Integer.parseInt(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
         b[i] = Integer.parseInt(st.nextToken());
      }

      Arrays.sort(a);
      Arrays.sort(b, new Comparator<Integer>(){
         @Override
         public int compare(Integer i1, Integer i2) {
            return i2 - i1;
         }
      });

      int sum = 0;
      for (int i = 0; i < N; i++) {
         sum += a[i] * b[i];
      }

      System.out.println(sum);
   }
}