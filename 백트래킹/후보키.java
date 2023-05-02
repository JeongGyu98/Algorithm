import java.util.*;

class Solution {

   static HashSet<String> ans;

   public int solution(String[][] relation) {

      ans = new HashSet<>();


      for(int i = 0; i < relation[0].length; i++){
         boolean[] visited = new boolean[relation[0].length];
         dfs(visited, 0, 0, i + 1, relation);
      }
      System.out.println(ans);
      return ans.size();
   }

   public void dfs(boolean[] visited, int start, int depth, int end, String[][] relation){

      if(depth == end){

         // 사용할 키
         String key = "";
         ArrayList<Integer> keyAtt = new ArrayList<>();
         for(int i = 0; i < visited.length; i++){
            if(visited[i]){
               keyAtt.add(i);
               key += i;
            }
         }

         //키로 쓸 특성에 중복있는지 확인
         //유일성
         HashSet<String> hs = new HashSet<>();
         for(int i = 0; i < relation.length; i++){
            String value = "";
            for(Integer keyA : keyAtt){
               value += relation[i][keyA];
            }

            if(hs.contains(value)){
               return;
            } else {
               hs.add(value);
            }
         }

         //최소성
         for(String s : ans){
            int count = 0;
            for(int i = 0; i < key.length(); i++){
               String c = String.valueOf(key.charAt(i));
               if(s.contains(c)){
                  count++;
               }
            }
            if (count == s.length()) return;
         }
         ans.add(key);

         return;
      }

      for(int i = start; i < visited.length; i++){
         if(visited[i]) continue;

         visited[i] = true;
         dfs(visited, i, depth + 1, end, relation);
         visited[i] = false;
      }
   }
}