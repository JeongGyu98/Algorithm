class Solution {
    public int solution(String s) {
        int answer = 0;

        String[] num = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        String[] numStr = new String[] {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};

        for(int i = 0; i < num.length; i++){
            s = s.replace(numStr[i], num[i]);
        }

        answer = Integer.parseInt(s);

        return answer;
    }
}