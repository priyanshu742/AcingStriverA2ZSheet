package ArrayProblems.Medium;


/* 

Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order.
The sorting must be done in-place, without making a copy of the original array.

Example 1
Input: nums = [1, 0, 2, 1, 0]
Output: [0, 0, 1, 1, 2]
Explanation:
The nums array in sorted order has 2 zeroes, 2 ones and 1 two

Example 2
Input: nums = [0, 0, 1, 1, 1]
Output: [0, 0, 1, 1, 1]
Explanation:
The nums array in sorted order has 2 zeroes, 3 ones and zero twos


Constraints
1 <= nums.length <= 105
nums consists of 0, 1 and 2 only.

EASY
*/


class Solution 
{
    public void sortZeroOneTwo(int[] nums) 
    {
        int low=0;
        int mid=0;
        int high=nums.length-1;

        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                swap(nums,mid,low);
                mid++;
                low++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else if(nums[mid]==2)
            {
                swap(nums,mid,high);
                high--;
            }
        }
    }

    public void swap(int nums[],int i,int j)
    {
        int temp=nums[j];
        nums[j]=nums[i];
        nums[i]=temp;
    }

}