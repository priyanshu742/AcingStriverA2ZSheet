package BinarySearch.OnAnswers;

/*

You are given A painters and an array C of N integers where C[i] denotes the length of the ith board. 
Each painter takes B units of time to paint 1 unit of board. You must assign boards to painters such that:

Each painter paints only contiguous segments of boards.
No board can be split between painters.
The goal is to minimize the time to paint all boards.

Return the minimum time required to paint all boards modulo 10000003.

Example 1
Input: A = 2, B = 5, C = [1, 10]
Output: 50
Explanation:
Painter 1 paints board 0 (length = 1), time = 5
Painter 2 paints board 1 (length = 10), time = 50
Max time = 50
Return 50 % 10000003 = 50

Example 2
Input: A = 10, B = 1, C = [1, 8, 11, 3]
Output: 11
Explanation:
Assign each board to a different painter
Max time = max(1, 8, 11, 3) = 11
Return 11 % 10000003 = 11


Constraints
1 <= A <= 1000
1 <= B <= 106
1 <= N <= 105
1 <= C[i] <= 106

MEDIUM   
*/

class Solution1 
{
    public int paint(int A, int B, int[] C) 
    {
        // binarySearch
        long low=Integer.MIN_VALUE;
        long high=0;
        long ans=-1;
        for(int n : C)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        while(low<=high)
        {
            long mid=low+(high-low)/2;
            int noOfpainters=calculate(C,mid);
            if(noOfpainters<=A)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return(int) (((long)ans*B)%10000003); 
    }
    public int calculate(int[] C,long length)
    {
        int painters=1;
        long total=0;
        for(int i=0;i<C.length;i++)
        {
            if(total+C[i]<=length)
            {
                total=total+C[i];
            }
            else
            {
                painters++;
                total=C[i];
            }
        }
        return painters;
    } 
}

class Solution2 
{
    public int paint(int A, int B, int[] C) 
    {
        // linearSearch
        long low=Integer.MIN_VALUE;
        long high=0;
        long ans=-1;
        for(int n : C)
        {
            high=high+n;
            if(n>low)
            {
                low=n;
            }
        }
        for(long i=low;i<=high;i++)
        {
            int noOfpainters=calculate(C,i);
            if(noOfpainters<=A)
            {
                ans=i;
                break;
            }
        }
        return(int) (((long)ans*B)%10000003);
    }
    public int calculate(int[] C,long length)
    {
        int painters=1;
        long total=0;
        for(int i=0;i<C.length;i++)
        {
            if(total+C[i]<=length)
            {
                total=total+C[i];
            }
            else
            {
                painters++;
                total=C[i];
            }
        }
        return painters;
    } 
}