package Hashing.FAQs;

import java.util.HashMap;
import java.util.Map;

/* 

Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. 
If no such sub-array exists, return 0.

Example 1
Input: nums = [10, 5, 2, 7, 1, 9],  k=15
Output: 4
Explanation:
The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. 
This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. 
Therefore, the length of this sub-array is 4.

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

class Solution1
{
    public int longestSubarray(int[] nums, int k) 
    {
        // brute
        int longest=0;
        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            int count=0;
            for(int j=i;j<nums.length;j++)
            {
                sum=sum+nums[j];
                count++;
                if(sum==k)
                {
                    if(count>longest)
                    {
                        longest=count;
                    }
                }
            }
        }
        return longest;
    }
}

class Solution2
{
    public int longestSubarray(int[] nums, int k) 
    {
        // optimal 
        // array containing positive,negative and zeroes
        int longest=0;
        int sum=0;
        Map<Integer,Integer> dict=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum==k)
            {
                longest=i+1;
            }
            int prefix=sum-k;
            if(dict.containsKey(prefix))
            {
                longest=Math.max(longest,i-dict.get(prefix));
            }
            if(!dict.containsKey(sum))
            {
                dict.put(sum,i);
            }
        }
        return longest; 
    }
}

class Solution3
{
    public int longestSubarray(int[] nums, int k) 
    {
        // sliding window
        // optimal if array contains only positives
        int left=0;
        int right=0;
        int sum=0;
        int longest=0;
        while(right<nums.length)
        {
            sum=sum+nums[right];
            while(left<=right && sum>k)
            {
                sum=sum-nums[left];
                left++;
            }
            if(sum==k)
            {
                int count=(right-left+1)
                if(count>longest)
                {
                    longest=count;
                }
            }
            right++;
        }
        return longest;
    }
}

