

class Solution 
{
    public int maxSubArray(int[] nums) 
    {
        //KADANE'S ALGORITHM (OPTIMAL)

        int maxi=Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum>maxi)
            {
                maxi=sum;
            }
            if(sum<0)
            {
                sum=0;
            }
        } 
        return maxi;       
    }
}


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={-7,1,2,-5,7,1,-20,1,0,0,0,4,4};

        int result = s1.maxSubArray(nums);
        System.out.println(result);
    }
}