package ImportantSortingTechniques.Sorting_2;

public class QuickSorting 
{
    class Solution 
{
    public int[] quickSort(int[] nums) 
    {
        int size=nums.length-1;
        int low=0;
        int high=size;

        return qs(nums,low,high);
    }

    public int[] qs(int nums[],int low,int high)
    {
        if(low<high)
        {
            partitionIndex=partition(nums,low,high);
            qs(nums,low,partition-1);
            qs(nums,partition+1,high);
            return nums;
        }
        else
        {
            return nums;
        }
    }

    public int partition(int nums[],int low,int high)
    {
        pivot=nums[0];
        i=low;
        j=high;
        while(i<j)
        {
            while(nums[i]>=pivot && i<high-1)
            {
                i++;
            }
             while(nums[j]<pivot && low-1>j)
            {
                j++;
            }
            if(i<j)
            {
                int temp=arr[i];
                arr[j]=arr[i];
                arr[j]=temp;
            }
            return j;
        }

    }
}
    
}
