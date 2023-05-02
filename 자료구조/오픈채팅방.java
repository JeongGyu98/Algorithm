import java.util.*;

class Solution {
   public ArrayList<String> solution(String[] records) {
      ArrayList<String> logs = new ArrayList<>();
      HashMap<String, String> hm = new HashMap<>();
      StringTokenizer st;

      for(String record : records){
         st = new StringTokenizer(record);
         String command = st.nextToken();
         String userID = st.nextToken();
         String nickName = "";

         if(!command.equals("Leave")){
            nickName = st.nextToken();
         }

         switch(command){
            case "Enter":
               hm.put(userID, nickName);
               logs.add(userID + "님이 들어왔습니다.");
               break;
            case "Leave":

               logs.add(userID + "님이 나갔습니다.");
               break;
            case "Change":
               hm.put(userID, nickName);
               break;
         }
      }

      ArrayList<String> answer = new ArrayList<>();
      for(String log : logs){
         int index = log.indexOf("님");
         String id = log.substring(0, index);

         answer.add(log.replace(id, hm.get(id)));
      }

      return answer;
   }
}