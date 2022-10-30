package hard;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1, 1, 2));
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        int sum = 0;
        int i = 0;
        int target = 2;
        int n = 2;

        calculateCombinationSum2(arr, i, n, sum, target, subSet, answer);

        System.out.println(answer);
    }

    public static void calculateCombinationSum2(List<Integer> arr, int i, int n, int sum, int target, List<Integer> subSet, List<List<Integer>> answer) {

        if(sum == target) {
            answer.add(new ArrayList<>(subSet));
            return;
        }

        if(sum > target) return;

        if(i == n) return;

        // pick
        subSet.add(arr.get(i));
        sum += arr.get(i);
        calculateCombinationSum2(arr, i+1, n, sum, target, subSet, answer);
        // backtracking
        subSet.remove(subSet.size() - 1);
        sum-=arr.get(i);


        // skip all the occurance of the number
        while(i+1 < arr.size() && arr.get(i) == arr.get(i+1))
            i++;
        calculateCombinationSum2(arr, i+1, n, sum, target, subSet, answer);
    }
}
