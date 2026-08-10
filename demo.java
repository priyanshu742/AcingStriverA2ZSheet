import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution 
{
    public List<Integer> majorityElementTwo(int[] nums) 
    {
        int reqFrequency=nums.length/3;
        Map<Integer,Integer> dict= new HashMap<>();
        List<Integer> arr=new ArrayList<>();

        for(int n: nums)
        {
            dict.put(n,dict.getOrDefault(n,0)+1);
        }

        for(int key: dict.keySet())
        {
            if(dict.get(key)>reqFrequency)
            {
                arr.add(key);
            }
        }
        return arr;
        
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[] = {1, 2, 1, 1, 3, 2};

        List<Integer> result=s1.majorityElementTwo(nums);

        System.out.println(result);

       
    }
}