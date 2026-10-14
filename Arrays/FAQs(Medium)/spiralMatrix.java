package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;


/* 

Given an M * N matrix, print the elements in a clockwise spiral manner.
Return an array with the elements in the order of their appearance when printed in a spiral manner.

Example 1
Input: matrix = [[1, 2, 3], [4 ,5 ,6], [7, 8, 9]]
Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]
Explanation:
The elements in the spiral order are 1, 2, 3 -> 6, 9 -> 8, 7 -> 4, 5

Example 2
Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8]]
Output: [1, 2, 3, 4, 8, 7, 6, 5]
Explanation:
The elements in the spiral order are 1, 2, 3, 4 -> 8, 7, 6, 5


Constraints
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100

EASY
*/

class Solution 
{
    public List<Integer> spiralOrder(int[][] matrix) 
    {
        // optimal approach
        //right -> bottom -> left -> top
        int rowLength=matrix.length;
        int columnLength=matrix[0].length;
        int top=0;
        int bottom=rowLength-1;
        int left=0;
        int right=columnLength-1;
        List<Integer> result=new ArrayList<>();
        while(top<=bottom && left<=right)
        {
            // moving right
            for(int i=left;i<=right;i++)
            {
                result.add(matrix[top][i]);
            }
            top++;
            // moving bottom
            for(int i=top;i<=bottom;i++)
            {
                result.add(matrix[i][right]);
            }
            right--;
            // moving left
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--)
                {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // moving top
            if(left<=right)
            {
                for(int i=bottom;i>=top;i--)
                {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}