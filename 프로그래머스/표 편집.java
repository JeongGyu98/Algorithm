import java.util.*;
class Solution {

    static int[] arr;
    public StringBuilder solution(int n, int k, String[] cmd) {
        StringBuilder answer = new StringBuilder();
        int size = n ;

        Stack<Integer> remove = new Stack<>();

        for(int i = 0;  i < cmd.length; i++){
            char command = cmd[i].charAt(0);

            switch(command){
                case 'D':
                    k += Integer.parseInt(cmd[i].substring(2));
                    break;
                case 'U':
                    k -= Integer.parseInt(cmd[i].substring(2));;
                    break;
                case 'Z':
                    if(remove.pop() <= k){
                        k++;
                    }
                    size++;
                    break;
                case 'C':
                    remove.add(k);
                    size--;
                    if(k == size){
                        k--;
                    }
                    break;
                default:
                    break;
            }
        }

        for(int i = 0; i < size; i++){
            answer.append("O");
        }
        while(!remove.isEmpty()){
            answer.insert(remove.pop(), "X");
        }


        return answer;
    }
}