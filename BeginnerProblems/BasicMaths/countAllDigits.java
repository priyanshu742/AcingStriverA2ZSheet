package BeginnerProblems.basicMaths;



/*

You are given an integer n. You need to return the number of digits in the number.
The number will have no leading zeroes, except when the number is 0 itself.

Example 1
Input: n = 4
Output: 1
Explanation: There is only 1 digit in 4.

Example 2
Input: n = 14
Output: 2
Explanation: There are 2 digits in 14.


Constraints
0 <= n <= 5000
n will contain no leading zeroes except when it is 0 itself.

EASY
*/

class Solution1 
{
    public int countDigit(int n) 
    {
        if(n==0)
        {
            return 1;
        }
        int count=0;
        while(n!=0)
        {
            count++;
            n=n/10;
        }
        return count;
    }
}

class Solution2 
{
    public int countDigit(int n) 
    {
        //optimal
        if(n==0)
        {
            return 1;
        }
        int count=(int) Math.log10(n)+1 ;
        return count;
    }
}