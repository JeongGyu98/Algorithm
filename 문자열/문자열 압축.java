import java.util.*;

class Solution {
   public int solution(String s) {
      int answer = s.length();

      for(int i = 1; i <= s.length() / 2; i++){
         int count = 1;
         String zipStr = s.substring(0, i);
         StringBuilder result = new StringBuilder();

         for(int j = i; j <= s.length(); j += i){
            String next = s.substring(j, j + i > s.length() ? s.length() : i + j);
            if(zipStr.equals(next)) count++;
            else{
               result.append((count != 1 ? count : "") + zipStr);
               zipStr = next;
               count = 1;
            }
         }
         result.append(zipStr);
         answer = Math.min(answer, result.length());
      }

      return answer;
   }
}