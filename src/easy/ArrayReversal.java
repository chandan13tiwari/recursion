package easy;

import java.util.Arrays;

public class ArrayReversal {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int start = 0;
        int end = arr.length - 1;

        ArrayReversal obj = new ArrayReversal();

        System.out.println(Arrays.toString(obj.reversal(arr, start, end)));
    }

    int[] reversal(int[] arr, int start, int end) {

        if(start >= end) {
            return arr;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        return reversal(arr, ++start, --end);
    }
}
