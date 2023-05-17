import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int h = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      int n = Integer.parseInt(st.nextToken());

      int[][] arr = new int[h][w];
      for(int i=0; i<h; i++) {
         st = new StringTokenizer(br.readLine());
         for(int j=0; j<w; j++) {
            arr[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      int count = Math.min(h, w) / 2; //돌아가는 라인?의 수
      for(int i=0; i<n; i++) { //회전 횟수만큼 반복

         for(int j=0; j<count; j++) { //라인들 전부 돌리기
            int temp = arr[j][j]; //맨 마지막에 넣기 위해 따로 저장!!!!배열에서 원소 위치 바꿀때 하나를 temp에 저장해두는거랑 같은 원리

            for(int k=j+1; k<w-j; k++)
               arr[j][k-1] = arr[j][k];

            for(int k=j+1; k<h-j; k++)
               arr[k-1][w-1-j] = arr[k][w-1-j];

            for(int k=w-2-j; k>=j; k--)
               arr[h-1-j][k+1] = arr[h-1-j][k];

            for(int k=h-2-j; k>=j; k--)
               arr[k+1][j] = arr[k][j];

            arr[j+1][j] = temp;
         }
      }

      for(int j=0; j<h; j++) {
         for(int k=0; k<w; k++) {
            System.out.print(arr[j][k] + " ");
         }
         System.out.println();
      }
   }
}