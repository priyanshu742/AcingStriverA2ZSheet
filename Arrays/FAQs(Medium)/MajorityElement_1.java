

import java.util.HashMap;
import java.util.Map;

/* 

Given an integer array nums of size n, return the majority element of the array.
The majority element of an array is an element that appears more than n/2 times in the array. 
The array is guaranteed to have a majority element.

Example 1
Input: nums = [7, 0, 0, 1, 7, 7, 2, 7, 7]
Output: 7
Explanation:
The number 7 appears 5 times in the 9 sized array

Example 2
Input: nums = [1, 1, 1, 2, 1, 2]
Output: 1
Explanation:
The number 1 appears 4 times in the 6 sized array


Constraints
n == nums.length.
1 <= n <= 105
-104 <= nums[i] <= 104
One value appears more than n/2 times.

EASY
*/

class Solution1
{
    public int majorityElement(int[] nums) 
    {
        // brute
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int major=nums[i];
            int count=0;
            for(int j=0;j<n;j++)
            {
                if(major==nums[j])
                {
                    count++;
                }
                if(count>n/2)
                {
                    return major;
                }
            }
        }
        return -1;
    }
}

class Solution2
{
    public int majorityElement(int[] nums) 
    {
        // better
        Map<Integer,Integer> dict=new HashMap<>();
        int n=nums.length;
        for(int i : nums)
        {
            dict.put(i,dict.getOrDefault(i,0)+1);
            if(dict.get(i)>n/2)
            {
                return i;
            }
        }
        return -1;  
    }
}

class Solution3
{
    public int majorityElement(int[] nums) 
    {
        // Boyer - Moore's voting algorithm
        // optimal
        int count=0;
        int major=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
            {
                major=nums[i];
                count=1;
            }
            else if(major==nums[i])
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return major;
    }
}
