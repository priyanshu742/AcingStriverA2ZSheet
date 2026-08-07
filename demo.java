import java.util.HashSet;
import java.util.Set;

class Solution 
{
    public int longestConsecutive(int[] nums)
    {
        int longest=1;
        Set<Integer> result=new HashSet<>();
        for(int n:nums)
        {
            result.add(n);
        }
        for(int n: result)
        {
            if(!result.contains(n-1))
            {
                int count=1;
                int x=n;
                while(result.contains(x+1))
                {
                    x=x+1;
                    count=count+1;
                }
                longest=Math.max(longest,count);
            }
        }
        return longest;
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        int result=s1.longestConsecutive(nums);

        System.out.println(result);

       // for(int n: result)
       // {
            //System.out.println(n);
       // }
    }
}