package fraz;

import java.util.*;

public class UniquePermutation {

    public static void main(String[] args) {
        int pos = 0;
        int n = 3;
        int k = 3;

        String[] arr = new String[n];

        for(int j=0;j<n; j++) {
            arr[j] = String.valueOf(j+1);
        }

        List<List<String>> ans = new ArrayList<>();

        helper(pos , arr.length , arr , ans) ;

        System.out.println(ans);

    }
    public static void helper(int pos, int n, String[] nums, List<List<String>> ans) {
        // If we have reached the end of nums, we have found a Valid Permutations of nums

        if(pos >= n) {
            List<String> permutation = ConvertToArray(nums);
            ans.add(new ArrayList(permutation)) ;
            return ;
        }

        // Otherwise we iterate over all the other elements and try to generate Permutations by swapping element at pos with element at i

        // Hashset ensures we are not taking duplicates and thus not making Duplicate Permutation

        HashSet<String> set = new HashSet<>();

        for(int i = pos ; i < n ; i++) {
            // If we have encountered the element before, we will simply skip the rest of iterations

            if(set.contains( nums[i] ))
                continue;

            // We insert nums[i] so that we don't create Duplicate Permutations

            set.add(nums[i]);

            // We create one Unique Permutation by swapping

            swap(pos , i, nums) ;

            // And we ask Recursion to handle rest of the task

            helper(pos + 1 , n , nums , ans) ;

            // But after we come back, we must backtrack and undo the changes we have done

            swap(pos , i, nums) ;
        }
    }

    public static void swap(int i, int j, String[] nums) {
        // Swaping the elements
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static List<String> ConvertToArray(String[] nums) {
        // Converting the array into List
        List<String> ans = new ArrayList<>();
        Collections.addAll(ans, nums);
        return ans;
    }
}
