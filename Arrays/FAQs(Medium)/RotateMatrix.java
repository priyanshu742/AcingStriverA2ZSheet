

/* 

Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
The rotation must be done in place, meaning the input 2D matrix must be modified directly.

Example 1
Input: matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
Output: matrix = [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

Example 2
Input: matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]
Output: matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]


Constraints
n == matrix.length.
n == matrix[i].length.
1 <= n <= 100.
-104 <= matrix[i][j] <= 104

EASY
*/

class Solution1
{
    public void rotateMatrix(int[][] matrix) 
    {
        // brute
        int n=matrix.length;
        int result[][]=new int[n][n];
        //cloning a matrix
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                result[i][j]=matrix[i][j];
            }
        }
        // changing the values
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[j][(n-1)-i]=result[i][j];
            }
        }
    }
}

class Solution2
{
    public void rotateMatrix(int[][] matrix) 
    {
        // optimal
        int n=matrix.length;
        // traspose of matrix;
        for(int i=0;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        // reversing every row
        for(int row[]: matrix)
        {
            int low=0;
            int high=n-1;
            while(low<high)
            {
                int temp=row[low];
                row[low]=row[high];
                row[high]=temp;
                low++;
                high--;
            }
        }
    }
}