package ArrayProblems.Medium;

import java.util.HashMap;
import java.util.Map;

/* 

Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such that they add up to target.
Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in any order.

Example 1
Input: nums = [1, 6, 2, 10, 3], target = 7
Output: [0, 1]
Explanation:
nums[0] + nums[1] = 1 + 6 = 7

Example 2
Input: nums = [1, 3, 5, -7, 6, -3], target = 0
Output: [1, 5]
Explanation:
nums[1] + nums[5] = 3 + (-3) = 0


Constraints
2 <= nums.length <= 105
-104 <= nums[i] <= 104
-105 <= target <= 105
Only one valid answer exists.

EASY
*/

class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        int result[]=new int[2];

        Map<Integer,Integer> dict=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int complement=target-nums[i];

            if(dict.containsKey(complement))
            {
                result[0]=dict.get(complement);
                result[1]=i;
                return result;
            }
            dict.put(nums[i],i);
        }
        return result;
    }
}
