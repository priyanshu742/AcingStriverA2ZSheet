import java.util.HashMap;
import java.util.Map;

class Solution 
{
    public int[] twoSum(int[] nums, int target) 
    {
        int result[]=new int[2];

        Map<Integer,Integer> dict=new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            int complement=target-nums[i];

            if(dict.containsKey(complement))
            {
                result[0]=dict.get(complement);
                result[1]=i;
                return result;
            }
            dict.put(nums[i],i);
        }
        return result;
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[]={4,1,9,3,7,2};

        int result[] = s1.twoSum(nums,10);
        for(int n:result)
        System.out.println(n);

    }
}