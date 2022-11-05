package easy;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumToK {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(5, -1, 8, 2, 7, 0));
        int n = arr.size();
        int i = 0;
        int sum = 0;
        int k = 7;
        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        helper(arr, n, i, k, sum, subSet, answer);

        System.out.println(answer);

    }

    public static void helper(List<Integer> arr, int n, int i, int k, int sum, List<Integer> subSet, List<List<Integer>> answer) {
        //base case
        if(sum == k) {
            answer.add(new ArrayList<>(subSet));
            return;
        }

        if(sum > k) return;

        //picking ith element

        if(i >= n) return;
        sum += arr.get(i);
        subSet.add(arr.get(i));
        helper(arr, n, i+1, k, sum, subSet, answer);

        //backtracking
        subSet.remove(subSet.size() - 1);
        sum -= arr.get(i);

        //skipping ith element
        helper(arr, n, i+1, k, sum, subSet, answer);
    }
}
