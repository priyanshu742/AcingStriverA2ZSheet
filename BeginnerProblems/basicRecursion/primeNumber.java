package BeginnerProblems.basicRecursion;

/*

Given an integer num, return true if it is prime otherwise false.
A prime number is a number that is divisible only by 1 and itself.

Example 1:
Input : num = 5
Output : true
Explanation : The factors of 5 are 1 and 5 only.
So it satisfies the prime number condition.

Example 2:
Input : num = 15
Output : false
Explanation : The factors of 15 are 1, 3, 5, 15 only.
As the number has factors other than 1 and itself, So it is not a prime number.


Constraints:
1 <= num <= 104

EASY
*/

class Solution 
{
    public boolean checkPrime(int num) 
    {
        if(num<=1)
        {
            return false;
        }
        if(num==2)
        {
            return true;
        }
        return check(2,num);
    }
    public boolean check(int i,int num) 
    {
        if(i*i>num)
        {
            return true;
        }
        if(num%i==0)
        {
            return false;
        }
        return check(i+1,num);
    }
}
