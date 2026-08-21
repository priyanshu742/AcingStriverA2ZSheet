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
    public int maxProduct(int[] nums) 
    {
        int maximum=Integer.MIN_VALUE;
        int product=1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i;j<nums.length;j++)
            {
                product=product*nums[j];
                maximum=Math.max(product,maximum);
            }
        }
        return maximum;
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[] ={ 6, 5, 7, 1, 8, 6, 4, 3, 2};

        int result[]=s1.findMissingRepeatingNumbers(nums);

        for(int n: result)
        System.out.println(n);
    }
}hh