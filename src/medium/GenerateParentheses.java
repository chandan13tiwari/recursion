package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int open = 0;
        int close = 0;
        int n = 3;
        StringBuilder subSet = new StringBuilder();
        List<String> answer =  new ArrayList<>();

        helper(n, open, close, subSet, answer);

        System.out.println(answer);
    }

    public static void helper(int n, int open, int close, StringBuilder subSet, List<String> answer) {

        // base case
        if(open == n && close == n) {
            answer.add(subSet.toString());
            return;
        }

        // opening bracket
        if(open < n) {
            helper(n, open + 1, close, subSet.append("("), answer);
        }


        //closing bracket
        if(close < open) {
            helper(n, open, close + 1, subSet.append(")"), answer);
        }
    }
}
