import java.io.*;
import java.util.*;
public class Main {

   static int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String number = br.readLine();

      System.out.println(solution(number));

   }

   static int solution(String number) {
      int count = 0;
      StringBuilder input = new StringBuilder();

      for (int i = 0; i < number.length();) {
         char ch = number.charAt(i);
         int next = numbers[Character.getNumericValue(ch)];
         System.out.println("current: "+ ch);
         input.append(ch);
         count++;

         if (i == number.length() - 1) {
            if (ch != '0') {
               count++;
            }
            break;
         }

         if (ch != '0') {
            System.out.println("next: " + next + ", number: " + number.charAt(i + 1));
            if (next == Character.getNumericValue(number.charAt(i + 1))) {
               input.append(next);
               i += 2;
            } else {
               i++;
               count++;
            }
         } else {
            i++;
         }

         if (input.toString() == number) {
            break;
         }
         System.out.println(count);
      }
      System.out.println(input);

      return count;
   }


}