package ArrayProblems.Hard;

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
    // optimal
    public int maxLen(int[] arr) 
    {
        int sum=0;
        int maxLen=0;
        Map<Integer,Integer> dict=new HashMap<>();
        dict.put(0,-1);
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            if(dict.containsKey(sum))
            {
                maxLen=Math.max(maxLen,i-dict.get(sum));
            }
            else
            {
                dict.put(sum,i);
            }
        }
        return maxLen;
    }
}
