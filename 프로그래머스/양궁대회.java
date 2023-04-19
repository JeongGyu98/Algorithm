import java.util.*;

class Solution {

   public static ArrayList<int[]> list = new ArrayList<int[]>();
   public static int[] ryan;
   public static int[] apeach;
   public static int max_sub = -1;

   public int[] solution(int n, int[] info) {

      ryan = new int[11];
      apeach = info;

      find(n, 0, 0);

      if(max_sub == -1){
         return new int[] { -1 };
      }

      Collections.sort(list, (o1, o2) -> {
         for(int i=10;i>=0;i--){
            if(o1[i] != o2[i]) return o2[i] - o1[i];
         }
         return 0;
      });

      return list.get(0);
   }

   public static void find(int n, int depth, int start){


      if(depth == n){

         // for(int i = 0; i < ryan.length; i++){
         //     System.out.print(ryan[i]);
         // }
         // System.out.println();

         int score_a = 0;
         int score_r = 0;

         // 점수 구하기
         for(int i=0;i<10;i++){
            if(apeach[i] == 0 && ryan[i] == 0) {
               continue;
            }
            if(apeach[i] >= ryan[i]) {
               score_a += (10-i);
            }
            else {
               score_r += (10-i);
            }
         }

         //라이언이 승리한다면
         if(score_r > score_a){
            int score_sub = score_r - score_a;
            // 최대 점수차를 갱신하는 경우 list 초기화
            if(max_sub < score_sub){
               max_sub = score_sub;
               list.clear();
               list.add(ryan.clone());
               // 점수차가 제일 큰게 여러개일 경우 list에 추가
            } else if (max_sub == score_sub) {
               list.add(ryan.clone());
            }
         }

         return;
      }

      for(int i = start; i < 11; i++){
         ryan[i]++;
         find(n, depth + 1, i);
         ryan[i]--;
      }
   }
}