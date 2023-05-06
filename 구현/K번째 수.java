import java.util.*;
class Solution {
   public int[] solution(int[] array, int[][] commands) {
      int[] answer = new int[commands.length];

      ArrayList<Integer> arr;

      for(int t = 0; t < commands.length; t++){
         int i = commands[t][0];
         int j = commands[t][1];
         int k = commands[t][2];

         arr = new ArrayList<>();

         for(int s = i; s <= j; s++){
            arr.add(array[s - 1]);
         }

         Collections.sort(arr);
         answer[t] = arr.get(k -1);
      }

      return answer;
   }
}