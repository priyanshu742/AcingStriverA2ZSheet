
/* 

Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order.
The sorting must be done in-place, without making a copy of the original array.

Example 1
Input: nums = [1, 0, 2, 1, 0]
Output: [0, 0, 1, 1, 2]
Explanation:
The nums array in sorted order has 2 zeroes, 2 ones and 1 two

Example 2
Input: nums = [0, 0, 1, 1, 1]
Output: [0, 0, 1, 1, 1]
Explanation:
The nums array in sorted order has 2 zeroes, 3 ones and zero twos


Constraints
1 <= nums.length <= 105
nums consists of 0, 1 and 2 only.

EASY
*/

class Solution1 
{
    public void sortZeroOneTwo(int[] nums) 
    {
        // brute merge Sort
       divide(nums,0,nums.length-1);
    }
    public void divide(int nums[],int low,int high)
    {
        if(low>=high)
        {
            return;
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

class Solution2 
{
    public void sortZeroOneTwo(int[] nums) 
    {
        // better
        int count0=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                count0++;
            }
            else if(nums[i]==1)
            {
                count1++;
            }
            else
            {
                count2++;
            }
        }
        for(int i=0;i<count0;i++)
        {
            nums[i]=0;
        }
         for(int i=count0;i<count0+count1;i++)
        {
            nums[i]=1;
        }
        for(int i=count0+count1;i<nums.length;i++)
        {
            nums[i]=2;
        }
    }
}

class Solution3 
{
    public void sortZeroOneTwo(int[] nums) 
    {
        // optimal
        // Dutch National Flag algorithm;
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==2)
            {
                swap(nums,mid,high);
                high--;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
        }
    }
    public void swap(int[] nums,int left,int right)
    {
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    } 
}