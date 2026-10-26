package BinarySearch.LogicBuilding;

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

class Solution1
{
    public int[] searchRange(int[] nums, int target) 
    {
        // linear Search
        int first=-1;
        int last=-1;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==target)
            {
                if(first==-1)
                {
                    first=i;
                }
                last=i;
            }
        }
        return new int[]{first,last};
    }
}

class Solution2 
{
    public int[] searchRange(int[] nums, int target) 
    {
        // using lowerBound and upperBound to find first and last occurence
        int first=lowerBound(nums,target);
        if(first==nums.length || nums[first]!=target)
        {
            return new int[]{-1,-1};
        }
        return new int[]{first,upperBound(nums,target)-1};
    }
    public int lowerBound(int[] nums,int target) 
    {
        int low=0;
        int high=nums.length-1;
        int ans=nums.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>=target)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public int upperBound(int[] nums,int target) 
    {
        int low=0;
        int high=nums.length-1;
        int ans=nums.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]>target)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
}

class Solution3
{
    public int[] searchRange(int[] nums, int target) 
    {
        int first=firstOccurence(nums,target);
        if(first==-1)
        {
            return new int[]{-1,-1};
        }
        return new int[]{first,lastOccurence(nums,target)};
    }
    public int firstOccurence(int[] nums,int target) 
    {
        int low=0;
        int high=nums.length-1;
        int first=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return first;
    }
    public int lastOccurence(int[] nums,int target) 
    {
        int low=0;
        int high=nums.length-1;
        int last=-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return last;
    }
}