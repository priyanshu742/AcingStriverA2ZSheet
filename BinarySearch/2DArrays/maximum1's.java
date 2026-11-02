/*

Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in ascending order, 
find the index of the row with the maximum number of ones.
If two rows have the same number of ones, consider the one with a smaller index. 
If no 1 exists in the matrix, return -1.

Example 1
Input : mat = [ [1, 1, 1], [0, 0, 1], [0, 0, 0] ]
Output: 0
Explanation: The row with the maximum number of ones is 0 (0 - indexed).

Example 2
Input: mat = [ [0, 0], [0, 0] ]
Output: -1
Explanation: The matrix does not contain any 1. So, -1 is the answer.


Constraints
n == mat.length  
m == mat[i].length 
1 <= n, m <= 100 
mat[i][j] is either 0 or 1.

EASY
*/

class Solution1
{
    public int rowWithMax1s(int[][] mat) 
    {
        // brute
        int ans=-1;
        int largest=0;
        int row=mat.length;
        int column=mat[0].length;
        for(int i=0;i<row;i++)
        {
            int count=0;
            for(int j=0;j<column;j++)
            {
                if(mat[i][j]==1)
                {
                    count++;
                }
            }
            if(count>largest)
            {
                largest=count;
                ans=i;
            }
        }
        return ans;
    }
}

class Solution2
{
    public int rowWithMax1s(int[][] mat) 
    {
        // brute
        int ans=-1;
        int largest=0;
        int row=mat.length;
        int column=mat[0].length;
        for(int i=0;i<row;i++)
        {
            int count=0;
            for(int j=0;j<column;j++)
            {
                count=count+mat[i][j];
                
            }
            if(count>largest)
            {
                largest=count;
                ans=i;
            }
        }
        return ans;
    }
}

class Solution3
{
    public int rowWithMax1s(int[][] mat) 
    {
        // optimal
        int ans=-1;
        int largest=0;
        int row=mat.length;
        int column=mat[0].length;
        for(int i=0;i<row;i++)
        {
            int count=0;
            int low=0;
            int high=column-1;
            while(low<=high)
            {
                int mid=low+(high-low)/2;
                if(mat[i][mid]==1)
                {
                    count=column-mid;
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            if(count>largest)
            {
                largest=count;
                ans=i;
            }
        }
        return ans;
    }
}

class Solution4
{
    public int rowWithMax1s(int[][] mat) 
    {
        // optimal
        int ans=-1;
        int largest=0;
        int row=mat.length;
        int column=mat[0].length;
        for(int i=0;i<row;i++)
        {
            int count=column-firstOccurence(mat[i],column,1);
            if(count>largest)
            {
                largest=count;
                ans=i;
            }
        }
        return ans;
    }
    public int firstOccurence(int[] column,int length,int target)
    {
        int low=0;
        int high=length-1;
        int ans=column.length;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(column[mid]==target)
            {
                ans=mid;
                high=mid-1;
            }
            else if(column[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    } 
}