import java.util.*;

class Solution {

   static HashMap<String, ArrayList<Integer>> hm;
   static ArrayList<Integer> answer;

   public ArrayList<Integer> solution(String[] info, String[] query) {
      answer = new ArrayList<>();
      hm = new HashMap<>();

      for(int i = 0; i < info.length; i++){
         String[] words = info[i].split(" ");
         process(words, "", 0);
      }

      for(String key : hm.keySet()){
         Collections.sort(hm.get(key));
      }

      for(String q : query){
         String str = q.replace(" and ", "");
         String[] temp = str.split(" ");

         String key = temp[0];
         int score = Integer.parseInt(temp[1]);
         ArrayList<Integer> tempList = hm.get(key);

         if(hm.containsKey(key)){
            // Collections.sort(tempList);
            answer.add(tempList.size() - lowerBound(tempList, score));
         } else {
            answer.add(0);
         }
      }

      return answer;
   }

   public static int lowerBound(ArrayList<Integer> list, int key){
      int left = 0, right = list.size() - 1;

      while(left <= right){
         int mid = (left + right) / 2;
         if(list.get(mid) < key){
            left = mid + 1;
         }
         else {
            right = mid - 1;
         }
      }
      return left;

   }

   public static void process(String[] word, String str, int count){

      if(count == 4){
         int score = Integer.parseInt(word[4]);
         if(!hm.containsKey(str)){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(score);
            hm.put(str, list);
         } else {
            hm.get(str).add(score);
         }
         return;
      }

      process(word, str + "-", count + 1);
      process(word, str + word[count], count + 1);
   }
}