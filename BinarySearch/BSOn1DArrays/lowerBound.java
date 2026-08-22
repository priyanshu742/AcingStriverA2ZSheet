package BinarySearch.BSOn1DArrays;

/* 

Given a sorted array of nums and an integer x, write a program to find the lower bound of x.
The lower bound algorithm finds the first and smallest index in a sorted array where the value at that index is greater than or equal to a given key i.e. x.
If no such index is found, return the size of the array.

Example 1
Input : nums= [1,2,2,3], x = 2
Output:1
Explanation:
Index 1 is the smallest index such that arr[1] >= x.

Example 2
Input : nums= [3,5,8,15,19], x = 9
Output: 3
Explanation:
Index 3 is the smallest index such that arr[3] >= x


Constraints
1 <= nums.length <= 105
-105 < nums[i], x < 105
nums is sorted in ascending order.

EASY
*/

class Solution 
{
    public int lowerBound(int[] nums, int x) 
    {
        int low=0;
        int high=nums.length-1;
        int ans=nums.length-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            //may be an answer
            if(nums[mid]>=x)
            {
                ans=mid;
                // look for more small index on left
                high=mid-1;
            }
            else
            {
                low=mid+1; // look for right
            }
        }
        return ans;
    }
}
