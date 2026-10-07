package sorting.algorithms;


/* 

Given an array of integers nums, sort the array in non-decreasing order using the recursive Bubble Sort algorithm, and return the sorted array.
You must implement Bubble Sort using recursion only.
Do not use built-in sorting functions (sort, sorted, Arrays.sort, etc.).
A sorted array in non-decreasing order is an array where each element is greater than or equal to the previous one.

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
    public int[] bubbleSort(int[] nums) 
    {
        return recursiveBubble(nums,nums.length-1);
    } 
    public int [] recursiveBubble(int nums[],int n)
    {
        if(n<1)
        {
            return nums;
        }
        for(int i=0;i<=n-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                int temp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;
            }
        }
        return recursiveBubble(nums,n-1);
    }
}

class Solution2 
{
    public int[] bubbleSort(int[] nums) 
    {
        return recursiveBubble(nums,nums.length-1);
    } 
    public int [] recursiveBubble(int nums[],int n)
    {
        if(n<1)
        {
            return nums;
        }
        int didSwap=0;
        for(int i=0;i<=n-1;i++)
        {
            if(nums[i]>nums[i+1])
            {
                int temp=nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;
                didSwap=1;
            }
        }
        if(didSwap==0)
        {
            return nums;
        }
        return recursiveBubble(nums,n-1);
    }
}






