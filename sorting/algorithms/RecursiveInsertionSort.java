package sorting.algorithms;

/*

Given an array of integers nums, sort the array in non-decreasing order using the recursive Insertion Sort algorithm, and return the sorted array.
You must implement Insertion Sort using recursion only.
Do not use loops (like for or while) or built-in sorting functions (sort, Arrays.sort, etc.).
A sorted array in non-decreasing order is an array where each element is greater than or equal to all elements that come before it.

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
    public int[] insertionSort(int[] nums) 
    {
        return recursiveInsertion(nums,1);
    }
    public int[] recursiveInsertion(int nums[],int index)
    {
        if(index>=nums.length)
        {
            return nums;
        }
        int j=index;
        while(j>0 && nums[j-1]>nums[j])
        {
            int temp=nums[j];
            nums[j]=nums[j-1];
            nums[j-1]=temp;
            j--;
        }
        return recursiveInsertion(nums,index+1);
    }
}

class Solution2
{
    public int[] insertionSort(int[] nums) 
    {
        return Sort(nums,1);
    }
    public int[] Sort(int nums[],int index)
    {
        if(index>=nums.length)
        {
            return nums;
        }
        int j=index;
        RecursiveSort(nums,j);
        return Sort(nums,j+1);
    }
    public void RecursiveSort(int nums[],int j)
    {
        if(j>0 && nums[j-1]>nums[j])
        { 
            int temp=nums[j];
            nums[j]=nums[j-1];
            nums[j-1]=temp;
            RecursiveSort(nums,j-1);
        }
    }
}
