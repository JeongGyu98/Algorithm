import java.util.*;
class Solution {
    int numGems = 0;

    public int[] solution(String[] gems) {

        HashSet<String> hashSet = new HashSet<>(Arrays.asList(gems));
        HashMap<String, Integer> hashMap = new HashMap<>();
        Queue<String> interval = new LinkedList<>();
        int length = Integer.MAX_VALUE;
        int intervalStart = 0;
        int tempIntervalStart = 0;

        for (int i = 0; i < gems.length;  i++){
            String gemName = gems[i];
            hashMap.put(gemName, hashMap.getOrDefault(gemName, 0) + 1);
            interval.offer(gemName);

            while(true){
                String temp = interval.peek();

                if(hashMap.get(temp) > 1){
                    hashMap.put(temp, hashMap.get(temp) - 1);
                    interval.poll();

                    tempIntervalStart++;
                } else {
                    break;
                }
            }

            if(hashMap.size() == hashSet.size() && length > interval.size()) {
                length = interval.size();
                intervalStart = tempIntervalStart;
            }
        }


        return new int[]{intervalStart + 1, intervalStart + length};
    }
}