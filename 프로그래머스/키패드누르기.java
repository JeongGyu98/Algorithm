import java.io.*;

class Solution {
    public static int PositionLeft = 10, PositionRight = 12;

    public StringBuilder solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i ++){
            if(numbers[i] == 0){
                sb.append(findHand(11, hand));
            }
            sb.append(findHand(numbers[i], hand));
        }

        return sb;
    }

    public String findHand(int target, String hand) {
        int disLeft, disRight = 0;

        if(target == 1 || target == 4 || target == 7){
            PositionLeft = target;
            return "L";
        } else if(target == 3 || target == 6 || target == 9){
            PositionRight = target;
            return "R";
        } else if (target == 2 || target == 5 || target == 8 || target == 11){
            disRight = Math.abs(target - PositionRight) / 3 + Math.abs(target - PositionRight) % 3;
            disLeft = Math.abs(target - PositionLeft) / 3 + Math.abs(target - PositionLeft) % 3;
            if (disRight == disLeft) {
                if (hand.equals("right")) {
                    PositionRight = target;
                    return "R";
                } else {
                    PositionLeft = target;
                    return "L";
                }

            } else {
                if (disRight < disLeft) {
                    PositionRight = target;
                    return "R";
                }
                PositionLeft = target;
                return "L";
            }
        }
        return "";
    }
}