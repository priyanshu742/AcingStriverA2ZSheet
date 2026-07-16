package LearnTheBasics.KnowBasicMaths;



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


*/



class Solution 
{
    public int countDigit(int n) 
    { 
        int d=0;
        while(n!=0)
        {
            d= d+ 1;
            n=n/10;
        }
        return d;
    }
}