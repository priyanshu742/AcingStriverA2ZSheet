class Solution 
{
    public int[] mergeSort(int[] nums) 
    {
        int size=nums.length;
        int low=0;
        int high=size-1;

        return Sort(nums,low,high);
    }

    public int[] Sort(int[] nums,int low, int high)
    { 
        if(low>=high)
        {
            return nums;
        }
        int mid=(low+high)/2;

        Sort(nums,low,mid);

        Sort(nums,mid+1,high);

        return Merge(nums,low,mid,high);
    }

    public int[] Merge(int nums[],int low,int mid,int high)
    {

        int temp[]=new int[nums.length];
        int left=low;
        int right=mid+1;
        int index=0;

        while(left<=mid && right<=high)
        {
            if(nums[left]<=nums[right])
            {
                temp[index]=nums[left];
                index++;
                left++;
            }
            else
            {
                temp[index]=nums[right];
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

        while(high>=right)
        {
            temp[index]=nums[right];
            index++;
            right++;
        }

        for(int i=low; i<=high;i++)
        {
            nums[i]=temp[i-low];
        }
        return nums;
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={1,2,3,7,8,9,5,4,3};

        int pseudo[]=s1.mergeSort(nums);

        for(int n : pseudo)
        {
            System.out.println(n);
        }
    }
}