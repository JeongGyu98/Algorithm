import java.io.*;
import java.util.*;
public class Main {


   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      String[] kor = {"AAA", "BCD", "AAAAA", "ZY"};
//      String[] usa = {"AB", "AA", "TTTT"};
//      String[] incs = {"AB BCD AA AAA TTTT AAAAA", "BCD AAA", "AB AAA TTTT BCD", "AA AAAAA AB", "AAA AB BCD"};
         String[] kor = {"BCDF", "CCC"};
         String[] usa = {"XXXX"};
         String[] incs = {"BCDF CCC", "XXXX"};


      System.out.println(solution(kor, usa, incs));

   }

   static int solution(String[] kor, String[] usa, String[] incs) {
      Map<String, Integer> pairCounts = new HashMap<>();

      Set<String> korSet = new HashSet<>(Arrays.asList(kor));
      Set<String> usaSet = new HashSet<>(Arrays.asList(usa));

      for (String inc : incs) {
         String[] stocks = inc.split(" ");
         Set<String> incSet = new HashSet<>(Arrays.asList(stocks));

         for (String korStock : korSet) {
            if (incSet.contains(korStock)) {
               for (String usaStock : usaSet) {
                  if (incSet.contains(usaStock)) {
                     String key = korStock + "," + usaStock;
                     pairCounts.put(key, pairCounts.getOrDefault(key, 0) + 1);
                  }
               }
            }
         }
      }
      int maxCount = 0;
      if (!pairCounts.isEmpty()) {
         maxCount = Collections.max(pairCounts.values());
      }

      System.out.println(pairCounts);
      return maxCount;

   }


}