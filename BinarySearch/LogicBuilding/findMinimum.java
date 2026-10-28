package BinarySearch.LogicBuilding;

import java.util.ArrayList;

/*

Given an integer array nums of size N, sorted in ascending order with distinct values,and then rotated an unknown number of times (between 1 and N),
find the minimum element in the array.

Example 1
Input : nums = [4, 5, 6, 7, 0, 1, 2, 3]
Output: 0
Explanation: Here, the element 0 is the minimum element in the array.

Example 2
Input : nums = [3, 4, 5, 1, 2]
Output: 1
Explanation:Here, the element 1 is the minimum element in the array.


Constraints
n == nums.length
1 <= n <= 104
-104 <= nums[i] <= 104
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.

EASY    
*/

class Solution1 
{
    public int findMin(ArrayList<Integer> arr) 
    {
        // linearSearch
        int minimum=Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++)
        {
            if(arr.get(i)<minimum)
            {
                minimum=arr.get(i);
            }
        }
        return minimum;
    }
}

class Solution2 
{
    public int findMin(ArrayList<Integer> arr) 
    {
        // binarySearch
        int low=0;
        int high=arr.size()-1;
        int minimum=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            // left half is sorted
            if(arr.get(low)<=arr.get(mid))
            {
                if(arr.get(low)<minimum)
                {
                    minimum=arr.get(low);
                }
                low=mid+1;
            }
            // right half is sorted
            else
            {
                if(arr.get(mid)<minimum)
                {
                    minimum=arr.get(mid);
                }
                high=mid-1;
            }
        }
        return minimum;
    }
}

class Solution3
{
    public int findMin(ArrayList<Integer> arr) 
    {
        // binarySearch (optimised)
        int low=0;
        int high=arr.size()-1;
        int minimum=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            /*
            if after repeatedly dividing the array into half,the entire search space 
            is already sorted, then always arr[low] will be the smaller in that SearchSpace 
            */
            if(arr.get(low)<=arr.get(high))
            {
                if(arr.get(low)<minimum)
                {
                    minimum=arr.get(low);
                }
                break;
            }
            // left half is sorted
            if(arr.get(low)<=arr.get(mid))
            {
                if(arr.get(low)<minimum)
                {
                    minimum=arr.get(low);
                }
                low=mid+1;
            }
            // right half is sorted
            else
            {
                if(arr.get(mid)<minimum)
                {
                    minimum=arr.get(mid);
                }
                high=mid-1;
            }
        }
        return minimum;
    }
}

class Solution 
{
    public int findMin(ArrayList<Integer> arr) 
    {
        // if the array contains duplicates
        // binarySearch
        int low=0;
        int high=arr.size()-1;
        int minimum=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            /*
            if after repeatedly dividing the array into half,the entire search space 
            is already sorted, then always arr[low] will be the smaller in that SearchSpace 
            */
            if(arr.get(low)<=arr.get(high))
            {
                if(arr.get(low)<minimum)
                {
                    minimum=arr.get(low);
                }
                break;
            }
            if(arr.get(low)==arr.get(mid) && arr.get(mid)==arr.get(high))
            {
                if(arr.get(low)<minimum)
                {
                    minimum=arr.get(low);
                }
                low++;
                high--;
                continue;
            }
            // left half is sorted
            if(arr.get(low)<=arr.get(mid))
            {
                if(arr.get(low)<minimum)
                {
                    minimum=arr.get(low);
                }
                low=mid+1;
            }
            // right half is sorted
            else
            {
                if(arr.get(mid)<minimum)
                {
                    minimum=arr.get(mid);
                }
                high=mid-1;
            }
        }
        return minimum;
    }
}
