package Hashing.FAQs;

import java.util.HashMap;
import java.util.Map;

/*

Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.

Example 1
Input : nums = [4, 2, 2, 6, 4], k = 6
Output : 4
Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]

Example 2
Input :nums = [5, 6, 7, 8, 9], k = 5
Output : 2
Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]


Constraints
1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109

EASY
*/

class Solution1
{
    public int subarraysWithXorK(int[] nums, int k) 
    {
        // brute
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            int xor=0;
            for(int j=i;j<nums.length;j++)
            {
                xor=xor^nums[j];
                if(xor==k)
                {
                    count++;
                }
            }
        }
        return count;
    }
}

class Solution2
{
    public int subarraysWithXorK(int[] nums, int k) 
    {
        // optimal
        int count=0;
        int xr=0;
        Map<Integer,Integer> dict=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            xr=xr^nums[i];
            if(xr==k)
            {
                count++;
            }
            int prefix=xr^k;
            if(dict.containsKey(prefix))
            {
                count=count+dict.get(prefix);
            }
            dict.put(xr,dict.getOrDefault(xr,0)+1);
        }
        return count;
    }
}