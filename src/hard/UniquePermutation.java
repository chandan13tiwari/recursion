package hard;

import java.util.*;

public class UniquePermutation {
    public static void main(String[] args) {
        String str = "abcd";
        int pos = 0;
        List<String> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();

        calculatePermutation(str.split(""), pos, answer, set);
    }

    public static void calculatePermutation(String[] str, int pos, List<String> answer, Set<String> set) {
        if(pos >= str.length) {
            answer.add(Arrays.toString(str));
            System.out.println(answer);
        }

        for(int i=pos; i<str.length; i++) {
            // check if the char is already present in the set or not, if not then add it else continue
            if(set.contains(str[i])) continue;
            set.add(str[i]);
            //swapping str[i] and str[pos]
            swap(str, i, pos);

            calculatePermutation(str, pos + 1, answer, set);

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
