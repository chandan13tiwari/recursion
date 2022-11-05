package medium;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    public static void main(String[] args) {
        String str = "111111111111111111111111111111111111111111111";
        int i = 0;
        List<String> subSet = new ArrayList<>();
        List<String> answer = new ArrayList<>();

        helper(str, i, subSet, answer);

        System.out.println(answer);
    }

    public static void helper(String str, int i, List<String> subSet, List<String> answer) {

        if(i>=str.length()) {
            StringBuilder sb = new StringBuilder();
            subSet.forEach(sb::append);
            answer.add(sb.toString());
            return;
        }

        if(Integer.parseInt(str.substring(i, i + 1)) <= 0) return;

        //taking one digit at a time
        int num = Integer.parseInt(str.substring(i, i + 1));
        if(num >=1 && num <= 26) {
            subSet.add(convertToAlphabet(num));
            helper(str, i + 1, subSet, answer);

            subSet.remove(subSet.size() - 1);
        }

        if(i >= str.length() - 1) return;
        //taking two digit at a time
        num = Integer.parseInt(str.substring(i, i + 2));
        if(num >= 1 && num <= 26) {
            subSet.add(convertToAlphabet(num));
            helper(str, i + 2, subSet, answer);

            subSet.remove(subSet.size() - 1);
        }


    }

    public static String convertToAlphabet(int num) {
        return Character.toString(num + 64);
    }
}
