import java.util.ArrayList;
import java.util.List;

class Solution 
{
    public List<Integer> leaders(int[] nums) 
    {
        int size=nums.length;
        List<Integer> ans= new ArrayList<>();

        int maxi=Integer.MIN_VALUE;

        for(int i=size-1;i>=0;i--)
        {
            if(nums[i]>maxi)
            {
                ans.add(nums[i]);
            }
            maxi=Math.max(maxi,nums[i]);
        }
        int start=0;
        int end=ans.size()-1;
        while(start<end)
        {
            int temp=ans.get(start);
            ans.set(start,ans.get(end));
            ans.set(end,temp);
        }
        return ans;
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={-3, 4, 5, 1, -4, -5};

        List<Integer> result=s1.leaders(nums);

        for(int n: result)
        {
            System.out.println(n);
        }
    }
}