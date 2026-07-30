
class Solution 
{
    public int[] mergeSort(int[] nums) 
    {
        int low=0;
        int high=nums.length-1;

        divide(nums,low,high);

        return nums;
    }

    public void divide(int nums[],int low,int high)
    {
        if(low>=high)
        {
            return;
        }
        int mid=(low+high)/2;

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


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={3,1,4,9,6};

        int pseudo[]=s1.mergeSort(nums);

        for(int n:pseudo)
        System.out.println(n);
    }
}