package hard;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        int i = 1;
        int k = 2;
        int sumTillNow = 0;
        int summation = 5;

        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        calculateCombinationSum(i, k, sumTillNow, summation, subSet, answer);

        System.out.println(answer);

    }

    //i=1, 2, 3.... 9 and k is the subSet size
    public static void calculateCombinationSum(int i, int k, int sumTillNow, int summation, List<Integer> subSet, List<List<Integer>> answer) {
        // base cases
        if(sumTillNow > summation) return;

        if(k == 0) {
            if(sumTillNow == summation) {
                answer.add(new ArrayList<>(subSet));
            }
            return;
        }

        if(i == 10) return;

        // pick the ith element
        sumTillNow+=i;
        subSet.add(i);
        calculateCombinationSum(i+1, k-1, sumTillNow, summation, subSet, answer);

        //backtracking
        sumTillNow-=i;
        subSet.remove(subSet.size() - 1);

        // ignore the ith element
        calculateCombinationSum(i+1, k ,sumTillNow, summation, subSet, answer);
    }
}
