import java.util.*;
import java.io.*;

class Solution {
    public static String solution(String S) {

        Set<String> variables = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        char[] chars = new char[S.length()];
        for(int i = 0; i < S.length(); i++){
            chars[i] = S.charAt(i);
        }
        boolean inComment = false;
        int numComment = 0;

        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if (c == '/' && i + 1 < chars.length && chars[i+1] == '*'){
                inComment = true;
                numComment++;
                i++;
            } else if (c == '*' && i + 1 < chars.length && chars[i+1] == '/'){
                inComment = false;
                numComment--;
                i++;
            } else if (!inComment && numComment == 0){
                if (c == '(' || c =='[' || c == '{'){
                    stack.push(c);
                } else if (c == ')' || c == ']' || c == '}'){
                    if(stack.isEmpty()){
                        return "FALSE";
                    }
                    char top = stack.pop();

                    if((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')){
                        return "FALSE";
                    }
                }
            }
        }

        if(stack.isEmpty()){
            return "TRUE";
        } else {
            return "FALSE";
        }

    }
}