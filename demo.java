
class Solution 
{
    public int[] selectionSort(int[] nums) 
    {
        int size=nums.length;
        for(int i=0;i<=size-2;i++)
        {
            int min=i;
            for(int j=i+1; j<=size-1;j++)
            {
                if(nums[j]<nums[min])
                {
                    int temp=nums[min];
                    nums[min]=nums[j];
                    nums[j]=temp;
                }
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
        int nums[]={99,33,5,11,4,3,2,9,3};

        int pseudo[]=s1.selectionSort(nums);

        for(int n: pseudo)
        {
            System.out.print(n+" ");
        }
    }
}