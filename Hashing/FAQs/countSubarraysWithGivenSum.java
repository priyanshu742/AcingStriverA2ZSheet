package Hashing.FAQs;

import java.util.HashMap;
import java.util.Map;

/* 

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

Example 1
Input: nums = [1, 1, 1], k = 2
Output: 2
Explanation: In the given array [1, 1, 1], there are two subarrays that sum up to 2: [1, 1] and [1, 1]. Hence, the output is 2.

Example 2
Input: nums = [1, 2, 3], k = 3
Output: 2
Explanation: In the given array [1, 2, 3], there are two subarrays that sum up to 3: [1, 2] and [3]. Hence, the output is 2.


Constraints
1 <= nums.length <= 105
-1000 <= nums[i] <= 1000
-107 <= k <= 107

EASY
*/

class Solution1 
{
    public int subarraySum(int[] nums, int k) 
    {
        // brute
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            for(int j=i;j<nums.length;j++)
            {
                sum=sum+nums[j];
                if(sum==k)
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
    public int subarraySum(int[] nums, int k) 
    {
        // optimal
        int count=0;
        int sum=0;
        Map<Integer,Integer> dict=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum==k)
            {
                count++;
            }
            int prefix=sum-k;
            if(dict.containsKey(prefix))
            {
                count=count+dict.get(prefix);
            }
            dict.put(sum,dict.getOrDefault(sum,0)+1);
            
        }
        return count;
    }
}