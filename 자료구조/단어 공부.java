import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      char mostFrequentAlphabet = findMostFreqAlphabet(input);
      System.out.println(mostFrequentAlphabet);
   }


   public static char findMostFreqAlphabet(String text) {
      Map<Character, Integer> record = parseToMap(text);

      List<Entry<Character, Integer>> sortedEntry = sortByValue(record);

      if (sortedEntry.size() > 1 && isDuplicate(sortedEntry)) {
         return '?';
      }

      return sortedEntry.get(0).getKey();
   }

   private static Map<Character, Integer> parseToMap(String text) {
      Map<Character, Integer> map = new HashMap<>();
      String alphabets = text.toUpperCase();
      for (int i = 0; i < alphabets.length(); i++) {
         char key = alphabets.charAt(i);
         map.put(key, map.getOrDefault(key, 0) + 1);
      }
      return map;
   }

   private static List<Entry<Character, Integer>> sortByValue(Map<Character, Integer> record) {
      return record.entrySet().stream()
              .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
              .collect(Collectors.toList());
   }

   private static boolean isDuplicate(List<Entry<Character, Integer>> sortedEntry) {
      return sortedEntry.get(0).getValue().equals(sortedEntry.get(1).getValue());
   }
}
