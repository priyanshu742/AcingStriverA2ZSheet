




class Solution 
{
    public int[] quickSort(int[] nums) 
    {
        int low=0;
        int high=nums.length-1;

        return qs(nums,low,high);
    }

    public int[] qs(int nums[],int low,int high)
    {
        if(low<high)
        {
            int partitionIndex=partition(nums,low,high);
            qs(nums,low,partitionIndex-1);
            qs(nums,partitionIndex+1,high);
            return nums;
        }
        return nums;
    }

    public int partition(int nums[],int low,int high)
    {
        int pivot=nums[low];
        int i=low;
        int j=high;
        while(i<j)
        {
            while(nums[i]<=pivot && i<=high-1)
            {
                i++;
            }
             while(nums[j]>pivot && j>=low+1)
            {
                j--;
            }
            if(i<j)
            {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
            }
        }
        int temp=nums[low];
        nums[low]=nums[j];
        nums[j]=temp;
        return j;

    }
}


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={2,3,4,5,6,9,1,8};

        int pseudo[]=s1.quickSort(nums);

        for(int n:pseudo)
        System.out.println(n);
    }
}