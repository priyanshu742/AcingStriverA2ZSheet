package ArrayProblems.Medium;

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


class Solution 
{
    public int majorityElement(int[] nums) 
    {
        //BOYE -MOORE'S VOTING ALGORITHM
        int element=0;
        int count=0;

        for(int n:nums)
        {
            if(count==0)
            {
                element=n;
            }

            if(n==element)
            {
                count++;
            }
            else
            {
                count--;
            }
        }
        return element;
    }
}
