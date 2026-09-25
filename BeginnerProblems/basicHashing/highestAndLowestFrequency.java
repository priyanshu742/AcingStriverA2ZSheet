package BeginnerProblems.basicHashing;

import java.util.HashMap;
import java.util.Map;

/*

Given an array of n integers, find the sum of the frequencies of the highest occurring number and lowest occurring number.

Example 1:
Input: arr = [1, 2, 2, 3, 3, 3]
Output: 4
Explanation: The highest frequency is 3 (element 3), and the lowest frequency is 1 (element 1).
Their sum is 3 + 1 = 4.

Example 2:
Input: arr = [4, 4, 5, 5, 6]
Output: 3
Explanation: The highest frequency is 2 (elements 4 and 5), and the lowest frequency is 1 (element 6). 
Their sum is 2 + 1 = 3.


Constraints:
1 <= n <= 105
1 <= arr[i] <= 104

EASY
*/

class Solution 
{
    public int sumHighestAndLowestFrequency(int[] nums) 
    {
        Map<Integer,Integer> dict=new HashMap<>();
        int highestFrequency=Integer.MIN_VALUE;
        int lowestFrequency=Integer.MAX_VALUE;
        for(int n : nums)
        {
            dict.put(n,dict.getOrDefault(n,0)+1);
        }
        for(int key : dict.keySet())
        {
            int frequency=dict.get(key);
            if(frequency>highestFrequency)
            {
                highestFrequency=frequency;
            }
            if(frequency<lowestFrequency)
            {
                lowestFrequency=frequency;
            }
        }
        return highestFrequency+lowestFrequency;
    }
}