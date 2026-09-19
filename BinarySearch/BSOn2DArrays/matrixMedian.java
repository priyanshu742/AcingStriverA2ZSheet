package BinarySearch.BSOn2DArrays;

/*

Given a 2D array matrix that is row-wise sorted. The task is to find the median of the given matrix.

Example 1
Input: matrix=[ [1, 4, 9], [2, 5, 6], [3, 7, 8] ] 
Output: 5
Explanation: If we find the linear sorted array, the array becomes 1 2 3 4 5 6 7 8 9. So, median = 5

Example 2
Input: matrix=[ [1, 3, 8], [2, 3, 4], [1, 2, 5] ] 
Output: 3
Explanation: If we find the linear sorted array, the array becomes 1 1 2 2 3 3 4 5 8. So, median = 3


Constraints
N==matrix.size
M==matrix[0].size
1 <= N, M <= 105
1 <= N*M <= 106
1 <= matrix[i] <= 109
N*M is odd

MEDIUM
*/

class Solution 
{
    public int findMedian(int[][] matrix) 
    {
        // optimal
        int row=matrix.length;
        int column=matrix[0].length;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        int required=(row*column)/2;

        for(int i=0;i<row;i++)
        {
            low=Math.min(low,matrix[i][0]);
            high=Math.max(high,matrix[i][column-1]);
        }
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int smallerElements=countSmallEquals(matrix,mid,row,column);
            if(smallerElements<=required)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return low;
    }
    public int countSmallEquals(int [][]mat,int element,int row,int column)
    {
        int count=0;
        for(int i=0;i<row;i++)
        {
            count=count+upperBound(mat[i],element);
        }
        return count;
    }
    public int upperBound(int []mat,int element)
    {
        int low=0;
        int high=mat.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(mat[mid]>element)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}