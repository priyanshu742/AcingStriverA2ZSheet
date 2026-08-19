package ArrayProblems.Hard;

/* 

Given an integer array nums. Return the number of reverse pairs in the array.
An index pair (i, j) is called a reverse pair if:
0 <= i < j < nums.length
nums[i] > 2 * nums[j]

Example 1
Input: nums = [6, 4, 1, 2, 7]
Output: 3
Explanation:
The reverse pairs are:
(0, 2) : nums[0] = 6, nums[2] = 1, 6 > 2 * 1
(0, 3) : nums[0] = 6, nums[3] = 2, 6 > 2 * 2
(1, 2) : nums[1] = 4, nums[2] = 1, 4 > 2 * 1

Example 2
Input: nums = [5, 4, 4, 3, 3]
Output: 0
Explanation:
No pairs satisfy both the conditons.


Constraints
1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1

MEDIUM;
*/

class Solution 
{
    public int reversePairs(int[] nums) 
    {
        return mergeSort(nums,0,nums.length-1); 
    }

    public int mergeSort(int[] nums,int low,int high) 
    {
        int count=0;
        if(low>=high)
        {
            return count;
        }
        int mid=(low+high)/2;
        count+=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=countPairs(nums,low,mid,high);
        merge(nums,low,mid,high);
        return count;
    }

    public int countPairs(int[] nums,int low,int mid,int high)
    {
        int count=0;
        int right=mid+1;
        for(int i=low;i<=mid;i++)
        {
            while(right<=high && (long)nums[i]>2*
            (long)nums[right])
            {
                right++;
            }
            count=count+(right-(mid+1));
        }
        return count;
    } 

    public void merge(int[] nums,int low,int mid,int high) 
    {
        int index=0;
        int left=low;
        int right=mid+1;
        int temp[]=new int[high-low+1];

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
    }
}