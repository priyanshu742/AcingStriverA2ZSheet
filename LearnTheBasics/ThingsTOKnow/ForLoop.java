

/* 

Given two integers low and high, return the sum of all integers from low to high inclusive.


Example 1

Input: low = 1, high = 5

Output: 15

Explanation: 1 + 2 + 3 + 4 + 5 = 15

Example 2

Input: low = 3, high = 7

Output: 25

Explanation: 3 + 4 + 5 + 6 + 7 = 25




Constraints

0 <= low <= high <= 100


*/

package LearnTheBasics.ThingsTOKnow;

class Solution 
{
    public int forLoop(int low, int high) 
    {
        int sum=0;
        for(int i=low;i<=high;i++)
        {
            sum=sum+i;
        }
        return sum;
    }
}
    



