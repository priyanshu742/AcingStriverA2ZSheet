package BinarySearch.BSOn1DArrays;

/*

Given a sorted array nums and an integer x. Find the floor and ceil of x in nums.
The floor of x is the largest element in the array which is smaller than or equal to x.
The ceiling of x is the smallest element in the array greater than or equal to x.
If no floor or ceil exists, output -1.

Example 1
Input : nums =[3, 4, 4, 7, 8, 10], x= 5
Output: 4 7
Explanation: The floor of 5 in the array is 4, and the ceiling of 5 in the array is 7.

Example 2
Input : nums =[3, 4, 4, 7, 8, 10], x= 8
Output: 8 8
Explanation: The floor of 8 in the array is 8, and the ceiling of 8 in the array is also 8.


Constraints
1 <= nums.length <= 105 
0 < nums[i], x < 105 
nums is sorted in ascending order.

EASY
*/

class Solution 
{
    public int[] getFloorAndCeil(int[] nums, int x) 
    {
        int low=0;
        int high=nums.length-1;
        int floor=-1;
        int ceil=-1;

        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==x)
            {
                return new int[]{x,x};
            }
            else if(nums[mid]>x)
            {
                ceil=nums[mid];
                high=mid-1;
            }
            else
            {
                floor=nums[mid];
                low=mid+1;
            }
        }
        return new int[]{floor,ceil};
    }
}