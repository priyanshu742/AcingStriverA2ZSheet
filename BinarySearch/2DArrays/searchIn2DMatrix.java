package BinarySearch.BSOn2DArrays;

/*
 
Given a 2-D array mat where the elements of each row are sorted in non-decreasing order, 
and the first element of a row is greater than the last element of the previous row (if it exists), and an integer target, 
determine if the target exists in the given mat or not.

Example 1
Input: mat = [ [1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12] ], target = 8
Output: True
Explanation: The target = 8 exists in the 'mat' at index (1, 3).

Example 2
Input: mat = [ [1, 2, 4], [6, 7, 8], [9, 10, 34] ], target = 78
Output: False
Explanation: The target = 78 does not exist in the 'mat'. Therefore in the output, we see 'false'.


Constraints
n == mat.length
m == mat[i].length
1 <= m, n <= 100
-104 <= mat[i][j], target <= 104

EASY
*/

class Solution 
{
    public boolean searchMatrix(int[][] mat, int target)
    { 
        // log(n*m) (optimal)
        int n=mat.length;
        int m=mat[0].length;
        int low=0;
        int high=(n*m)-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int row=mid/m;
            int column=mid%m;
            if(mat[row][column]==target)
            {
                return true;
            }
            else if(mat[row][column]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return false;
    }
}

