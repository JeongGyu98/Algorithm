import java.io.*;
import java.util.*;
public class Main {

   static int[] arr;
   static int N;

   public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine());
      StringTokenizer st = new StringTokenizer(br.readLine());

      arr = new int[N];

      for (int i = 0; i < N; i++) {
         arr[i] = Integer.parseInt(st.nextToken());
      }

      process();

   }

   private static void process() {

      //주어진 순열의 뒤부터 탐색, 증가하는 부분의 index 찾기
      int index = N - 1;
      while (index > 0 && arr[index - 1] >= arr[index]) {
         index--;
      }

      if (index == 0) {
         System.out.println(-1);
         return;
      }

      // index를 기준으로 좌/우로 분리
      // 좌측의 제일 오른쪽 숫자 = index -1
      // 우측 중에서 위의 수보다 더 큰수를 찾는다.
      // 숫자를 찾으면 swap
      for (int i = N - 1; i >= index; i--) {
         if (arr[index - 1] < arr[i]) {
            int temp = arr[index - 1];
            arr[index - 1] = arr[i];
            arr[i] = temp;
            break;
         }
      }

      // index기준 오른쪽 숫자 정렬
      Arrays.sort(arr, index, N);

      StringBuilder sb = new StringBuilder();
      for (int i : arr) {
         sb.append(i).append(" ");
      }

      System.out.println(sb);

   }

}
