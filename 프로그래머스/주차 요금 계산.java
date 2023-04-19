import java.io.*;
import java.util.*;

public class Main {

   import java.io.*;
import java.util.*;

   public ArrayList<Integer> solution(int[] fees, String[] records) {
      ArrayList<Integer> answer = new ArrayList<>();

      int timeCriteria = fees[0];
      int feeCriteria = fees[1];
      int perTime = fees[2];
      int perFee = fees[3];

      HashMap<String, String> hm = new HashMap<>();
      HashMap<String, Integer> carFee = new HashMap<>();

      for(String record : records){
         StringTokenizer st = new StringTokenizer(record);
         String time = st.nextToken();
         String carNumber = st.nextToken();
         String inOut = st.nextToken();

         if(!hm.containsKey(carNumber)){
            hm.put(carNumber, time);
         } else {
            String inTime = hm.get(carNumber);
            carFee.put(carNumber, carFee.getOrDefault(carNumber, 0) + calTime(inTime, time));
            hm.remove(carNumber);
         }
      }

      if(!hm.isEmpty()){
         for(String key : hm.keySet()){
            carFee.put(key, carFee.getOrDefault(key, 0) + calTime(hm.get(key), "23:59"));
         }
      }
      // hm에 남은것들 23:59 기준 요금 계산 해야됨

      List<String> keyList = new ArrayList<>(carFee.keySet());
      keyList.sort((s1, s2) -> s1.compareTo(s2));
      for (String key : keyList) {
         answer.add(calFee(carFee.get(key), feeCriteria, timeCriteria, perTime, perFee));
      }

      return answer;
   }

   public static int calTime(String in, String out){

      int hour = 0;
      int min = 0;

      hour = Integer.parseInt(out.substring(0, 2)) - Integer.parseInt(in.substring(0, 2));
      min = Integer.parseInt(out.substring(3)) - Integer.parseInt(in.substring(3));

      min += (hour * 60);

      return min;
   }

   public static int calFee(int time, int feeCriteria, int timeCriteria, int perTime, int perFee){
      int fee = 0;

      if(time > timeCriteria){
         fee += feeCriteria;
         time -= timeCriteria;
      } else {
         return feeCriteria;
      }

      if((time) % perTime == 0){
         fee += ((time) / perTime) * perFee;
      } else {
         fee += ((time) / perTime + 1) * perFee;
      }

      return fee;
   }

   public static void main(String[] args) throws IOException {


   }


}
