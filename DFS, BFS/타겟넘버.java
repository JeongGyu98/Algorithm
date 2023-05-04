class Solution {
   static int answer = 0;
   public int solution(int[] numbers, int target) {

      for(int i = 0; i < numbers.length; i++){
         dfs(0, i, 0, numbers, target);
      }

      return answer;
   }

   public void dfs(int depth, int n, int start, int[] numbers, int target){

      if(depth == n){
         // for(int i = 0; i < numbers.length; i++){
         //     System.out.print(numbers[i] + " ");
         // }
         // System.out.println();

         int sum = 0;
         for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
         }

         if(sum == target){
            answer++;
         }
         return;
      }

      for(int i = start; i < numbers.length; i++){
         numbers[i] = numbers[i] - (numbers[i] * 2);
         dfs(depth + 1, n, i+1, numbers, target);
         numbers[i] = numbers[i] - (numbers[i] * 2);
      }


   }

}