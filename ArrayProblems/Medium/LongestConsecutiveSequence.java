package ArrayProblems.Medium;

import java.util.HashSet;
import java.util.Set;

/* 

Given an array nums of n integers.
Return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.

Example 1
Input: nums = [100, 4, 200, 1, 3, 2]
Output: 4
Explanation:
The longest sequence of consecutive elements in the array is [1, 2, 3, 4], which has a length of 4. 
This sequence can be formed regardless of the initial order of the elements in the array.

Example 2
Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
Output: 9
Explanation:
The longest sequence of consecutive elements in the array is [0, 1, 2, 3, 4, 5, 6, 7, 8], which has a length of 9. 


constraints
1 <= nums.length <= 105
-109 <= nums[i] <= 109

MEDIUM
*/

class Solution 
{
    public int longestConsecutive(int[] nums)
    {
        // OPTIMAL
        int longest=1;
        Set<Integer> result=new HashSet<>();
        
        for(int n:nums)
        {
            result.add(n);
        }
        
        for(int n: result)
        {
            if(!result.contains(n-1))
            {
                int count=1;
                int x=n;
                while(result.contains(x+1))
                {
                    x=x+1;
                    count=count+1;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}