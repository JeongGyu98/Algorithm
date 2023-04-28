import java.util.*;
class Solution {
   public String solution(String p) {

      return cut(p);
   }

   public String cut(String s){

      if(s.length() == 0){
         return "";
      }

      if(isCorrect(s)){
         return s;
      }

      String u = "";
      String v = "";

      for(int i = 1; i < s.length(); i++){
         if(isBalanced(s.substring(0, i)) && isBalanced(s.substring(i))){
            u = s.substring(0, i);
            v = s.substring(i);
            break;
         }
      }
      if(u.equals("") && v.equals("")){
         u = s;
         v = "";
      }

      if(isCorrect(u)){
         return u += cut(v);
      } else {
         String str = "(";
         str += cut(v);
         str += ")";
         u = u.substring(1, u.length() - 1);

         for(int j = 0; j < u.length(); j++){
            if(u.charAt(j) == '('){
               str += ')';
            } else {
               str += '(';
            }
         }
         return str;
      }
   }

   private boolean isBalanced(String s){
      int countLeft = 0;
      int countRight = 0;

      for(int i = 0; i < s.length(); i++){
         if(s.charAt(i) == '('){
            countLeft++;
         }
         if(s.charAt(i) == ')'){
            countRight++;
         }
      }

      if(countLeft == countRight){
         return true;
      }

      return false;
   }

   private boolean isCorrect(String s){
      Stack<Character> stack = new Stack<>();

      for(int i = 0; i < s.length(); i++){
         if(stack.isEmpty()){
            stack.add(s.charAt(i));
         } else if (stack.peek() == '(' && s.charAt(i) == ')'){
            stack.pop();
         } else {
            stack.add(s.charAt(i));
         }
      }

      if(stack.isEmpty()){
         return true;
      }
      return false;
   }


}