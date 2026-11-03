

/*

Given a 2D array matrix where each row is sorted in ascending order from left to right and each column is sorted in ascending order from top to bottom,
write an efficient algorithm to search for a specific integer target in the matrix.

Example 1
Input: matrix = [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30] ], target = 5
Output: True
Explanation: The target 5 exists in the matrix in the index (1,1)

Example 2
Input: matrix= [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14, 17, 24], [18, 21, 23, 26, 30] ], target = 20
Output: False
Explanation: The target 20 does not exist in the matrix.


Constraints
n == matrix.length
m == matrix[i].length
1 <= n, m <= 300
-109 <= matrix[i][j] <= 109
All the integers in each row are sorted in ascending order.
All the integers in each column are sorted in ascending order.
-109 <= target <= 109

EASY
*/

class Solution1
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        // brute
        // linearSearch
        int row=matrix.length;
        int column=matrix[0].length;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(matrix[i][j]==target)
                {
                    return true;
                }
            }
        }
        return false;
    }
}

class Solution2 
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        // better
        int row=matrix.length;
        int column=matrix[0].length;
        for(int i=0;i<row;i++)
        {
            if(matrix[i][0]<=target && matrix[i][column-1]>=target)
            {
                if(binarySearch(matrix[i],target)==1)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public int binarySearch(int[] matrix, int target) 
    {
        int low=0;
        int high=matrix.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(matrix[mid]==target)
            {
                return 1;
            }
            else if(matrix[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }
}

class Solution3
{
    public boolean searchMatrix(int[][] matrix, int target) 
    {
        // optimal
        int n=matrix.length;
        int m=matrix[0].length;
        int row=0;
        int column=m-1;
        while(row<n && column>=0)
        {
            if(matrix[row][column]==target)
            {
                return true;
            }
            else if(matrix[row][column]<target)
            {
                row++;
            }
            else
            {
                column--;
            }
        }
        return false;
    }
}