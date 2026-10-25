package Hashing.FAQs;

import java.util.HashMap;
import java.util.Map;

/* 

You are given an integer array arr of size n which contains both positive and negative integers.
Your task is to find the length of the longest contiguous subarray with sum equal to 0.
Return the length of such a subarray. If no such subarray exists, return 0.

Example 1
Input: arr = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation:
The subarray [-2, 2, -8, 1, 7] sums up to 0 and has the maximum length among all such subarrays.

Example 2
Input: arr = [2, 10, 4]
Output: 0
Explanation:
There is no subarray whose elements sum to 0.


Constraints
1 <= arr.length <= 106
-103 <= arr[i] <= 103 for each valid index i

EASY
*/

class Solution 
{
    public int maxLen(int[] arr) 
    {
        // brute
        int longest=0;
        for(int i=0;i<arr.length;i++)
        {
            int count=0;
            int sum=0;
            for(int j=i;j<arr.length;j++)
            {
                sum=sum+arr[j];
                count++;
                if(sum==0)
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

class Solution 
{
    public int maxLen(int[] arr) 
    {
       // optimal
       int longest=0;
       int sum=0;
       Map<Integer,Integer> dict=new HashMap<>();
       for(int i=0;i<arr.length;i++)
       {
            sum=sum+arr[i];
            if(sum==0)
            {
                longest=i+1;
            }
            if(dict.containsKey(sum))
            {
                longest=Math.max(longest,i-dict.get(sum));
            }
            if(!dict.containsKey(sum))
            {
                dict.put(sum,i);
            }
       }
       return longest;
    }
}