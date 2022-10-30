package hard;

import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {

        // so here we are not taking any list, becoz in combination, given is only the upper bound which is 'n' and its like 1, 2, ..., n
        int n = 20;
        // k is the subset size, means we need to include only 2 size subsets from the combination
        int k = 10;
        int i = 1;

        List<Integer> subSet = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        calculateCombination(n, k, i, subSet, answer);

        System.out.println(answer);

    }

    static void calculateCombination(int n, int k, int i, List<Integer> subSet, List<List<Integer>> answer) {

        if(k == 0) {
            answer.add(new ArrayList<>(subSet));
            return;
        }

        // If we don't have enough elements to make our subset, we shouldn't proceed further

        if (k > n - i + 1)
            return;

        if(i >= n) return;
        // take the ith element
        subSet.add(i);
        calculateCombination(n, k-1, i+1, subSet, answer);

        //skip the ith element
        subSet.remove(subSet.size() - 1);
        calculateCombination(n, k, i+1, subSet, answer);
    }
}
