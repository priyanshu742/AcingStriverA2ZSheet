package ImportantSortingTechniques.Sorting_2;


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

class Solution 
{
    public int[] bubbleSort(int[] nums) 
    {
        int size=nums.length;

        return RecursiveSort(nums,size);
    }

    public int[] RecursiveSort(int arr[],int size)
    {
        int j=size;
        if(size<=1)
        {
            return arr;
        }
        else
        {
            for(int i=0;i<j-1;i++)
            {
                if (arr[i+1]<arr[i])
                {
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
            return RecursiveSort(arr,size-1);
        }
    }
}










