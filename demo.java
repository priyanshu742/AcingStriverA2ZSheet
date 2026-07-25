class Solution 
{
    public int[] bubbleSort(int[] nums) 
    {
        int size=nums.length;

        return RecursiveSort(nums,size);
    }

    public int[] RecursiveSort(int arr[],int size)
    {
        int j=size;
        if(size<=1)
        {
            return arr;
        }
        else
        {
            for(int i=0;i<j-1;i++)
            {
                if (arr[i+1]<arr[i])
                {
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                }
            }
            return RecursiveSort(arr,size-1);
        }
    }
}


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={5,4,4,1,1};

        int pseudo[]=s1.bubbleSort(nums);

        for(int n : pseudo)
        {
             System.out.println(n);

        }
    }
}