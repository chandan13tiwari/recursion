package medium;

import java.util.HashSet;
import java.util.Set;

public class HouseRobber {
    public static void main(String[] args) {
        int[] num = {2, 7, 9, 3, 1};
        int i = 0;
        int sum = 0;

        Set<Integer> answer = new HashSet<>();

        helper(num, i, sum, answer);

        System.out.println(answer);

        System.out.println(answer.stream().max(Integer::compare).get());
    }

    public static void helper(int[] num, int i, int sum, Set<Integer> answer) {
        //base cases
        if(i >= num.length) {
            answer.add(sum);
            return;
        }

        //pick ith element and skipping i+1th eleement
        sum += num[i];
        helper(num, i+2, sum, answer);

        //backtracking
        sum -= num[i];

        i = i+1;
        if(i >= num.length) return;
        //pick ith element and skipping i+1th eleement
        sum += num[i];
        helper(num, i+2, sum, answer);

        //backtracking
        sum -= num[i];
        i = i - 1;
    }
}
