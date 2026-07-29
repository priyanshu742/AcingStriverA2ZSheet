



class Solution 
{
    public void rotateArray(int[] nums, int k)
    {
        int size=nums.length;
        k=k%size;
        for(int j=1;j<=k;j++)
        {
            int first=nums[0];
            for(int i=0;i<size-1;i++)
            {
                nums[i]=nums[i+1];
            }
            nums[size-1]=first;
        }
    }
}


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={2,3,4,5,1,2};

        s1.rotateArray(nums,9);

        for(int n:nums)
        System.out.println(n);
    }
}