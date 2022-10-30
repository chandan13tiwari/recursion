package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniquePowerSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2};

        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        //printSequences(arr, 0, path, set);
        helper(arr , 0, new ArrayList<>() , ans);
        System.out.println(ans);
    }

    static void helper(int[] nums, int i, List<Integer> subset, List<List<Integer>> ans)
    {
        // Our base case will hit when our i pointer reaches the end of given array nums[]

        if(i==nums.length)
        {
            ans.add(new ArrayList<>(subset));
            return ;
        }

        // We pick i-th Element

        subset.add(nums[i]);

        // We ask recursion to do rest of the task

        helper(nums, i + 1, subset, ans);

        // Backtrack and Undo the change we have done

        subset.remove(subset.size() - 1);

        // While using Don't Pick option, we must ensure we skip all the Duplicate Occurrences of nums[i]

        while(i < nums.length - 1 && (nums[i] == nums[i + 1] ) )
        {
            i++ ;
        }

        // Our i pointer will stop on the last Duplciate Occurencce of nums[i]

        // Don't Consider the Element and Ask Recursion to generate Unique Subsets

        helper(nums, i + 1, subset, ans);
    }
}
