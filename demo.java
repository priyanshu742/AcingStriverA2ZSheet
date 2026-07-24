


class Solution 
{
    public int[] insertionSort(int[] nums) 
    {
        int size=nums.length;
        for(int i=0;i<=size-1;i++)
        {
            int j=i;
            while(j>0 && nums[j-1]>nums[j])
            {
                int temp=nums[j-1];
                nums[j-1]=nums[j];
                nums[j]=temp;
                j--;
            }
        }
        return nums;
    }
}




public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={7,4,1,5,3,9,2};

        int pseudo[]=s1.insertionSort(nums);

        for(int n : pseudo)
        {
             System.out.println(n);

        }
    }
}