package sorting.algorithms;



/*

Given an array of integers nums, sort the array in non-decreasing order using the selection sort algorithm and return the sorted array.
A sorted array in non-decreasing order is an array where each element is greater than or equal to all previous elements in the array.

Example 1
Input: nums = [7, 4, 1, 5, 3]
Output: [1, 3, 4, 5, 7]
Explanation: 1 <= 3 <= 4 <= 5 <= 7.
Thus the array is sorted in non-decreasing order.

Example 2
Input: nums = [5, 4, 4, 1, 1]
Output: [1, 1, 4, 4, 5]
Explanation: 1 <= 1 <= 4 <= 4 <= 5.
Thus the array is sorted in non-decreasing order.


Constraints
1 <= nums.length <= 1000
-104 <= nums[i] <= 104
nums[i] may contain duplicate values.

EASY
*/

class Solution1
{
    public int[] selectionSort(int[] nums) 
    {
        int n=nums.length;
        for(int i=0;i<=n-2;i++)
        {
            int min=i;
            for(int j=i;j<=n-1;j++)
            {
                if(nums[j]<nums[min])
                {
                    min=j;
                }
            }
            int temp=nums[i];
            nums[i]=nums[min];
            nums[min]=temp;
        }
        return nums;
    }
}

class Solution2 
{
    public int[] selectionSort(int[] nums) 
    {
        // fully optimal;
        int n=nums.length;
        for(int i=0;i<=n-2;i++)
        {
            int min=i;
            for(int j=i+1;j<=n-1;j++)
            {
                if(nums[j]<nums[min])
                {
                    min=j;
                }
            }
            if(min!=i)
            {
                int temp=nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }
        }
        return nums;
    }
}