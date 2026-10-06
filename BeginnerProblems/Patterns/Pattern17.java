package BeginnerProblems.Patterns;

/*

Given an integer n. You need to recreate the pattern given below for any value of N. 
Let's say for N = 5, the pattern should look like as below:

    A
   ABA
  ABCBA
 ABCDCBA
ABCDEDCBA

Print the pattern in the function given to you.


Constraints
1 <= n <= 26

EASY
*/

class Solution1 
{
    public void pattern17(int n) 
    {
        for(int i=1; i<=n; i++)
        {
            // space
            for(int s=1 ; s<=(n-i); s++)
            {
                System.out.print(" ");
            }
            // forward character
            for(int j=1 ; j<=i; j++)
            {
                System.out.print((char)(65 + (j-1)));
            }
            // reverse character
            for(int k=i-1 ; k>=1; k--)
            {
                System.out.print((char)(65 + (k-1)));
            }
            System.out.println();  
        }
    }
}

class Solution2
{
    public void pattern17(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            int count=0;
            //space
            for(int s=1;s<=n-i;s++)
            {
                System.out.print(" ");
            }
            // forward character
            for(int j=1;j<=i;j++)
            {
                System.out.print((char)('A'+j-1));
                count++;
            }
            // reverse character
            count--;
            for(int j=1;j<i;j++)
            {
                System.out.print((char)('A'+count-1));
                count--;
            }
            System.out.println();
        }
    }
}
    
class Solution3
{
    public void pattern17(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            // space
            for(int s=1;s<=n-i;s++)
            {
                System.out.print(" ");
            }
            // forward character
            for(char ch='A';ch<'A'+i;ch++)
            {
                System.out.print(ch);
            }
            // reverse character
            for(char ch=(char)('A'+i-2);ch>='A';ch--)
            {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

class Solution4 
{
    public void pattern17(int n) 
    {
        for(int i=1;i<=n;i++)
        {
            //space
            for(int s=1;s<=n-i;s++)
            {
                System.out.print(" ");
            }
            // characters
            char ch='A';
            for(int j=1;j<=(2*i)-1;j++)
            {
                System.out.print(ch);
                if(j<i)
                {
                    ch++;
                }
                else
                {
                    ch--;
                }
            }
            System.out.println();
        }
    }
}
