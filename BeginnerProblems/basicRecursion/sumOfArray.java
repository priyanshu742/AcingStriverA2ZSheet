package BeginnerProblems.basicRecursion;


class Solution1 
{
    public int arraySum(int[] nums) 
    {
        int size=nums.length-1;
        return sum(nums,size,0);
    }
    public int sum(int nums[],int size,int i)
    {
        if(i>size)
        {
            return 0;
        }
        return nums[i]+sum(nums,size,i+1);
    }
}

class Solution2 
{
    public int arraySum(int[] nums) 
    {
        return sum(nums,nums.length-1);
    }
    public int sum(int []nums,int index)
    {
        if(index<0)
        {
            return 0;
        }
        return nums[index]+sum(nums,index-1);
    }
}