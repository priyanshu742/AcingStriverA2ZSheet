package ImportantSortingTechniques.Sorting_2;


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


class Solution 
{
    public int[] insertionSort(int[] nums) 
    {
        return Sort(nums,1);
    }

    public int[] Sort(int arr[],int size)
    {
        int maxsize=arr.length-1;
        int j=size;

        if(size>maxsize)
        {
            return arr;
        }

        RecursiveSort(arr,j);
        
        return Sort(arr,size+1);
    }

    public void RecursiveSort(int arr[],int j)
    {
        if(j>0 && arr[j]<arr[j-1])
        { 
            int temp=arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            RecursiveSort(arr,j-1);
        }
    }
}