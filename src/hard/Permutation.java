package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        String str = "abcd";
        int pos = 0;
        List<String> answer = new ArrayList<>();

        calculatePermutation(str.split(""), pos, answer);
    }

    public static void calculatePermutation(String[] str, int pos, List<String> answer) {
        if(pos >= str.length) {
            answer.add(Arrays.toString(str));
            System.out.println(answer);
        }

        for(int i=pos; i<str.length; i++) {
            //swapping str[i] and str[pos]
            swap(str, i, pos);

            calculatePermutation(str, pos + 1, answer);

            //swapping again str[i] and str[pos] because of backtracking to get the original string
            swap(str, i, pos);
        }
    }

    static void swap(String[] str, int i, int pos) {
        String temp = str[i];
        str[i] = str[pos];
        str[pos] = temp;
    }
}
