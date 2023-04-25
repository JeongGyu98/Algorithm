import java.util.*;
import java.util.Map.Entry;

class Solution {

   TreeMap<String, Integer> hm;

   public ArrayList<String> solution(String[] orders, int[] course) {
      ArrayList<String> answer = new ArrayList<>();;

      for(int courseLength : course){
         hm = new TreeMap<>();
         int max = Integer.MIN_VALUE;
         String maxKey = "";

         for(String order : orders){
            StringBuilder sb = new StringBuilder();

            if(order.length() >= courseLength){
               combination(order, courseLength, 0, 0, sb);
            }

         }

         System.out.println(hm);

         for(Entry<String,Integer> entry : hm.entrySet()){
            max = Math.max(max,entry.getValue());

         }

         for(Entry<String,Integer> entry : hm.entrySet()){
            if(max >=2 && entry.getValue() == max)
               answer.add(entry.getKey());
         }


      }

      Collections.sort(answer);
      return answer;
   }

   public void combination(String order, int courseLength, int start, int count, StringBuilder sb){

      if(count == courseLength){
         String sorted = sortArray(sb.toString());
         hm.put(sorted, hm.getOrDefault(sorted, 0) + 1);
         return;
      }

      for(int i = start; i < order.length(); i++){
         sb.append(order.charAt(i));
         combination(order, courseLength, i + 1, count + 1, sb);
         sb.delete(count,count+1);
      }


   }

   public String sortArray(String str){
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      return String.valueOf(arr);
   }
}