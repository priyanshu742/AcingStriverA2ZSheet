package BinarySearch.BSOn2DArrays;

/*

Given a 0-indexed n x m matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the array [i, j].
A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbours to the left, right, top, and bottom.
Assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

Note: As there can be many peak values, 1 is given as output if the returned index is a peak number, otherwise 0.


Example 1
Input: mat=[[10, 20, 15], [21, 30, 14], [7, 16, 32]]
Output: [1, 1]
Explanation: The value at index [1, 1] is 30, which is a peak element because all its neighbours are smaller or equal to it. 
Similarly, {2, 2} can also be picked as a peak.

Example 2
Input: mat=[[10, 7], [11, 17]]
Output : [1, 1]
Explanation:The value at index [1, 1] is 17, which is the only peak element because all its neighbours are smaller or equal to it.


Constraints
n == mat.length
m == mat[i].length
1 <= m, n <= 500
1 <= mat[i][j] <= 105
No two adjacent cells are equal

MEDIUM
*/

class Solution 
{
    public int[] findPeakGrid(int[][] mat) 
    {
        int row=mat.length;
        int column=mat[0].length;
        int low=0;
        int high=column-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int maxRowIndex=maxElement(mat,row,mid);
            int left=-1;
            int right=-1;

            if(mid-1>=0)
            {
                left=mat[maxRowIndex][mid-1];
            }
            if(mid+1<column)
            {
                right=mat[maxRowIndex][mid+1];
            }

            int element=mat[maxRowIndex][mid];
            if(element>left && element>right)
            {
                return new int[]{maxRowIndex,mid};
            }
            else if(element<left)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return new int[]{-1,-1};
    }

    public int maxElement(int [][]mat,int row,int column)
    {
        int max=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<row;i++)
        {
            if(mat[i][column]>max)
            {
                max=mat[i][column];
                index=i;
            }
        }
        return index;
    }
}
