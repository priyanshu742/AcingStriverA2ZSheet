import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution 
{
    public int pascalTriangleI(int r, int c) 
    {
        int n=r-1;
        int k=c-1;

        int result=1;

        for(int i=0;i<k;i++)
        {
            result=result*(n-i);
            result=result/(i+1);
        }
        return result;
    }
}

public class demo
{
    public static void main(String[] args) 
    {
        Solution s1= new Solution();
        int nums[] = {1, 2, 1, 1, 3, 2};

        int result=s1.pascalTriangleI(4,2);

        System.out.println(result);

       
    }
}