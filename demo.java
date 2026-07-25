class Solution 
{
    public int[] insertionSort(int[] nums) 
    {
        return Sort(nums,1);
    }

    public int[] Sort(int arr[],int size)
    {
        int maxsize=arr.length-1;
        int j=size;

        if(size>maxsize)
        {
            return arr;
        }

        RecursiveSort(arr,j);
        
        return Sort(arr,size+1);
    }

    public void RecursiveSort(int arr[],int j)
    {
        if(j>0 && arr[j]<arr[j-1])
        { 
            int temp=arr[j];
            arr[j]=arr[j-1];
            arr[j-1]=temp;
            RecursiveSort(arr,j-1);
        }
    }
}


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={0,8,5,1,2,4,9};

        int pseudo[]=s1.insertionSort(nums);

        for(int n : pseudo)
        {
             System.out.println(n);

        }
    }
}