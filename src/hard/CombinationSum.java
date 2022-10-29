package hard;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {

        int i = 0;
        int sum = 5;
        int sumTillNow = 0;
        List<Integer> arr = new ArrayList<>(List.of(1, 2, 3));
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        calculateCombinationSum(i, arr, sum, sumTillNow, subSet, answer);
        System.out.println(answer);
    }

    public static void calculateCombinationSum(int i, List<Integer>  arr, int sum, int sumTillNow, List<Integer> subSet, List<List<Integer>> answer) {

        if(sumTillNow == sum) {
            answer.add(new ArrayList<>(subSet));

            return;
        }

        if(sumTillNow > sum) return;

        if(i >= arr.size()) return;



        // skip the ith element
        calculateCombinationSum(i+1, arr, sum, sumTillNow, subSet, answer);

        // taking the ith element
        sumTillNow += arr.get(i);
        subSet.add(arr.get(i));
        calculateCombinationSum(i, arr, sum, sumTillNow, subSet, answer);

        //backtracking
        sumTillNow -= arr.get(i);
        subSet.remove(subSet.size() - 1);
    }
}
