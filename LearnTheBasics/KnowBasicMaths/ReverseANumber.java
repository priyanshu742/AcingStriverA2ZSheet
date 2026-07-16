package LearnTheBasics.KnowBasicMaths;



/*


You are given an integer n. Return the integer formed by placing the digits of n in reverse order.


Example 1
Input: n = 25
Output: 52
Explanation: Reverse of 25 is 52.


Example 2
Input: n = 123
Output: 321
Explanation: Reverse of 123 is 321.


Constraints
0 <= n <= 5000
n will contain no leading zeroes except when it is 0 itself.


*/



class Solution 
{
    public int reverseNumber(int n) 
    {
        int rev=0;
        int d=0;
        while(n!=0)
        {
            d=n%10;
            rev= rev*10 + d;
            n=n/10;
        }
        return rev;
    }
}
    

