package hard;

import java.util.*;

public class PowerSet {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int i = 0;

        PowerSet obj = new PowerSet();
        obj.powerSet(list, new ArrayDeque<>(), i, new ArrayList<>());

    }

    void powerSet(List<Integer> arr, Deque<Integer> subset, int i, List<Deque<Integer>> answer) {

        if(i == arr.size()) {
            answer.add(subset);
            return;
        }

       //for take
        subset.add(arr.get(i));
        powerSet(arr, subset, i+1, answer);

        //for not take
        subset.remove();
        powerSet(arr, subset, i+1, answer);
    }
}
