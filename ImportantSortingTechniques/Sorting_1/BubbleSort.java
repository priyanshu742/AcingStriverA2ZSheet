package ImportantSortingTechniques.Sorting_1;


/*

Given an array of integers called nums,sort the array in non-decreasing order using the bubble sort algorithm and return the sorted array.
A sorted array in non-decreasing order is an array where each element is greater than or equal to all preceding elements in the array.


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


class Solution 
{
    public int[] bubbleSort(int[] nums) 
    {
        int size=nums.length;

        for(int i=size-1;i>=1;i--)
        {
            for(int j=0 ; j<=i-1;j++)
            {
                if(nums[j+1]<nums[j])
                {
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
        return nums;
    }
}
