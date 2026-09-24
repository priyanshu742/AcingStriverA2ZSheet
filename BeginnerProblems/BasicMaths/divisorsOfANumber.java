package BeginnerProblems.basicMaths;

import java.util.ArrayList;

/*

You are given an integer n. You need to find all the divisors of n. Return all the divisors of n as an array or list in a sorted order.

A number which completely divides another number is called it's divisor.

Example 1:
Input: n = 6
Output = [1, 2, 3, 6]
Explanation: The divisors of 6 are 1, 2, 3, 6.

Example 2:
Input: n = 8
Output: [1, 2, 4, 8]
Explanation: The divisors of 8 are 1, 2, 4, 8


Constraints:
1 <= n <= 1000

EASY
*/

class Solution 
{
    public int[] divisors(int n) 
    {
        ArrayList<Integer> arr=new ArrayList<>();
        int i;
        for(i=1;i*i<=n;i++)
        {
            if(n%i==0)
            {
                arr.add(i);
            }
        }
        for(i=i-1;i>=1;i--)
        {
            if(n%i==0)
            {
               if(n/i!=i)
                {
                    arr.add(n/i); 
                }
            }
        }
        int result[]=new int[arr.size()];
        for(int j=0;j<arr.size();j++)
        {
            result[j]=arr.get(j);
        }
        return result;
    }
}