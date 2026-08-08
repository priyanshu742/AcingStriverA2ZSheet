package ArrayProblems.Medium;

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


class Solution 
{
    public void rotateMatrix(int[][] matrix) 
    {
        // OPTIMAL 
        int n=matrix.length;

        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        for(int row[]:matrix)
        {
            int start=0;
            int end=n-1;
            while(start<end)
            {
                int temp=row[start];
                row[start]=row[end];
                row[end]=temp;
                start++;
                end--;
            }
        }
    }
}
