import java.util.*;

class Solution {

    public static long answer = 0;
    public static ArrayList<Long> numList = new ArrayList<>();
    public static ArrayList<String> opList = new ArrayList<>();

    public long solution(String expression) {
        String number = "";
        String op[][] = {{"+", "*", "-"},{"+", "-", "*"},{"-","*","+"},{"-","+","*"},{"*","+","-"},{"*","-","+"}};

        for(int i = 0; i < expression.length(); i++){
            char exp = expression.charAt(i);
            if(exp == '+'|| exp == '*' || exp == '-'){
                opList.add(exp+"");
                numList.add(Long.parseLong(number));
                number = "";
            } else {
                number += exp;
            }
        }
        numList.add(Long.parseLong(number));

        for(int i = 0; i < op.length; i++){
            ArrayList<Long> sub_numList = new ArrayList<>(numList);
            ArrayList<String> sub_opList = new ArrayList<>(opList);
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < sub_opList.size(); k++){
                    if(op[i][j].equals(sub_opList.get(k))){
                        sub_numList.set(k, cal(sub_numList.get(k), sub_numList.get(k + 1), op[i][j]));
                        sub_numList.remove(k + 1);
                        sub_opList.remove(k);
                        k--;
                    }
                }
            }
            System.out.println(Math.abs(sub_numList.get(0)));
            if ( Math.abs(sub_numList.get(0)) > answer ){
                answer = Math.abs(sub_numList.get(0));
            }

        }


        return answer;
    }

    static long cal(long a, long b, String op){
        long result = 0;
        switch(op){
            case "+":
                result = a + b;
                break;
            case "*":
                result = a * b;
                break;
            case "-":
                result = a - b;
                break;
        }
        return result;
    }

}