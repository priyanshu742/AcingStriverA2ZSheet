package BinarySearch.BSOn1DArrays;

/* 

Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
If the target is not found in the array, return [-1, -1].

Example 1
Input: nums = [5, 7, 7, 8, 8, 10], target = 8
Output: [3, 4]
Explanation:The target is 8, and it appears in the array at indices 3 and 4, so the output is [3,4]

Example 2
Input: nums = [5, 7, 7, 8, 8, 10], target = 6
Output: [-1, -1]
Expalantion: The target is 6, which is not present in the array. Therefore, the output is [-1, -1].


Constraints
0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109

EASY
*/

class Solution 
{
    public int[] searchRange(int[] nums, int target) 
    {
        int size=nums.length;
        int first=firstOccurence(nums,size,target);
        if(first==-1)
        {
            return new int[]{-1,-1};
        }
        return new int[]{first,lastOccurence(nums,size,target)};
    }

    int firstOccurence(int nums[],int size,int target)
    {
        int low=0;
        int high=size-1;
        int first=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;    
            }
        }
        return first;
    }

    int lastOccurence(int nums[],int size,int target)
    {
        int low=0;
        int high=size-1;
        int last=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]<target)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return last;
    }
}