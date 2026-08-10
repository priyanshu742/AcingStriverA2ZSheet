package ArrayProblems.Hard;

import java.util.ArrayList;
import java.util.List;

/*

Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.

Example 1
Input: nums = [1, 2, 1, 1, 3, 2]
Output: [1]
Explanation:
Here, n / 3 = 6 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1]

Example 2
Input: nums = [1, 2, 1, 1, 3, 2, 2]
Output: [1, 2]
Explanation:
Here, n / 3 = 7 / 3 = 2.
Therefore the elements appearing 3 or more times is : [1, 2]


Constraints
n == nums.length.
2 <= n <= 105
-104 <= nums[i] <= 104

EASY
*/
class Solution 
{
    public List<Integer> majorityElementTwo(int[] nums) 
    {
        // maximum optimised solution
        int reqFrequency=nums.length/3;
        int count1=0;
        int count2=0;
        int element1=Integer.MIN_VALUE;
        int element2=Integer.MIN_VALUE;

        List<Integer> arr=new ArrayList<>();

        for(int n: nums)
        {
            if(count1==0 && n!=element2)
            {
                count1=1;
                element1=n;
            }
            else if(count2==0 && n!=element1)
            {
                count2=1;
                element2=n;
            }
            else if(n==element1)
            {
                count1++;
            }
            else if(n==element2)
            {
                count2++;
            }
            else
            {
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0; 
        for(int n:nums)
        {
            if(element1==n)
            {
                count1++;
            }
            if(element2==n)
            {
                count2++;
            }
        }

        if(count1>reqFrequency)
        {
            arr.add(element1);
        }            
        if(count2>reqFrequency)
        {
            arr.add(element2); 
        }
        return arr;     
    }
}
