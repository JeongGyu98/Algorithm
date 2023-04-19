import java.io.*;
import java.util.*;

public class Main {

   static int max = 9999999;

   static public int solution(int n, int k) {
      int answer = 0;

      StringBuilder convertedNum = convertNum(n, k);
      StringBuilder num = new StringBuilder();

      for(int i = 0; i < convertedNum.length(); i++){
         char ch = convertedNum.toString().charAt(i);

         if(ch != '0'){
            num.append(ch);
         } else {

            if(num.toString().equals("")){
               continue;
            }

            if(isPrime(Long.parseLong(num.toString()))){
               answer++;
            }
            num.delete(0, num.length());

         }
      }

      if(num.length() > 0){
         if(isPrime(Long.parseLong(num.toString()))){
            answer++;
         }
      }

      return answer;
   }

   static public StringBuilder convertNum(int n, int k){

      StringBuilder sb = new StringBuilder();

      while(n > k){
         int num = n % k;
         sb.insert(0, String.valueOf(num));
         n = n / k;
      }

      sb.insert(0, String.valueOf(n));
      return sb;
   }

   static boolean isPrime(long a){

      if(a<2) return false;

      for(int i=2;i<=Math.sqrt(a);i++){
         if(a%i==0){
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args) throws IOException {

      int n = 437674;
      int k = 3;

      System.out.println(solution(n, k));
   }


}
