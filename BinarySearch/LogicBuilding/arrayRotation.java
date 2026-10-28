package BinarySearch.LogicBuilding;

import java.util.ArrayList;

/*
 
Given an integer array nums of size n, sorted in ascending order with distinct values. 
The array has been right rotated an unknown number of times, between 0 and n-1 (including). 
Determine the number of rotations performed on the array.

Example 1
Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
Output: 4
Explanation: The original array should be [0, 1, 2, 3, 4, 5, 6, 7]. So, we can notice that the array has been rotated 4 times.

Example 2
Input: nums = [3, 4, 5, 1, 2]
Output: 3
Explanation: The original array should be [1, 2, 3, 4, 5]. So, we can notice that the array has been rotated 3 times.


Constraints
n == nums.length
1 <= n <= 104
-104 <= nums[i] <= 104
All the integers of nums are unique.

EASY
*/

class Solution1
{
    public int findKRotation(ArrayList<Integer> nums) 
    {
        // binarySearach
        int low=0;
        int high=nums.size()-1;
        int minimum=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            // left half is sorted
            if(nums.get(low)<=nums.get(mid))
            {
                if(nums.get(low)<minimum)
                {
                    minimum=nums.get(low);
                    index=low;
                }
                low=mid+1;
            }
            // right half is sorted
            else
            {
                if(nums.get(mid)<minimum)
                {
                    minimum=nums.get(mid);
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
}

class Solution2
{
    public int findKRotation(ArrayList<Integer> nums) 
    {
        // binarySearach
        int low=0;
        int high=nums.size()-1;
        int minimum=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            /*
            if after repeatedly dividing the array into half,
            the entire search space is already sorted,
            then always nums.get(low) will be smaller in that search Space 
            */
            if(nums.get(low)<nums.get(high))
            {
                if(nums.get(low)<minimum)
                {
                    minimum=nums.get(low);
                    index=low;
                    break;
                }
            }
            // left half is sorted
            if(nums.get(low)<=nums.get(mid))
            {
                if(nums.get(low)<minimum)
                {
                    minimum=nums.get(low);
                    index=low;
                }
                low=mid+1;
            }
            // right half is sorted
            else
            {
                if(nums.get(mid)<minimum)
                {
                    minimum=nums.get(mid);
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
}

class Solution 
{
    public int findKRotation(ArrayList<Integer> nums) 
    {
        // if the array contains duplicates
        // binarySearch
        int low=0;
        int high=nums.size()-1;
        int minimum=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            /*
            if after repeatedly dividing the array into half,
            the entire search space is already sorted,
            then always nums.get(low) will be smaller in that search Space 
            */
            if(nums.get(low)<nums.get(high))
            {
                if(nums.get(low)<minimum)
                {
                    minimum=nums.get(low);
                    index=low;
                    break;
                }
            }
            if(nums.get(low)==nums.get(mid) && nums.get(mid)==nums.get(high))
            {
                if(nums.get(low)<minimum)
                {
                    minimum=nums.get(low);
                    index=low;
                }
                low++;
                high--;
                continue;
            }
            if(nums.get(low)<nums.get(high))
            {
                if(nums.get(low)<minimum)
                {
                    minimum=nums.get(low);
                    index=low;
                    break;
                }
            }
            // left half is sorted
            if(nums.get(low)<=nums.get(mid))
            {
                if(nums.get(low)<minimum)
                {
                    minimum=nums.get(low);
                    index=low;
                }
                low=mid+1;
            }
            // right half is sorted
            else
            {
                if(nums.get(mid)<minimum)
                {
                    minimum=nums.get(mid);
                    index=mid;
                }
                high=mid-1;
            }
        }
        return index;
    }
}