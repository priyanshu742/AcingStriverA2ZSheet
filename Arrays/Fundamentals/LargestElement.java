package Arrays.Fundamentals;


/*
 
Given an array of integers nums, return the value of the largest element in the array

Example 1
Input: nums = [3, 3, 6, 1]
Output: 6
Explanation: The largest element in array is 6

Example 2
Input: nums = [3, 3, 0, 99, -40]
Output: 99
Explanation: The largest element in array is 99


Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104
nums may contain duplicate elements.

EASY
*/

class Solution1
{
    public int largestElement(int[] nums) 
    {
        // optimal
        int largest=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>largest)
            {
                largest=nums[i];
            }
        }
        return largest;
    }
}
    
class Solution2
{
    public int largestElement(int[] nums) 
    {
        // brute
        divide(nums,0,nums.length-1);
        return nums[nums.length-1];
    }
    public void divide(int nums[],int low,int high)
    {
        if(low>=high)
        {
            return ;
        }
        int mid=low+(high-low)/2;
        divide(nums,low,mid);
        divide(nums,mid+1,high);
        merge(nums,low,mid,high);
    }
    public void merge(int nums[],int low,int mid,int high)
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
                left++;
                index++;
            }
            else
            {
                temp[index]=nums[right];
                right++;
                index++;
            }
        }
        while(left<=mid)
        {
            temp[index]=nums[left];
            left++;
            index++;
        }
        while(right<=high)
        {
            temp[index]=nums[right];
            right++;
            index++;
        }
        for(int i=low;i<=high;i++)
        {
            nums[i]=temp[i-low];
        }
    }
}