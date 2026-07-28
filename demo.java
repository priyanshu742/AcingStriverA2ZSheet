class Solution 
{
    public void rotateArrayByOne(int[] nums)
    {
        int last=nums[nums.length-1];
        for(int i=nums.length-1;i>0;i--)
        {
            nums[i]=nums[i-1];
        }
        nums[0]=last;
    }
}


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={2,3,4,5,6,9};

        s1.rotateArrayByOne(nums);

        for(int n:nums)
        System.out.println(n);
    }
}