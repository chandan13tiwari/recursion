package hard;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        List<Integer> path = new ArrayList<>();

        printSequences(arr, 0, path);
    }

    public static void printSequences(int[] arr, int index, List<Integer> path) {
        if (index == arr.length) {
            if(path.size() > 0) {
                System.out.println(path);
            }
        } else {
            //taken
            printSequences(arr, index + 1, path);
            path.add(arr[index]);

            //non taken
            printSequences(arr, index + 1, path);
            path.remove(path.size() - 1);
        }
    }
}
