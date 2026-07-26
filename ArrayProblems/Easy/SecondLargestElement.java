package ArrayProblems.Easy;

/*

Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.

Example 1
Input: nums = [8, 8, 7, 6, 5]
Output: 7
Explanation:
The largest value in nums is 8, the second largest is 7

Example 2
Input: nums = [10, 10, 10, 10, 10]
Output: -1
Explanation:
The only value in nums is 10, so there is no second largest value, thus -1 is returned


Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104
nums may contain duplicate elements.

EASY
*/


class Solution 
{
    public int secondLargestElement(int[] nums) 
    {
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>largest)
            {
                secondLargest=largest;
                largest=nums[i];
            }
            else if(nums[i]>secondLargest && nums[i]!=largest)
            {
                secondLargest=nums[i];
            }
        }
        if(secondLargest==Integer.MIN_VALUE)
        {
            return -1;
        }
        else
        {
            return secondLargest;

        }
    }
}