import java.util.*;
import java.io.*;

class Main
{
   public static void main(String args[]) throws IOException
   {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T;
      T= Integer.parseInt(br.readLine());
      StringTokenizer st;

      for(int test_case = 1; test_case <= T; test_case++)
      {
         int count = 0;
         int N  = Integer.parseInt(br.readLine());
         int[] buildings = new int[N];
         st = new StringTokenizer(br.readLine());
         for(int i = 0; i < N; i++){
            buildings[i]  = Integer.parseInt(st.nextToken());
         }

         for(int i = 2; i < N - 2; i++){
            int now = buildings[i];
            int[] near = { buildings[i - 2], buildings[i - 1], buildings[i + 1], buildings[i + 2] };
            Arrays.sort(near);
            if(buildings[i - 2] > now || buildings[i - 1] > now || buildings[i + 1] > now || buildings[i + 2] > now) {
               continue;
            }

            count += now -near[near.length - 1];
         }

         System.out.println("#" + test_case + " " + count);
      }
   }
}