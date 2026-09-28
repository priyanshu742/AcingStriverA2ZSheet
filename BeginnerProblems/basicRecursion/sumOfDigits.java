package BeginnerProblems.basicRecursion;

/*

Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.

Example 1:
Input : num = 529
Output : 7
Explanation : In first iteration the digits sum will be = 5 + 2 + 9 => 16
In second iteration the digits sum will be 1 + 6 => 7.
Now single digit is remaining , so we return it.

Example 2:
Input : num = 101
Output : 2
Explanation : In first iteration the digits sum will be = 1 + 0 + 1 => 2
Now single digit is remaining , so we return it.


Constraints:
0 <= num <= 231 - 1

EASY
*/

class Solution1
{
    public int addDigits(int num) 
    {
        // recursion
        if(num<10)
        {
            return num;
        }
        int sum=sumDigits(num);
        return addDigits(sum);
    }
    public int sumDigits(int num)
    {
        if(num<=0)
        {
            return 0;
        }
        int digit=num%10;
        return digit+sumDigits(num/10);
    }
}

class Solution2
{
    public int addDigits(int num) 
    {
        // optimal recursion
        if(num<10)
        {
            return num;
        }
        return addDigits((num/10)+(num%10));
    }
}

class Solution3
{
    public int addDigits(int num) 
    {
        // interative
        while(num>=10)
        {
            int sum=0;
            while(num!=0)
            {
                int digit=num%10;
                sum=sum+digit;
                num=num/10;
            }
            num=sum;
        }
        return num;
    }
}

class Solution4
{
    // most optimal
    public int addDigits(int num) 
    {
        if(num==0)
        {
            return 0;
        }
        if(num%9==0)
        {
            return 9;
        }
        return num%9;
    }
}