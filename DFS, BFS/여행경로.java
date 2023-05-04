import java.util.*;
class Solution {

   boolean[] isUsed;
   ArrayList<String> route;
   public String[] solution(String[][] tickets) {
      String[] answer = {};
      route = new ArrayList<>();
      isUsed = new boolean[tickets.length];

      dfs("ICN", tickets, "ICN ", 0);

      Collections.sort(route);
      answer = route.get(0).split(" ");

      return answer;
   }

   public void dfs(String start,String[][] tickets, String currentRoute, int count){

      if(count == tickets.length){
         // currentRoute += start;
         route.add(currentRoute);
         return;
      }

      for(int i = 0; i < tickets.length; i++){
         if(tickets[i][0].equals(start) && !isUsed[i]){
            isUsed[i] = true;

            dfs(tickets[i][1], tickets, currentRoute + tickets[i][1] + " ", count + 1);
            isUsed[i] = false;

         }
      }
   }
}