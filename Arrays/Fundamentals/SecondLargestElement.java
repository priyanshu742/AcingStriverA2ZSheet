package Arrays.Fundamentals;

/*

Given an array of integers nums, return the second-largest element in the array. 
If the second-largest element does not exist, return -1.

Example 1
Input: nums = [8, 8, 7, 6, 5]
Output: 7
Explanation:
The largest value in nums is 8, the second largest is 7

Example 2
Input: nums = [10, 10, 10, 10, 10]
Output: -1
Explanation:
The only value in nums is 10, so there is no second largest value, thus -1 is returned


Constraints
1 <= nums.length <= 105
-104 <= nums[i] <= 104
nums may contain duplicate elements.

EASY
*/

class Solution1
{
    public int secondLargestElement(int[] nums) 
    {
        // optimal
        int largest=nums[0];
        int secondLargest=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>largest)
            {
                secondLargest=largest;
                largest=nums[i];
            }
            else if(nums[i]>secondLargest && nums[i]!=largest)
            {
                secondLargest=nums[i];
            }
        }
        if(secondLargest==Integer.MIN_VALUE)
        {
            return -1;
        }
        return secondLargest;
    }
}

class Solution2
{
    public int secondLargestElement(int[] nums) 
    {
        // brute
        divide(nums,0,nums.length-1);
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]!=nums[nums.length-1])
            {
                return nums[i];
            }
        }
        return -1;
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

class Solution3
{
    public int secondLargestElement(int[] nums) 
    {
        // better
        int largest=nums[0];
        int secondLargest=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>largest)
            {
                largest=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>secondLargest && nums[i]!=largest)
            {
                secondLargest=nums[i];
            }
        }
        if(secondLargest==Integer.MIN_VALUE)
        {
            return -1;
        }
        return secondLargest;
    }
}