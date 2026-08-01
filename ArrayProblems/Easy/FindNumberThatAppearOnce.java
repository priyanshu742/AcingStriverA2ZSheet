package ArrayProblems.Easy;

import java.util.HashMap;
import java.util.Map;

/*

Given an array of nums of n integers. Every integer in the array appears twice except one integer. Find the number that appeared once in the array.

Example 1
Input : nums = [1, 2, 2, 4, 3, 1, 4]
Output : 3
Explanation : The integer 3 has appeared only once.

Example 2
Input : nums = [5]
Output : 5
Explanation : The integer 5 has appeared only once.


Constraints
1 <= n <= 105
-3*105 <= nums[i] <= 3*105

EASY
*/

class Solution 
{
    public int singleNumber(int[] nums) 
    {
        Map<Integer,Integer> dict=new HashMap<>();
        for(int n : nums)
        {
            dict.put(n,dict.getOrDefault(n,0)+1);
        }

        for(int n : dict.keySet())
        {
            if(dict.get(n)==1)
            {
                return n;
            }
        }
        return 0;
    }
}
