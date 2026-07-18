package LearnTheBasics.KnowBasicMaths;


/*

You are given an integer n. You need to check whether it is an armstrong number or not. Return true if it is an armstrong number, otherwise return false.

An armstrong number is a number which is equal to the sum of the digits of the number, raised to the power of the number of digits.

Example 1
Input: n = 153
Output: true
Explanation: Number of digits : 3.
13 + 53 + 33 = 1 + 125 + 27 = 153.
Therefore, it is an Armstrong number.


Example 2
Input: n = 12
Output: false
Explanation: Number of digits : 2.
12 + 22 = 1 + 4 = 5.
Therefore, it is not an Armstrong number.Constraints


Constraints
0 <= n <= 109

*/



class Solution 
{
    public boolean isArmstrong(int n) 
    {
        int check=n;
        int pseudo=n;
        int arm=0;
        int digit=0;
        int totalDigit=0;

        while(pseudo!=0)
        {
            digit=pseudo%10;
            totalDigit++;
            pseudo=pseudo/10;
        }

        while(n!=0)
        {
            digit=n%10;
            arm=arm+((int)Math.pow(digit,totalDigit));
            n=n/10;
        }
        if(arm==check)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
    

