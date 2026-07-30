package ImportantSortingTechniques.Sorting_2;


/*

Given an array of integers called nums, sort the array in non-decreasing order using the quick sort algorithm and return the sorted array.
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
1 <= nums.length <= 105
-104 <= nums[i] <= 104
nums[i] may contain duplicate values.

EASY
*/

class Solution 
{
    public int[] quickSort(int[] nums) 
    {
        int low=0;
        int high=nums.length-1;

        return qs(nums,low,high);
    }

    public int[] qs(int nums[],int low,int high)
    {
        if(low<high)
        {
            int partitionIndex=partition(nums,low,high);
            qs(nums,low,partitionIndex-1);
            qs(nums,partitionIndex+1,high);
            return nums;
        }
        return nums;
    }

    public int partition(int nums[],int low,int high)
    {
        int pivot=nums[low];
        int i=low;
        int j=high;
        while(i<j)
        {
            while(nums[i]<=pivot && i<=high-1)
            {
                i++;
            }
             while(nums[j]>pivot && j>=low+1)
            {
                j--;
            }
            if(i<j)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp=nums[low];
        nums[low]=nums[j];
        nums[j]=temp;
        return j;
    }
}
