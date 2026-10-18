
/* 

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0. 
You must do it in place.

Example 1
Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Explanation:
Element at position (1,1) is 0, so set entire row 1 and column 1 to 0.

Example 2
Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
Explanation:
There are two zeroes: (0,0) and (0,3).
Row 0 → all elements become 0
Column 0 and column 3 → all elements become 0


Constraints
m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1

EASY
*/

class Solution1 
{
    public void setZeroes(int[][] matrix) 
    {
        // brute
        int row=matrix.length;
        int column=matrix[0].length;
        // marking
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(matrix[i][j]==0)
                {
                    markRow(matrix,i);
                    markColumn(matrix,j);
                }
            }
        }
        // changing
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(matrix[i][j]==Integer.MIN_VALUE)
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
    public void markRow(int [][] matrix,int row)
    {
        for(int i=0;i<matrix[0].length;i++)
        {
            if(matrix[row][i]!=0)
            {
                matrix[row][i]=Integer.MIN_VALUE; 
            }
        }
    }
    public void markColumn(int [][] matrix,int column)
    {
        for(int i=0;i<matrix.length;i++)
        {
            if(matrix[i][column]!=0)
            {
                matrix[i][column]=Integer.MIN_VALUE;
            }
        }
    }
}

class Solution2
{
    public void setZeroes(int[][] matrix) 
    {
        // better
        int m=matrix.length;
        int n=matrix[0].length;
        int row[]=new int[m];
        int column[]=new int[n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    row[i]=1;
                    column[j]=1;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(row[i]==1 || column[j]==1)
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}

class Solution3 
{
    public void setZeroes(int[][] matrix) 
    {
        // optimal
        int m=matrix.length;
        int n=matrix[0].length;
        // int row[]=new int[m]; -> matrix[0][..]
        // int column[]=new int[n]; -> matrix[..][0]
        int col0=1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                {
                    // mark the i-th row 
                    matrix[i][0]=0;
                    // mark the j-th column
                    if(j!=0)
                    {
                        matrix[0][j]=0;
                    }
                    else
                    {
                        col0=0;
                    }
                }
            }
        }
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
               if(matrix[i][j]!=0)
               {
                    if(matrix[0][j]==0 || matrix[i][0]==0)
                    {
                        matrix[i][j]=0;
                    }
               } 
            }
        }
        if(matrix[0][0]==0)
        {
            for(int j=0;j<n;j++)
            {
                matrix[0][j]=0;
            }
        }
        if(col0==0)
        {
            for(int i=0;i<m;i++)
            {
                matrix[i][0]=0;
            }
        }
    }
}