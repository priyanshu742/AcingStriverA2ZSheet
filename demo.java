class Solution 
{
    public void moveZeroes(int[] nums) 
    {
        // OPTIMAL SOLUTION
        int j=-1;
        for(int z=0;z<nums.length;z++)
        {
            if(nums[z]==0)
            {
                j=z;
                break;
            }
        }

        if(j==-1)
        {
            return ;
        }
        int i=0;

        for(i=j+1;i<nums.length;i++)
        {
            if(nums[i]!=0)
            {
                int temp=nums[j];
                nums[j]=nums[i];
                nums[i]=temp;
                j++;
            }
        }
    }
}


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={3,0,1,0,4,0,9,6};

        s1.moveZeroes(nums);

        for(int n:nums)
        System.out.println(n);
    }
}