package easy;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        String str = "abc";
        int i = 0;
        List<String> subSet = new ArrayList<>();
        List<List<String>> answer = new ArrayList<>();

        helper(str.split(""), i, subSet, answer);

        System.out.println(answer);
    }

    public static void helper(String[] str, int i, List<String> subSet, List<List<String>> answer) {

        //base cases
        if(i >= str.length) {
            if (subSet.size() != 0)
                answer.add(new ArrayList<>(subSet));
            return;
        }

        // taking ith element
        subSet.add(str[i]);
        helper(str, i+1, subSet, answer);

        //backtracking
        subSet.remove(subSet.size() - 1);

        //skipping ith element
        helper(str, i+1, subSet, answer);
    }
}
