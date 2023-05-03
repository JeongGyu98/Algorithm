import java.util.*;
class Solution {
   public int[] solution(int N, int[] stages) {
      int[] answer = new int[N];
      int[] stageCount = new int[N];
      Map<Integer, Double> failPercent = new HashMap<>();
      int total = stages.length;

      for (int i = 0; i < stages.length; i++) {
         if (stages[i] == N + 1) { // 마지막 스테이지를 클리어한 것은 제외
            continue;
         }
         stageCount[stages[i] - 1]++;
      }

      for (int i = 0 ; i < stageCount.length; i++) {
         if (total == 0) {
            failPercent.put(i, 0d);
            continue;
         }
         failPercent.put(i, (double)stageCount[i] / (double)total);
         total -= stageCount[i];
      }

      for (int i = 0; i < N; i++) {
         double max = -1;
         int maxKey = 0;

         for (int key : failPercent.keySet()) {
            if (max < failPercent.get(key)) {
               max = failPercent.get(key);
               maxKey = key;
            }
         }

         answer[i] = maxKey + 1;
         failPercent.remove(maxKey);
      }

      return answer;
   }
}