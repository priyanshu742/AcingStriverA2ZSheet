import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution 
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        // Brute
        Set<List<Integer>> result=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                for(int k=j+1;k<nums.length;k++)
                {
                    for(int l=k+1;l<nums.length;l++)
                    {
                        if(nums[i]+nums[j]+nums[k]+nums[l]==target)
                        {
                            List<Integer> ans=Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                            Collections.sort(ans);
                            result.add(ans);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[] = {1,0,-1,0,-2,2};

        List<List<Integer>> result=s1.fourSum(nums,0);

        System.out.println(result);

       
    }
}