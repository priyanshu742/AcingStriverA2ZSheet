







class Solution 
{
    void reverse(int[] arr, int n) 
    {
        swap(arr,0,n-1);
        public void swap(int[]arr,int left,int right)
       {
            if(left>=right)
            {
                return;
            }
            else
            {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
                swap(arr,left+1,right-1)
            }
       }
    }
}








public class Sol
{
    public static void main(String args[]) 
    {
        
    }
}