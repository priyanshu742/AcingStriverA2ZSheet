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
    public int[] findMissingRepeatingNumbers(int[] nums) 
    {
        //Mathematics optimal approach

        //S-Sn
        //S2 -S2n
        int size=nums.length;

        int S=0;
        long Sn=(size*(size+1))/2;

        long S2=0;
        long S2n=(size*(size+1)*((2*size)+1))/6;
        for(int i=0;i<nums.length;i++)
        {
            S+=nums[i];
            S2+=(long)(nums[i]*nums[i]);
        }

        long val1=S-Sn; //x-y
        long val2=S2-S2n;
        val2=val2/val1; //x+y

        long x=(val1+val2)/2; // twice
        long y=x-val1; // missing

        return new int[]{(int)x,(int)y} ;
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
}