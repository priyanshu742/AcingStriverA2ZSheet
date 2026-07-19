package LearnTheBasics.KnowBasicMaths;

/*

You are given an integer n. You need to check if the number is prime or not. Return true if it is a prime number, otherwise return false.

A prime number is a number which has no divisors except 1 and itself.


Example 1
Input: n = 5
Output: true
Explanation: The only divisors of 5 are 1 and 5 , So the number 5 is prime.

Example 2
Input: n = 8
Output: false
Explanation: The divisors of 8 are 1, 2, 4, 8, thus it is not a prime number.


Constraints
1 <= n <= 5000

*/

class Solution 
{
    public boolean isPrime(int n) 
    {
        //your code goes here
        int flag=1;
        for(int i=2 ; i<=n/2 ; i++)
        {
            if(n%i==0)
            {
                flag=0;
                break;
            }
        }
        if(flag==1)
        {
            return true;
        }
        else 
        {
            return false;
        }

    }
}
    

