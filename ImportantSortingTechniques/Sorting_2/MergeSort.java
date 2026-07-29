package ImportantSortingTechniques.Sorting_2;


/*

Given an array of integers, nums,sort the array in non-decreasing order using the merge sort algorithm. Return the sorted array.
A sorted array in non-decreasing order is one in which each element is either greater than or equal to all the elements to its left in the array.

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
1 <= nums.length <= 106
-104 <= nums[i] <= 104
nums[i] may contain duplicate values.

HARD
*/

class Solution 
{
    public int[] mergeSort(int[] nums) 
    {
        int low=0;
        int high=nums.length-1;

        return divide(nums,low,high);
    }

    public int[] divide(int nums[],int low,int high)
    {
        if(low>=high)
        {
            return nums;
        }
        int mid=(low+high)/2;

        divide(nums,low,mid);

        divide(nums,mid+1,high);

        return merge(nums,low,mid,high);
    }

    public int[] merge(int nums[],int low,int mid,int high)
    {
        int temp[]=new int[high-low+1];
        int index=0;

        int left=low;
        int right=mid+1;

        while(left<=mid && right<=high)
        {
            if(nums[left]<=nums[right])
            {
                temp[index]=nums[left];
                index++;
                left++;
            }
            else
            {
                temp[index]=nums[right];
                index++;
                right++;
            }
        }
        while(left<=mid)
        {
            temp[index]=nums[left];
            index++;
            left++;
        }
        while(right<=high)
        {
            temp[index]=nums[right];
            index++;
            right++;
        }

        for(int i=low;i<=high;i++)
        {
            nums[i]=temp[i-low];
        }
        return nums;
        
    }
}