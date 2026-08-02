package ArrayProblems.Easy;

import java.util.HashMap;
import java.util.Map;


/*
Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.

Example 1
Input: nums = [10, 5, 2, 7, 1, 9],  k=15
Output: 4
Explanation:
The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.

Example 2
Input: nums = [-3, 2, 1], k=6
Output: 0
Explanation:
There is no sub-array in the array that sums to 6. Therefore, the output is 0.


Constraints
1<=n<=105
-105<=nums[i]<=105
-109<= k<=109

MEDIUM
*/

class Solution 
{
    public int longestSubarray(int[] nums, int k) 
    {
        // optimal approach
        int sum=0;
        int maxLength=0;

        Map<Integer,Integer> dict=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];

            if(sum==k)
            {
                maxLength=i+1;
            }

            int rem=sum-k;

            if(dict.containsKey(rem))
            {
                maxLength=Math.max(maxLength,i-dict.get(rem));
            }
            
            if(!dict.containsKey(sum))
            {
                dict.put(sum,i);
            }
        }
        return maxLength;
    }
}
