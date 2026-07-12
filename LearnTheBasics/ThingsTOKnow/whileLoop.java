



/*

Given a digit d (0 to 9), find the sum of the first 50 positive integers (integers > 0) that end with digit d.



A number ends with digit d if its last digit is d.


Example 1

Input: d = 1

Output: 12300

Explanation:

The first 50 positive integers ending with 1 are: 1, 11, 21, 31, ..., 491

Their sum is 12300.

Example 2

Input: d = 5

Output: 12500




Constraints

0 <= d <= 9

*/



package LearnTheBasics.ThingsTOKnow;

class Solution 
{
    public int whileLoop(int d)
    {
        // Your code goes here
        int sum=0;
        int num=0;
        
        int count=1;

        while(count<=50)
        {
            if(num%10==d)
            {
                sum=sum+num;
                count++;
            }
            num++;
        }
        return sum;
    }
}
    

