import java.util.HashMap;
import java.util.Map;

class Solution 
{
    public int singleNumber(int[] nums) 
    {
        Map<Integer,Integer> dict=new HashMap<>();
        for(int n : nums)
        {
            dict.put(n,dict.getOrDefault(n,0)+1);
        }

        for(int n : dict.keySet())
        {
            if(dict.get(n)==1)
            {
                return n;
            }
        }
        return 0;
    }
}


public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={1,2,4,3,4,6,2,1,3,9,8,9,8};

        int result = s1.singleNumber(nums);
        System.out.println(result);
    }
}