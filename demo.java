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
    public List<List<Integer>> mergeOverlap(List<List<Integer>> intervals) 
    {
        intervals.sort((a,b) -> 
        {
            if(a.get(0)==b.get(0))
            {
                return Integer.compare(a.get(1),b.get(1));
            }
            return Integer.compare(a.get(0),b.get(0));
        });

        List<List<Integer>> result =new ArrayList<>();

        for(int i=0;i<intervals.size();i++)
        {
            int start=intervals.get(i).get(0);
            int end=intervals.get(i).get(1);
            if(!result.isEmpty() && end<=result.get(result.size()-1).get(1))
            {
                continue;
            }
            for(int j=i+1;j<intervals.size();j++)
            {
                if(intervals.get(j).get(0)<=end)
                {
                    end=Math.max(intervals.get(j).get(1),end);
                }
                else
                {
                    break;
                }
            }
            result.add(Arrays.asList(start,end));
        }
        return result;
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