package BinarySearch.LogicBuilding;

/*

Given an array nums sorted in non-decreasing order. 
Every number in the array except one appears twice.
Find the single number in the array.

Example 1
Input :nums = [1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]
Output:4
Explanation: Only the number 4 appears once in the array.

Example 2
Input : nums = [1, 1, 3, 5, 5]
Output:3
Explanation: Only the number 3 appears once in the array.


Constraints
n == nums.length
1 <= n <= 104
-104 <= nums[i] <= 104

MEDIUM
*/

class Solution1 
{
    public int singleNonDuplicate(int[] nums) 
    {
        // linearSearch
        int n=nums.length;
        // edge cases
        if(n==1)
        {
            return nums[0];
        }
        if(nums[0]!=nums[1])
        {
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2])
        {
            return nums[n-1];
        }
        for(int i=1;i<n-1;i++)
        {
           if(nums[i]!=nums[i+1] && nums[i]!=nums[i-1])
            {
                return nums[i];
            }
        }
        return -1;
    }
}

class Solution2
{
    public int singleNonDuplicate(int[] nums) 
    {
        // binarySearch
        int n=nums.length;
        // edge cases
        if(n==1)
        {
            return nums[0];
        }
        if(nums[0]!=nums[1])
        {
            return nums[0];
        }
        if(nums[n-1]!=nums[n-2])
        {
            return nums[n-1];
        }
        int low=1;
        int high=n-2;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1])
            {
                return nums[mid];
            }
            // on the left half of the single element
            // (even,odd)
            if((mid%2==1 && nums[mid-1]==nums[mid]) || (mid%2==0 && nums[mid]==nums[mid+1]) )
            {
                low=mid+1;
            }
            // on the right half of the single element
            // (odd,even)
            // can directly write "else" also here
            else if((mid%2==1 && nums[mid]==nums[mid+1]) || mid %2==0 && nums[mid-1]==nums[mid])
            {
                high=mid-1;
            }
        }
        return -1;
    }
}