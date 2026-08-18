package ArrayProblems.Hard;


/* 

Given an integer array nums. Return the number of inversions in the array.

Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
It indicates how close an array is to being sorted.
A sorted array has an inversion count of 0.
An array sorted in descending order has maximum inversion.

Example 1
Input: nums = [2, 3, 7, 1, 3, 5]
Output: 5
Explanation:
The responsible indexes are:
nums[0], nums[3], values: 2 > 1 & indexes: 0 < 3
nums[1], nums[3], values: 3 > 1 & indexes: 1 < 3
nums[2], nums[3], values: 7 > 1 & indexes: 2 < 3
nums[2], nums[4], values: 7 > 3 & indexes: 2 < 4
nums[2], nums[5], values: 7 > 5 & indexes: 2 < 5

Example 2
Input: nums = [-10, -5, 6, 11, 15, 17]
Output: 0
Explanation:
nums is sorted, hence no inversions present.


Constraints
1 <= nums.length <= 105
-105 <= nums[i] <= 105

MEDIUM
*/

class Solution 
{
    // optimal
    public long numberOfInversions(int[] nums) 
    {
        return mergeSort(nums,0,nums.length-1);
    }

    public int mergeSort(int nums[],int low,int high)
    {
        int count=0;
        if(low>=high)
        {
            return count;
        }
        int mid=(low+high)/2;
        count+=mergeSort(nums,low,mid);
        count+=mergeSort(nums,mid+1,high);
        count+=merge(nums,low,mid,high);
        return count;
    }

    public int merge(int nums[],int low,int mid,int high)
    {
        int count=0;
        int index=0;
        int temp[]=new int[high-low+1];
        int left=low;
        int right=mid+1;
        while(left<=mid && right <=high)
        {
            if (nums[left]<=nums[right])
            {
                temp[index]=nums[left];
                index++;
                left++;
            }
            //right is smaller
            else
            {
                temp[index]=nums[right];
                count+=(mid-left+1);
                index++;
                right++;
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
        return count;
    }
}