
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

class Solution1 
{
    public boolean searchMatrix(int[][] mat, int target) 
    {
        // linearSearch (brute)
        // O(n*m)
        int row=mat.length;
        int column=mat[0].length;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
            {
                if(mat[i][j]==target)
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
    public boolean searchMatrix(int[][] mat, int target) 
    {
        // better
        // O(n+logm)
        // binarySearch only in  desired column
        int row=mat.length;
        int column=mat[0].length;
        for(int i=0;i<row;i++)
        {
            if(mat[i][0]<=target && mat[i][column-1]>=target)
            {
                return binarySearch(mat[i],target);
            }
        }
        return false;
    }
    public boolean binarySearch(int[] mat, int target)
    {
        int low=0;
        int high=mat.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(mat[mid]==target)
            {
                return true;
            }
            else if(mat[mid]<target)
            {
                low=mid+1;
            }
            else 
            {
                high=mid-1;
            }            
        }
        return false;
    }
}

class Solution3 
{
    public boolean searchMatrix(int[][] mat, int target) 
    {
        // optimal
        // O(log n + log m) == log(n*m)
        // complete binarySearch 
        int row=mat.length;
        int column=mat[0].length;
        int low1=0;
        int high1=row-1;
        while(low1<=high1)
        {
            int mid1=low1+(high1-low1)/2;
            if(mat[mid1][column-1]<target)
            {
                low1=mid1+1;
            }
            else if(mat[mid1][0]>target)
            {
                high1=mid1-1;
            }
            else 
            {
                int low2=0;
                int high2=column-1;
                while(low2<=high2)
                {
                    int mid2=low2+(high2-low2)/2;
                    if(mat[mid1][mid2]==target)
                    {
                        return true;
                    }
                    else if(mat[mid1][mid2]>target)
                    {
                        high2=mid2-1;
                    }
                    else
                    {
                        low2=mid2+1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}

class Solution4 
{
    public boolean searchMatrix(int[][] mat, int target) 
    {
        // optimal (flattening into 1D array)
        // log(n*m)
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
