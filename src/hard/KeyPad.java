package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyPad {
    public static void main(String[] args) {
        String arr = "37";
        int i = 0;
        List<String> subSet = new ArrayList<>();
        List<List<String>> answer = new ArrayList<>();

        calculateKeyCombination(arr, i, subSet, answer);

        System.out.println(answer);
    }

    // 3, 7
    public static void calculateKeyCombination(String arr, int i, List<String> subSet, List<List<String>> answer) {
        if(i == arr.length()) {
            answer.add(new ArrayList<>(subSet));
            return;
        }

        List<String> comb1 = keyPad(Integer.parseInt(String.valueOf(arr.charAt(i))));
           comb1.forEach(e -> {
               subSet.add(e);
               calculateKeyCombination(arr, i+1, subSet, answer);

               subSet.remove(subSet.size() - 1);
           });

    }

    public static List<String> keyPad(int num) {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(2, List.of("a", "b", "c"));
        map.put(3, List.of("d", "e", "f"));
        map.put(4, List.of("g", "h", "i"));
        map.put(5, List.of("j", "k", "l"));
        map.put(6, List.of("m", "n", "o"));
        map.put(7, List.of("p", "q", "r", "s"));
        map.put(8, List.of("t", "u", "v"));
        map.put(9, List.of("w", "x", "y", "z"));

        return map.get(num);
    }
}
