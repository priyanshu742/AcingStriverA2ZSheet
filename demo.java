class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
        if(nums.length==0)
        {
            return 0;
        }
        int uniquecount=1; // first element is always unique

        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                nums[uniquecount]=nums[i];
                uniquecount++;
            }
        }
        for(int n :nums)
        {
            System.out.println(n);
        }
        return uniquecount;  
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={-30, -30, 0, 0, 10, 20, 30, 30};

        int pseudo=s1.removeDuplicates(nums);

        System.out.println(pseudo);
    }
}